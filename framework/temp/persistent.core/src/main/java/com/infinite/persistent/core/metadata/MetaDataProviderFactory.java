package com.infinite.persistent.core.metadata;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;

public class MetaDataProviderFactory {
    private final Log logger = LogFactory.getLog(MetaDataProviderFactory.class);

    private HashMap<Class, IMetaDataProvider> providerHashMap = new HashMap<Class, IMetaDataProvider>(0);

    public void registProvider(IMetaDataProvider provider) {
        if (providerHashMap.containsValue(provider)) {
            logger.warn("this provider has been registed :" + provider.getClass() );
        }
        providerHashMap.put(provider.getMappedType(), provider);
    }

    public void unregistProvider(IMetaDataProvider provider) {
        if (!providerHashMap.containsValue(provider)) {
            logger.warn("did not regist this provider :" + provider.getClass() );
        }
        providerHashMap.remove(provider.getMappedType());
    }

    public IMetaDataProvider getProvider(Class type) {
        return providerHashMap.get(type);
    }

}
