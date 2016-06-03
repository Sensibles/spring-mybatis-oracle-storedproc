package io.sanjay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import io.sanjay.entity.DbEntity;
import io.sanjay.service.DbService;

@Component
public class Worker {

    @Autowired
    DbService dbService;


    @Scheduled(fixedDelay = 10000L)
    public void run(){
    	DbEntity entity = new DbEntity();
    	entity.setInStr("A");
        System.out.println("dbService records-> outStr: " + dbService.callProc(entity).getOutStr());
        System.out.println("dbService records-> outStr2: " + entity.getOutStr2());
    }
}
