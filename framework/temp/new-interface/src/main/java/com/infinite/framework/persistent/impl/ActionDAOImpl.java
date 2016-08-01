package com.infinite.framework.persistent.impl;

import com.infinite.framework.core.persistent.MorphiaDAO;
import com.infinite.framework.entity.Action;
import com.infinite.framework.persistent.ActionDAO;
import org.mongodb.morphia.Datastore;

public class ActionDAOImpl extends MorphiaDAO<Action, String> implements ActionDAO {
    public ActionDAOImpl(Datastore ds) {
        super(ds);
    }

}
