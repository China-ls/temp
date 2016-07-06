package com.infinite.framework.auth.token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by hx on 16-6-20.
 */
public class token implements AuthenticationToken {
    public Object getPrincipal() {
        return null;
    }

    public Object getCredentials() {
        return null;
    }
}
