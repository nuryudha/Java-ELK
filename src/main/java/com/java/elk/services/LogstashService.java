package com.java.elk.services;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class LogstashService {

    private final String logStashUrl = "http://localhost:4445";

    private void sendDataLakeToLogstash(String dataLakeContent) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(logStashUrl);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setEntity(new StringEntity(dataLakeContent));

            CloseableHttpResponse response = httpClient.execute(httpPost);

            try {
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println("Response from Logstash: " + responseBody);
            } finally {
                response.close();

            }

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}
