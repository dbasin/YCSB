package com.yahoo.ycsb.workloads;

import com.yahoo.ycsb.DB;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by dbasin on 4/28/16.
 */
public class ESBulkWorkload extends ESWorkload {

    @Override
    public boolean doInsert(DB db, Object threadstate) {
        throw new NotImplementedException();
    }
}
