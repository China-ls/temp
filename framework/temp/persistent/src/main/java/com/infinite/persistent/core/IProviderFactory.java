package com.infinite.persistent.core;

import com.infinite.persistent.core.metadata.IProvider;

public interface IProviderFactory {

    public void registProvider(IProvider provider);

    public void unregistProvider(IProvider provider);

    public IProvider getProvider();

}
