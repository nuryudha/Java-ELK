package com.java.elk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.elk.entities.Message;
import com.java.elk.repositories.MessageRepository;

@Service
public class PostgreSQLService {

    @Autowired
    private MessageRepository messageRepository;

    public void sendMessage(Message message) {
        messageRepository.save(message);
    }

}
