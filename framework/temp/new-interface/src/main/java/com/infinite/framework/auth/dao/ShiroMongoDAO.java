package com.infinite.framework.auth.dao;

import com.infinite.framework.core.persistent.AbstractMongoDAO;
import com.infinite.framework.core.util.JsonUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by hx on 16-7-5.
 */
public class ShiroMongoDAO extends AbstractMongoDAO implements IShiroSessionDAO {

    public Serializable create(Session session) {
        logger.debug(JsonUtil.toJson(session));
        return null;
    }

    public Session readSession(Serializable sessionId) throws UnknownSessionException {
        return null;
    }

    public void update(Session session) throws UnknownSessionException {

    }

    public void delete(Session session) {

    }

    public Collection<Session> getActiveSessions() {
        return null;
    }
}
