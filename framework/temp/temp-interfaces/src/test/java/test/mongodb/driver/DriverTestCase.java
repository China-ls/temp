package test.mongodb.driver;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by hx on 16-6-16.
 */
public class DriverTestCase {

    private MongoClient client;

    @Before
    public void before() {
        client = new MongoClient("localhost", 27017);
    }

    @After
    public void after() {
        client.close();
    }

    @Test
    public void save() {
        MongoDatabase database = client.getDatabase("aaa");
        MongoCollection<Document> collection = database.getCollection("bbb");
        String json = "{\n" +
                "   \"name\" : \"MongoDB\",\n" +
                "   \"type\" : \"database\",\n" +
                "   \"count\" : 1,\n" +
                "   \"info\" : {\n" +
                "               x : 203,\n" +
                "               y : 102\n" +
                "             }\n" +
                "}";
        Document document = Document.parse(json);
        System.out.println(document.toString());
        collection.insertOne(document);
    }

}
