package test.ls.testcase;

import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import test.ls.entity.OtherEntity;
import test.ls.entity.ParentEntity;

import java.util.Iterator;

/**
 * Created by hx on 16-6-14.
 */
public class MongoDbObjectTest {
    private MongoClient client;
    private Morphia morphia;
    @Before
    public void before() {
        client = new MongoClient("localhost", 27017);
        morphia = new Morphia();
    }

    @After
    public void after() {
        client.close();
    }

    @Test
    public void test() {
        Datastore testDS = morphia.createDatastore(client, "test");
        ParentEntity parent = new ParentEntity();
        parent.setId(new ObjectId());
        parent.setName("hahah");
        parent.setType("ttt");

        OtherEntity other = new OtherEntity();
        other.setId(new ObjectId());
        other.setSign("ssssss");

        parent.setOther(other);

        Key<ParentEntity> keyParent = testDS.save(parent);

        Query<ParentEntity> query = testDS.find(ParentEntity.class);
        Iterator<ParentEntity> it = query.iterator();
        while (it.hasNext()) {
            ParentEntity pp = it.next();
            System.out.println( "<------" );
            System.out.println( pp );
            System.out.println( pp.getOther().getClass().getSimpleName() );
            System.out.println( "------>" );
        }
    }

}
