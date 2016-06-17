package com.infinite.core.spring.repository.mongodb;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

/**
 * Created by hx on 16-6-14.
 */
public class BasicMongoDAO<T, K> extends BasicDAO<T, K> implements IMongoDAO<T, K> {
    public BasicMongoDAO(Class<T> entityClass, MongoClient mongoClient, Morphia morphia, String dbName) {
        super(entityClass, mongoClient, morphia, dbName);
    }

    public BasicMongoDAO(Class<T> entityClass, Datastore ds) {
        super(entityClass, ds);
    }

    protected BasicMongoDAO(MongoClient mongoClient, Morphia morphia, String dbName) {
        super(mongoClient, morphia, dbName);
    }

    protected BasicMongoDAO(Datastore ds) {
        super(ds);
    }
}
