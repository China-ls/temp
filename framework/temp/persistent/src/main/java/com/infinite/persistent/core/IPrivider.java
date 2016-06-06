package com.infinite.persistent.core;

/**
 * Created by hx on 16-6-6.
 */
@SuppressWarnings({"all"})
public interface IPrivider<T> {

    public Class getMappedClass();

    public T get();

}
