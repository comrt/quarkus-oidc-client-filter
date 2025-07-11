package com.rt.quarkus;

import io.quarkus.test.common.WithTestResource;
import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusIntegrationTest
@WithTestResource(UpstreamServerMocks.class)
class ExampleResourceIT {

  @Test
  void testHelloEndpoint() {
    given()
        .when().get("/hello")
        .then()
        .statusCode(200)
        .body(is("Error calling API: HTTP 404 Not Found"));
  }
}
