package com.acme.orion;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionComponentTest {
    @LocalServerPort
    private int port;

    @Test
    void endToEndTest() {
        given().port(port)
                .when().get("/transactions/123456789")
                .then().assertThat()
                .body("$.size()", is(4))
                .body("accountNumber", everyItem(is("123456789")));

    }
}
