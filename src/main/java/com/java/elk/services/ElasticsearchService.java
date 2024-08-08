package com.java.elk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.java.elk.entities.DataLake;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

@Service
public class ElasticsearchService {

    @Autowired
    RestHighLevelClient client;

    @Value("${spring.elasticsearch.index}")
    private String indexName;

    public void saveDataLakeToElasticsearch(DataLake dataLake) {
        Map<String, Object> dataLakeMap = new HashMap<>();
        dataLakeMap.put("topic", dataLake.getTopic());
        dataLakeMap.put("content", dataLake.getContent());

        IndexRequest request = new IndexRequest(indexName)
                .id(UUID.randomUUID().toString())
                .source(dataLakeMap, XContentType.JSON);

        try {
            IndexResponse response = client.index(request, RequestOptions.DEFAULT);
            System.out.println("Response from elasticsearch : " + response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
