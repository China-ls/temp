package com.infinite.framework.auth.dao;

import com.infinite.framework.core.util.JsonUtil;
import com.infinite.framework.core.persistent.AbstractMongoDAO;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by hx on 16-7-5.
 */
public class MongoSessionDAO extends AbstractMongoDAO implements IShiroSessionDAO {

    public Serializable create(Session session) {
        logger.debug("cretae session : " , JsonUtil.toJson(session));
        return null;
    }

    public Session readSession(Serializable sessionId) throws UnknownSessionException {
        logger.debug("readSession : " , sessionId);
        return null;
    }

    public void update(Session session) throws UnknownSessionException {
        logger.debug("update : " , session);
    }

    public void delete(Session session) {
        logger.debug("delete : " , session);
    }

    public Collection<Session> getActiveSessions() {
        logger.debug("getActiveSessions");
        return null;
    }
}
