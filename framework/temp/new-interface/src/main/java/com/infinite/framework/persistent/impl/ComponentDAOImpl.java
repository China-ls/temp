package com.infinite.framework.persistent.impl;

import com.infinite.framework.core.persistent.MorphiaDAO;
import com.infinite.framework.entity.Component;
import com.infinite.framework.persistent.ComponentDAO;
import org.mongodb.morphia.Datastore;

public class ComponentDAOImpl extends MorphiaDAO<Component, String> implements ComponentDAO {
    public ComponentDAOImpl(Datastore ds) {
        super(ds);
    }

}
