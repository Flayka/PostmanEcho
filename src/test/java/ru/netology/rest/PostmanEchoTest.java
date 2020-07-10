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
                .contentType("text/plain; charset=UTF-8")
                .body("Привет")
                .when()
                .post("/post")

                .then()
                .statusCode(200)
                .body("data", equalTo("Привет"))
                .header("content-type", "application/json; charset=utf-8")
                .body("headers.content-length", equalTo("12"))
                .contentType(ContentType.JSON)
                .body("json", equalTo(null))
        ;
    }
}
