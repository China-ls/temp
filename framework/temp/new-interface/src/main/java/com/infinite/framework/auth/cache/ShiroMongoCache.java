package com.infinite.framework.auth.cache;

import com.infinite.framework.core.constant.DbConfig;
import com.infinite.framework.core.persistent.AbstractMongoDAO;
import com.mongodb.client.model.Filters;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.bson.Document;

import java.util.Collection;
import java.util.Set;

/**
 * Created by hx on 16-7-5.
 */
public abstract class ShiroMongoCache<K, V> extends AbstractMongoDAO implements Cache<K, V> {
    private String dbName = DbConfig.AuthenticationInfo.DB;
    private String collectionName = DbConfig.AuthenticationInfo.COLLECTION;
    private String idField = DbConfig.AuthenticationInfo.ENTITY_ID_FIELD;

    public V get(K key) throws CacheException {
        Document document = findFirst(dbName, collectionName, Filters.eq(idField, keyToString(key)));
        return getData(document);
    }

    public V put(K key, V value) throws CacheException {
        if (!StringUtils.isEmpty(keyToString(key)) && null != value) {
            Document document = valueToDocument(value);
            document.put(idField, key);
            insertOne(dbName, collectionName, document);
        }
        return value;
    }

    public V remove(K key) throws CacheException {
        Document document = findOneAndDelete(dbName, collectionName, Filters.eq(idField, keyToString(key)));
        return getData(document);
    }

    public void clear() throws CacheException {
        drop(dbName, collectionName);
    }

    public int size() {
        return (int) count(dbName, collectionName);
    }

    public Set<K> keys() {
        return null;
    }

    public Collection<V> values() {
        return null;
    }

    V getData(Document document) {
        if (null != document) {
            document.remove(idField);
            return documentToValue(document);
        }
        return null;
    }

    abstract String keyToString(K key);

    abstract K stringToKey(String keyString);

    abstract V documentToValue(Document document);

    abstract Document valueToDocument(V value);

    //****************** getter and setter *******************//

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getIdField() {
        return idField;
    }

    public void setIdField(String idField) {
        this.idField = idField;
    }

}
