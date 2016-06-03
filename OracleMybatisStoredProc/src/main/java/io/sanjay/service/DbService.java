package io.sanjay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.sanjay.entity.DbEntity;
import io.sanjay.mapper.DbMapper;

@Service
public class DbService {

    @Autowired
    private DbMapper dbMapper;

 
    public DbEntity callProc(DbEntity input) {
		
    	dbMapper.callProc(input);
        return input;
    }
}