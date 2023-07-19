package com.AppBank.AppBank.testSuiteK;

import com.AppBank.AppBank.Transaction.Transaction;
import com.AppBank.AppBank.config.TransactionConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;

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

        Response cleanup =
                given()
                        .pathParam("id", response.getBody().jsonPath().getLong("id"))
                .when()
                        .delete("transactions/{id}");
    }
}