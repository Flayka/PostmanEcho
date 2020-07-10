package ru.netology.rest;


import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class PostmanEchoTest {
    @Test
    void shouldPostmanEchoPost() {

        given()
                .baseUri("https://postman-echo.com")
                .body("hello netology")
                .when()
                .post("/post")

                .then()
                .statusCode(200)
                .body("data", equalTo("hello netology"))
                .header("content-type", "application/json; charset=utf-8")
                .body("headers.content-length", equalTo("14"))
                .contentType(ContentType.JSON)
                .body("json", equalTo(null))
        ;
    }
}
