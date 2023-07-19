package com.AppBank.AppBank.testSuiteK;

import com.AppBank.AppBank.Transaction.Transaction;
import com.AppBank.AppBank.config.TransactionConfig;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class TransactionAPITests extends TransactionConfig {

    @Test
    public void getTransactionById(){
        Response response =
                given()
                        .pathParam("id", "1")
                .when()
                        .get("transactions/{id}");
    }

    @Test
    public void getAllTransactions(){
        Response response =
                given()
                .when()
                        .get("transactions");
    }

    @Test
    public void createAndDeleteTransaction(){
        Transaction transaction = new Transaction(12345.5, LocalDateTime.now());

        Response response =
                given()
                       .body(transaction)
               .when()
                        .post("transactions");

        /** CLEANUP OF DDBB**/
                given()
                        .pathParam("id", response.getBody().jsonPath().getLong("id"))
                .when()
                        .delete("transactions/{id}");

        /** ENSURE TRANSACTION IS DELETED **/
        given()
                .pathParam("id", response.getBody().jsonPath().getLong("id"))
                .expect().statusCode(404)
        .when()
                .get("transactions/{id}");
    }
}