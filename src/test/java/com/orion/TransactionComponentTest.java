package com.orion;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionComponentTest {
    @LocalServerPort
    int port;

    @Test
    void endToEndTest() {
        given().port(port)
                .when().get("/api/v1/transactions/123456789")
                .then().assertThat()
                .statusCode(is(200));
    }
}
