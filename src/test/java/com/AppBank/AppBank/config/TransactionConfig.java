package com.AppBank.AppBank.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeClass;

import static org.hamcrest.Matchers.lessThan;

public class TransactionConfig {
    @BeforeClass
    public static void setup(){

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://localhost:8081/")
                .setContentType("application/json")
//                .addHeader("Accept", "application/json")
                .addFilter((new RequestLoggingFilter()))
                .addFilter((new ResponseLoggingFilter()))
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThan(1000L))
                .build();
    }
}
