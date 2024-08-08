package com.java.elk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.elk.entities.DataLake;
import com.java.elk.repositories.DataLakeRepository;

@Service
public class PostgreSQLService {

    @Autowired
    private DataLakeRepository dataLakeRepository;

    public void saveDataLake(DataLake dataLake) {
        dataLakeRepository.save(dataLake);
    }

}
