package com.infinite.framework.auth.realm;

import org.apache.shiro.session.mgt.SessionValidationScheduler;

/**
 * Created by hx on 16-7-5.
 */
public class MongoSessionValidationScheduler implements SessionValidationScheduler {
    public boolean isEnabled() {
        return true;
    }

    public void enableSessionValidation() {

    }

    public void disableSessionValidation() {

    }
}
