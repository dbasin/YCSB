package com.yahoo.ycsb.workloads;


import com.yahoo.ycsb.DB;
import com.yahoo.ycsb.Status;
import com.yahoo.ycsb.Workload;
import com.yahoo.ycsb.generator.DiscreteGenerator;
import es.PachydermDocsFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Random;


/**
 * Created by dbasin on 4/21/16.
 */
public class ESWorkload extends Workload {

    PachydermDocsFactory docsFactory;
    int numOfIndices;
    ThreadLocal<Random> randomThreadLocal = new ThreadLocal<>();
    DiscreteGenerator operationchooser;

    @Override
    public boolean doInsert(DB db, Object threadstate) {
        Status s =  db.insert(getRandomIndexName(),docsFactory.generateJsonDocument(),null);
        return s == s.OK;
    }

    public boolean doTransaction(DB db, Object threadstate) {
        switch (operationchooser.nextString()) {

            case "READ":
                //doTransactionRead(db);
                throw new NotImplementedException();
                //break;
            case "UPDATE":
                //doTransactionUpdate(db);
                throw new NotImplementedException();
                //break;
            case "INSERT":
                doInsert(db, threadstate);
                break;
            case "SCAN":
                //doTransactionScan(db);
                throw new NotImplementedException();
                //break;
            default:
                //doTransactionReadModifyWrite(db);
                throw new NotImplementedException();
        }

        return true;
    }

    @Override
    public void init(Properties p)
    {
        Path path = Paths.get(p.getProperty("source.index.folder"));
        docsFactory = new PachydermDocsFactory(path);
        numOfIndices = Integer.parseInt(p.getProperty("num.of.indices","3000"));
        operationchooser = CoreWorkload.createOperationGenerator(p);
    }

    private String getRandomIndexName()
    {
        Random r = randomThreadLocal.get();
        if(r == null)
        {
            randomThreadLocal.set(new Random());
        }

        return "index" + r.nextInt(numOfIndices);
    }
}
