package com.java.elk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.elk.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
