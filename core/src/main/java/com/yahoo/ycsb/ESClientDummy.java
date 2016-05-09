package com.yahoo.ycsb;

import es.ESClient;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

/**
 * Created by dbasin on 4/24/16.
 */
public class ESClientDummy extends  DB {
    ESClient esClient;

    @Override
    public Status read(String table, String key, Set<String> fields, HashMap<String, ByteIterator> result) {
        throw new NotImplementedException();
    }

    @Override
    public Status scan(String table, String startkey, int recordcount, Set<String> fields, Vector<HashMap<String, ByteIterator>> result) {
        throw new NotImplementedException();
    }

    @Override
    public Status update(String table, String key, HashMap<String, ByteIterator> values) {
        throw new NotImplementedException();
    }

    @Override
    public Status insert(String index, String json, HashMap<String, ByteIterator> values) {
       // esClient.indexDoc(index,json);

        return Status.OK;
    }

    @Override
    public Status delete(String table, String key) {
        throw new NotImplementedException();
    }

    @Override
    public void init()
    {
        esClient = new ESClient();
    }
}
