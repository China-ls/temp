package com.infinite.framework.persistent;

import com.infinite.framework.core.persistent.MorphiaDAO;
import com.infinite.framework.entity.Application;
import com.sun.org.apache.xpath.internal.operations.String;
import org.mongodb.morphia.Datastore;

public class ActionDAO extends MorphiaDAO<Application, String> {
    public ActionDAO(Datastore ds) {
        super(ds);
    }
}
