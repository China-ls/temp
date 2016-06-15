package com.infinite.framework.ds;

import com.infinite.framework.ds.dto.Query;
import com.infinite.framework.ds.dto.QueryResult;
import com.infinite.framework.ds.dto.Update;
import com.infinite.framework.ds.dto.UpdateResult;

/**
 * Created by hx on 16-6-15.
 */
public interface IDatasource {

    public UpdateResult put(String data);

    public QueryResult get(Query query);

    public UpdateResult update(Update update);

    public UpdateResult delete(Update update);

}
