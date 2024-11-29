package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoJsonTest {
    @Test
    public void shouldReturnCorrectAnswerV2() {
        given()
                .baseUri("https://postman-echo.com")
                .body("some data")
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("some data"))
                .body("json", equalTo(null))
                .body("url", equalTo("http://postman-echo.com/post"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("http"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"));
    }
}
