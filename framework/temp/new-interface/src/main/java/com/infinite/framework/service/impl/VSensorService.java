package com.infinite.framework.service.impl;

import com.infinite.framework.core.persistent.IMongoDAO;
import com.infinite.framework.entity.Application;
import com.infinite.framework.entity.VirtualSensor;
import com.infinite.framework.service.IVSensorService;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author by hx on 16-7-26.
 */
@Service("VSensorService")
public class VSensorService implements IVSensorService {
    private static Logger log = LoggerFactory.getLogger(VSensorService.class);

    @Value("#{dbConfig.vsensor_mongo_name_db}")
    private String dbName;
    @Value("#{dbConfig.vsensor_mongo_name_collection}")
    private String collectionName;

    @Autowired
    private IMongoDAO mongoDAO;

    @Override
    public VirtualSensor createVSensor(/*String clientid,*/ String appid, VirtualSensor sensor) {
        MongoCollection<Document> collection = mongoDAO.getCollection(dbName, collectionName);
        Document documentApp = mongoDAO.findFirst(collection, Filters.eq("", appid));
        if (null == documentApp) {
            if (log.isDebugEnabled()) {
                log.debug("should not create Virtual Sensor because appkey [{}] not exsist!", appid);
            }
            return null;
        } else {
            Application application = new Application();
            application.fromDocument(documentApp);

            application.addSensors();

            Document findOneSensor = mongoDAO.findFirst(collection, Filters.eq("id", sensor.getId()));

            if (null != findOneSensor) {
                collection.findOneAndUpdate(Filters.eq("id", sensor.getId()), sensor.toDocument());
                collection.findOneAndReplace(Filters.eq("id", sensor.getId()), sensor.toDocument());
            } else {
                collection.insertOne(sensor.toDocument());
            }
            return sensor;
        }
    }

    @Override
    public VirtualSensor updateVSensor(VirtualSensor sensor) {
        return null;
    }

    @Override
    public VirtualSensor remveVSensor(String sensorId) {
        return null;
    }
}
