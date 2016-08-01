package com.infinite.framework.service;

import com.infinite.framework.entity.Application;

/**
 * @author by hx on 16-7-25.
 * @since 1.0
 */
public interface ApplicationService {

    public Application createApplication(String name);

    public Application updateApplication(Application application);

}
