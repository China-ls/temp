package com.ls.test.mongo;

import com.infinite.framework.entity.EntityConst;
import com.infinite.framework.entity.VirtualSensor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.junit.Test;

/**
 * Created by hx on 16-7-7.
 */
public class MongoTest {

    @Test
    public void testInsertObjectAndGet() {
//        System.out.println(
//                Filters.and(
//                        Filters.eq(EntityConst.FieldName.AccountFN.NAME, "ceshi"),
//                        Filters.elemMatch(
//                                EntityConst.FieldName.AccountFN.APPLICATIONS,
//                                Filters.eq(EntityConst.FieldName.ApplicationFN.NAME, "test_app"))
//                ).toBsonDocument(Document.class, MongoClient.getDefaultCodecRegistry()).toJson()
//        );


        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase("temp");
        MongoCollection<Document> collection = db.getCollection("temp");

//        Account account = new Account();
//        account.setName("ceshi");
//        account.setId("abc");
//
//        Application application = new Application();
//        application.setName("test_app");
//
//        VirtualSensor sensor = new VirtualSensor();
//        sensor.setName("v1");
//        sensor.setId("v1");
//
//        application.addSensors(sensor);
//
//        account.addApplications(application);
//
//        collection.drop();
//        collection.insertOne(account.toDocument());

        FindIterable<VirtualSensor> findIterable = collection.find(
                Filters.elemMatch(
                        EntityConst.FieldName.AccountFN.APPLICATIONS,
                        Filters.elemMatch(
                                EntityConst.FieldName.ApplicationFN.SENSORS,
                                Filters.eq(EntityConst.FieldName.VirtualSensorFN.NAME, "v1"))
                ),
                VirtualSensor.class
        );
        findIterable.projection(Projections.include(
                EntityConst.FieldName.AccountFN.getFields()
        ));
        MongoCursor<VirtualSensor> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            VirtualSensor document = mongoCursor.next();
            System.out.println(document);
        }
    }

}
