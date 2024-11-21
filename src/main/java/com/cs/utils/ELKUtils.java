package com.cs.utils;

import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.cs.enums.ConfigProperties;

import io.restassured.response.Response;

public class ELKUtils {
	
	private ELKUtils() {
		
	}
	
	public static void sendLogToELK(String testCaseName, String status )
	{
		
		String hubHost =PropertyUtils.getPropertyMapValue(ConfigProperties.ELASTICSEARCH_HOST);
		
		 Map<String,String> map = new HashMap<>();
		    map.put("testcaseName", testCaseName);
		    map.put("status", status);
		    map.put("timeStamp", LocalDateTime.now().toString());

		    try {
		        Response response = given()
		            .header("Content-Type", "application/json")
		            .log()
		            .all()
		            .body(map)
		            .post("http://" + hubHost + ":9200/framework/testcase");

		        // Log response details for debugging
		        System.out.println("Elasticsearch Response Status Code: " + response.getStatusCode());
		        System.out.println("Elasticsearch Response Body: " + response.getBody().asString());

		        if (response.getStatusCode() != 200 && response.getStatusCode() != 201) {
		            System.err.println("Failed to send log to Elasticsearch. Status: " + response.getStatusCode());
		        }
		    } catch (Exception e) {
		        System.err.println("Exception occurred while sending log to Elasticsearch: " + e.getMessage());
		        e.printStackTrace();
		    }
		   
	}

}
