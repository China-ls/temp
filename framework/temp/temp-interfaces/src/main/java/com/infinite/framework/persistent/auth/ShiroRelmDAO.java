package com.infinite.framework.persistent.auth;

import com.infinite.framework.persistent.MorphiaDAO;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

/**
 * @author by hx on 16-6-16.
 * @since 1.0
 */
public class ShiroRelmDAO extends MorphiaDAO<ShiroRelm,ObjectId> {
    public ShiroRelmDAO(Datastore ds) {
        super(ds);
    }
}
