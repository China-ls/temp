package com.infinite.persistent.core.metadata;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hx on 16-6-6.
 */
public class CallMetaDataProviderFactory {
    /** List of supported database products for procedure calls */
    public static final List<String> supportedDatabaseProductsForProcedures = Arrays.asList(
            "Apache Derby",
            "DB2",
            "MySQL",
            "Microsoft SQL Server",
            "Oracle",
            "PostgreSQL",
            "Sybase"
    );

    /** List of supported database products for function calls */
    public static final List<String> supportedDatabaseProductsForFunctions = Arrays.asList(
            "MySQL",
            "Microsoft SQL Server",
            "Oracle",
            "PostgreSQL"
    );

    private static final Log logger = LogFactory.getLog(CallMetaDataProviderFactory.class);


    /**
     * Create a CallMetaDataProvider based on the database metadata
     * @param dataSource used to retrieve metadata
     * @param context the class that holds configuration and metadata
     * @return instance of the CallMetaDataProvider implementation to be used
     */
    static public CallMetaDataProvider createMetaDataProvider(DataSource dataSource, final CallMetaDataContext context) {
        try {
            return (CallMetaDataProvider) JdbcUtils.extractDatabaseMetaData(dataSource, new DatabaseMetaDataCallback() {
                @Override
                public Object processMetaData(DatabaseMetaData databaseMetaData) throws SQLException, MetaDataAccessException {
                    String databaseProductName = JdbcUtils.commonDatabaseName(databaseMetaData.getDatabaseProductName());
                    boolean accessProcedureColumnMetaData = context.isAccessCallParameterMetaData();
                    if (context.isFunction()) {
                        if (!supportedDatabaseProductsForFunctions.contains(databaseProductName)) {
                            if (logger.isWarnEnabled()) {
                                logger.warn(databaseProductName + " is not one of the databases fully supported for function calls " +
                                        "-- supported are: " + supportedDatabaseProductsForFunctions);
                            }
                            if (accessProcedureColumnMetaData) {
                                logger.warn("Metadata processing disabled - you must specify all parameters explicitly");
                                accessProcedureColumnMetaData = false;
                            }
                        }
                    }
                    else {
                        if (!supportedDatabaseProductsForProcedures.contains(databaseProductName)) {
                            if (logger.isWarnEnabled()) {
                                logger.warn(databaseProductName + " is not one of the databases fully supported for procedure calls " +
                                        "-- supported are: " + supportedDatabaseProductsForProcedures);
                            }
                            if (accessProcedureColumnMetaData) {
                                logger.warn("Metadata processing disabled - you must specify all parameters explicitly");
                                accessProcedureColumnMetaData = false;
                            }
                        }
                    }

                    CallMetaDataProvider provider;
                    if ("Oracle".equals(databaseProductName)) {
                        provider = new OracleCallMetaDataProvider(databaseMetaData);
                    }
                    else if ("DB2".equals(databaseProductName)) {
                        provider = new Db2CallMetaDataProvider((databaseMetaData));
                    }
                    else if ("Apache Derby".equals(databaseProductName)) {
                        provider = new DerbyCallMetaDataProvider((databaseMetaData));
                    }
                    else if ("PostgreSQL".equals(databaseProductName)) {
                        provider = new PostgresCallMetaDataProvider((databaseMetaData));
                    }
                    else if ("Sybase".equals(databaseProductName)) {
                        provider = new SybaseCallMetaDataProvider((databaseMetaData));
                    }
                    else if ("Microsoft SQL Server".equals(databaseProductName)) {
                        provider = new SqlServerCallMetaDataProvider((databaseMetaData));
                    }
                    else if ("HDB".equals(databaseProductName)) {
                        provider = new HanaCallMetaDataProvider((databaseMetaData));
                    }
                    else {
                        provider = new GenericCallMetaDataProvider(databaseMetaData);
                    }
                    if (logger.isDebugEnabled()) {
                        logger.debug("Using " + provider.getClass().getName());
                    }
                    provider.initializeWithMetaData(databaseMetaData);
                    if (accessProcedureColumnMetaData) {
                        provider.initializeWithProcedureColumnMetaData(databaseMetaData,
                                context.getCatalogName(), context.getSchemaName(), context.getProcedureName());
                    }
                    return provider;
                }
            });
        }
        catch (MetaDataAccessException ex) {
            throw new DataAccessResourceFailureException("Error retrieving database metadata", ex);
        }
    }
}
