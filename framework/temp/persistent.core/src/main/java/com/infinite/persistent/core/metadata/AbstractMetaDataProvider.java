package com.infinite.persistent.core.metadata;

import javax.annotation.PreDestroy;

public abstract class AbstractMetaDataProvider implements IMetaDataProvider {
    private MetaDataProviderFactory metaDataProviderFactory;

    public MetaDataProviderFactory getMetaDataProviderFactory() {
        return metaDataProviderFactory;
    }

    public void setMetaDataProviderFactory(MetaDataProviderFactory metaDataProviderFactory) {
        this.metaDataProviderFactory = metaDataProviderFactory;
        this.metaDataProviderFactory.registProvider(this);
    }

    @PreDestroy
    public void destory() {
        metaDataProviderFactory.unregistProvider(this);
    }

}
