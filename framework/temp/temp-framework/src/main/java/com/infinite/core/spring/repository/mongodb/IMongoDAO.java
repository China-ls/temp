package com.infinite.core.spring.repository.mongodb;

import com.infinite.core.spring.repository.IDAO;
import org.mongodb.morphia.dao.DAO;

/**
 * Created by hx on 16-6-14.
 */
public interface IMongoDAO<T, K> extends DAO<T, K>, IDAO<T, K> {
}
