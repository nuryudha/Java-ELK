package com.java.elk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

@Service
public class KakfaConsumerService {

    @Autowired
    private PostgreSQLService postgreSQLService;

    @Autowired
    private ElasticsearchService elasticsearchService;

    @Autowired
    private LogstashService logstashService;

    @Value("${spring.kafka.topic.test-elk}")
    private String topicName;

    // @Value("${spring.kafka.consumer.group-id}")
    // private String groupIdName;

    @KafkaListener(topics = "#{@topicName}", groupId = "#{@groupIdName}")

    public void listen(String message) {
        // System.out.println("Received message from topic" + );

    }

}
