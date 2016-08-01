package com.ls.test.morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import org.junit.After;
import org.junit.Before;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * Created by hx on 16-7-27.
 */
public class DatastoreTest {
    private MongoClient mongo;
    private Morphia morphia;
    private Datastore ds;

    @Before
    public void init() {
        try {
            mongo = new MongoClient("127.0.0.1", 27017);
        } catch (MongoException e) {
            e.printStackTrace();
        }
        morphia = new Morphia();
//        morphia.map(User.class);
        ds = morphia.createDatastore(mongo, "temp");
    }

    private void print(Object o) {
        if (o != null) {
            System.out.println(o.toString());
        }
    }

//    /**
//     * <b>function:</b> 查询所有
//     */
//    private void query() {
//        Iterable<User> it = ds.createQuery(User.class).fetch();
//        while (it.iterator().hasNext()) {
//            print("fetch: " + it.iterator().next());
//        }
//    }
//
//    /**
//     * <b>function:</b> CUD增删改
//     */
//    @Test
//    public void testCUD() {
//        // 添加测试数据
//        for (int i = 0; i < 50; i++) {
//            User u = new User(System.currentTimeMillis() + i, "test-" + i, ((i % 2 == 0) ? true : false), 18 + i, "china-gz#" + i);
//            print(ds.save(u));
//        }
//        //ds.delete(ds.createQuery(User.class));
//
//        List<User> users = new ArrayList<User>();
//        users.add(new User(1306907246518L, "zhangsan", true, 22, "china-gz"));
//        User user = new User(System.currentTimeMillis() + 3, "zhaoliu", true, 29, "china-beijin");
//        users.add(user);
//        users.add(new User(System.currentTimeMillis() + 6, "wangwu", true, 24, "china-shanghai"));
//        users.add(new User(System.currentTimeMillis() + 9, "lisi", true, 26, "china-wuhan"));
//        //添加集合
//        print("save: " + ds.save(users));
//
//        //添加数组
//        print("save: " + ds.save(users.toArray()));
//
//        this.query();
//        print("getKey: " + ds.find(User.class, "id", 1306907246518L).getKey());
//
//        //修改操作
//        UpdateOperations<User> uo = ds.createUpdateOperations(User.class);
//
//        print("update: " + ds.update(ds.find(User.class, "id", 1306907246518L).getKey(), uo).getUpdatedCount());
//        uo.set("name", "zhaoliuliu").set("age", 29).set("sex", true).set("address", "gzz");
//        print("update: " + ds.update(ds.find(User.class, "id", 1306907246518L).getKey(), uo).getUpdatedCount());
//
//        print("update: " + ds.update(ds.createQuery(User.class).field("id").equal(1306907246518L), uo).getUpdatedCount());
//        print("update: " + ds.update(ds.find(User.class, "id", 1306907246518L), uo).getUpdatedCount());
//
//        Query<User> queryUser = ds.createQuery(User.class).field("id").equal(1306907246518L);
//        UpdateResults up = ds.update(queryUser, uo, true);
//        print("up count:" + up.getUpdatedCount());
//
//        uo = ds.createUpdateOperations(User.class);
//        uo.set("name", "zhaoqq").set("age", 29).set("sex", true).add("address", "fzz");
//        print("update: " + ds.update(ds.find(User.class, "id", 1306907246518L).get(), uo).getUpdatedCount());
//
//        print("update: " + ds.update(ds.createQuery(User.class).field("id").equal(1306907246518L), uo, true).getUpdatedCount());
//
//        // 修改第一个对象
//        print("updateFirst: " + ds.updateFirst(ds.createQuery(User.class).field("id").equal(1306907246518L), uo).getUpdatedCount());
//        //当参数createIfMissing为true的时候，如果修改的对象不存在就会添加这条数据，如果为false的情况下，不存在也不添加
//        print("updateFirst: " + ds.updateFirst(ds.createQuery(User.class).field("id").equal(1306907246519L), uo, true).getUpdatedCount());
//        user.setId(1306907246518L);
//        print("updateFirst: " + ds.updateFirst(ds.createQuery(User.class).field("id").equal(1306907246518L), user, true).getUpdatedCount());
//
//        user.setId(1306916670518L);
//        // 合并
//        print("merge: " + ds.merge(user).getId());
//        this.query();
//
//        //删除
//        print("delete: " + ds.delete(ds.createQuery(User.class).field("id").equal(1306907246518L)).getN());
//        print("delete: " + ds.delete(ds.find(User.class, "age", 29).get()).getN());
//        //print("delete: " + ds.delete(User.class, 1306911594631L).getN());
//        //print("delete: " + ds.delete(User.class, users).getN());
//        //ds.delete(ds.createQuery(User.class));
//        this.query();
//    }
//
//    /**
//     * <b>function:</b> find查询
//     */
//    @Test
//    public void testFind() {
//        print("find: " + ds.find(User.class).asList());
//        //like
//        print("find-contains: " + ds.find(User.class).field("name").contains("test-1").asList());
//        //忽略大小写
//        print("find-containsIgnoreCase: " + ds.find(User.class).field("name").containsIgnoreCase("ja").asList());
//
//        print("find-endsWith: " + ds.find(User.class).field("name").endsWith("22").asList());
//        print("find-endsWithIgnoreCase: " + ds.find(User.class).field("name").endsWithIgnoreCase("CK").asList());
//
//        //过滤null或是没有name属性的
//        print("find-doesNotExist: " + ds.find(User.class).field("name").doesNotExist().asList());
//        //查询name有值的数据
//        print("find-doesNotExist: " + ds.find(User.class).field("name").exists().asList());
//        //age > 48
//        print("find-greaterThan: " + ds.find(User.class).field("age").greaterThan(66).asList());
//        //age >= 48
//        print("find-greaterThan: " + ds.find(User.class).field("age").greaterThanOrEq(66).asList());
//
//        List<Integer> ageList = new ArrayList<Integer>();
//        ageList.add(22);
//        ageList.add(55);
//        ageList.add(66);
//        //all
//        print("find-hasAllOf: " + ds.find(User.class).field("age").hasAllOf(ageList).asList());
//        //in
//        print("find-hasAnyOf: " + ds.find(User.class).field("age").hasAnyOf(ageList).asList());
//        //not in
//        print("find-hasNoneOf: " + ds.find(User.class).field("age").hasNoneOf(ageList).asList());
//        //elemMatch
//        //print("find-hasThisElement: " + ds.find(User.class).field("age").hasThisElement(55).asList());
//        print("find-hasThisOne: " + ds.find(User.class).field("age").hasThisOne(55).asList());
//
//        print("find-in: " + ds.find(User.class).field("age").in(ageList).asList());
//        print("find-lessThan: " + ds.find(User.class).field("age").lessThan(20).asList());
//        print("find-lessThanOrEq: " + ds.find(User.class).field("age").lessThanOrEq(18).asList());
//
//        //print("find-lessThanOrEq: " + ds.find(User.class).field("age").near(.2, .8).asList());
//
//        print("find: " + ds.find(User.class, "id", 1306813979609L).get());
//        print("find: " + ds.find(User.class, "age", 28, 1, 2).asList());
//
//        print("findAndDelete: " + ds.findAndDelete(ds.createQuery(User.class).field("id").equal(1306813979609L)));
//        print("find: " + ds.find(User.class).asList());
//    }
//
//    /**
//     * <b>function:</b> query查询
//     */
//    @Test
//    public void testQuery() {
//        // 查询所有
//        print("query: " + ds.createQuery(User.class).asList());
//        // 查询主键
//        print("query key: " + ds.createQuery(User.class).asKeyList());
//        // 结果集数量
//        print("query: " + ds.createQuery(User.class).countAll());
//        // 抓取查询所有记录
//        Iterable<User> it = ds.createQuery(User.class).fetch();
//        while (it.iterator().hasNext()) {
//            print("fetch: " + it.iterator().next());
//        }
//
//        // null
//        it = ds.createQuery(User.class).fetchEmptyEntities();
//        while (it.iterator().hasNext()) {
//            print("fetchEmptyEntities: " + it.iterator().next());
//        }
//
//        // all key
//        Iterable<Key<User>> itkeys = ds.createQuery(User.class).fetchKeys();
//        while (itkeys.iterator().hasNext()) {
//            print("fetchKeys: " + itkeys.iterator().next());
//        }
//
//        // age > 24
//        print("query: " + ds.createQuery(User.class).filter("age > ", 24).asList());
//        // age in (20, 28)
//        print("query: " + ds.createQuery(User.class).filter("age in ", new int[]{20, 28}).asList());
//
//        // limit 3
//        print("query: " + ds.createQuery(User.class).limit(3).asList());
//        // 分页类似MySQL
//        print("query: " + ds.createQuery(User.class).offset(11).limit(5).asList());
//        // order排序，默认asc
//        print("query: " + ds.createQuery(User.class).order("age").asList());
//        //desc
//        print("query: " + ds.createQuery(User.class).order("-age").asList());
//        // 组合排序 order by age, name
//        print("query: " + ds.createQuery(User.class).order("age, name").asList());
//
//        print("query: " + ds.createQuery(User.class).queryNonPrimary().asList());
//        print("query: " + ds.createQuery(User.class).queryPrimaryOnly().asList());
//        //如果include 为true就表示取该属性的值，其他的默认null，反之为false则该属性为null，取其他的值
//        print("query: " + ds.createQuery(User.class).retrievedFields(false, "age").asList());
//    }
//
//    /**
//     * <b>function:</b> get查询
//     */
//    @Test
//    public void testGet() {
//        User user = new User();
//        user.setId(1306916670518L);
//        print("get: " + ds.get(user));
//        List<Long> ids = new ArrayList<Long>();
//        ids.add(1306907246519L);
//        ids.add(1306916670524L);
//        // 通过id集合查询相当于in ()
//        print("get: " + ds.get(User.class, ids).asList());
//        // id查询
//        print("get: " + ds.get(User.class, 1306916670524L));
//    }
//
//    /**
//     * <b>function:</b> count查询
//     */
//    @Test
//    public void testGetCount() {
//        User user = new User();
//        user.setId(1306916670518L);
//        print("getCount: " + ds.getCount(user));
//        print("getCount: " + ds.getCount(User.class));
//
//        List<Long> ids = new ArrayList<Long>();
//        ids.add(1306907246519L);
//        ids.add(1306916670524L);
//        print("getCount: " + ds.getCount(ds.get(User.class, ids)));
//
//        // age > 22的记录
//        print("getCount: " + ds.getCount(ds.createQuery(User.class).filter("age > ", 22)));
//        // 所有
//        print("countAll: " + ds.get(User.class, ids).countAll());
//        print("countAll: " + ds.find(User.class).countAll());
//    }
//
//    @Test
//    public void testOthers() {
//        query();
//        /** 索引 */
//        ds.ensureIndexes();
//        // 同时用annotation也可以给指定的属性建立索引
//        // 只需用在JavaEntity建立索引的属性上添加annotation
//    /*@Indexed(value = IndexDirection.ASC, name = "address_index")
//    String address;
//    // 建立唯一索引
//    @Indexed(value = IndexDirection.ASC, name = "bandName", unique = true)
//    String name;*/
//
//        ds.ensureCaps();
//        User user = new User();
//        user.setId(1306916670518L);
//        print("getDB: " + ds.getDB());
//        print("getDefaultWriteConcern: " + ds.getDefaultWriteConcern());
//        print("DBColl: " + ds.getCollection(User.class)); // 查询User对象对应的集合
//        Key<User> key = ds.getKey(user); // 主键
//        print("getKey: " + key);
//        print("exists: " + ds.exists(user)); //是否存在该对象
//        print("exists: " + ds.exists(ds.getKey(user)));
//
//        print("getByKey: " + ds.getByKey(User.class, key));
//        List<Key<User>> keys = new ArrayList<Key<User>>();
//        keys.add(key);
//        user.setId(1306916670521L);
//        keys.add(ds.getKey(user));
//        print("getByKey: " + ds.getByKeys(keys));
//        print("getByKey: " + ds.getByKeys(User.class, keys));
//
//        query();
//    }

    @After
    public void destory() {
        mongo = null;
        morphia = null;
        ds = null;
        System.gc();
    }
}
