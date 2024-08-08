package com.java.elk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.elk.entities.DataLake;

@Repository
public interface DataLakeRepository extends JpaRepository<DataLake, Long> {

}
