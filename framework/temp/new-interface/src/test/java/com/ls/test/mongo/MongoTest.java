package com.ls.test.mongo;

import com.infinite.framework.auth.entity.Account;
import com.infinite.framework.core.util.JsonUtil;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Test;

/**
 * Created by hx on 16-7-7.
 */
public class MongoTest {

    @Test
    public void testInsertObjectAndGet() {
//        MongoClient client = new MongoClient();
//        MongoDatabase db = client.getDatabase("temp");
//        MongoCollection<Document> collection = db.getCollection("temp");
//        collection.insertOne(new Document().append("_id", "abc").append("value", new AtomicInteger(3)));

        Account account = new Account();
        account.setObjectId(new ObjectId());
        account.setUsername("asdfasdf");
        account.setPassword("bbbb");

        Document document = Document.parse(JsonUtil.toJson(account));

        String tojson = document.toJson();

        System.out.println(tojson);

        Account trans = JsonUtil.fromJson(tojson, Account.class);

        System.out.println( trans );




//        Document document = collection.find(Filters.eq("_id", "abc")).first();
//        System.out.println( document );
    }

}
