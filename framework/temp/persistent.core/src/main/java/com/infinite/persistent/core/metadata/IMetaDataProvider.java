package com.infinite.persistent.core.metadata;


public interface IMetaDataProvider {

    public Class getMappedType();

    MetaDataProviderFactory getMetaDataProviderFactory();

    void setMetaDataProviderFactory(MetaDataProviderFactory metaDataProviderFactory);
}
