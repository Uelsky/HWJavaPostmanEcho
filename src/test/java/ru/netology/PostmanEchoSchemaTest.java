package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PostmanEchoSchemaTest {
    @Test
    void shouldReturnCorrectAnswerV1() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("some data")
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("post_answer.schema.json"));
    }
}
