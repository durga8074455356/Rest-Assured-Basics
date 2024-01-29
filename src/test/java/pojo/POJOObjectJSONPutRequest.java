package pojo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


import io.restassured.http.ContentType;

public class POJOObjectJSONPutRequest {
    @Test
    public void updatePlaceTest() {
        String baseUrl = "https://rahulshettyacademy.com";
        String resource = "/maps/api/place/put/json";

        UpdatePlaceRequest updatePlaceRequest = new UpdatePlaceRequest();
        updatePlaceRequest.setPlace_id("b5d7aafa9a222eb484fcd786346118f8");
        updatePlaceRequest.setAddress("70 Summer walk, USA");
        updatePlaceRequest.setKey("qaclick123");

        given()
        .baseUri(baseUrl)
        .basePath(resource)
        .queryParam("key", "qaclick123")
        .contentType(ContentType.JSON)
        .body(updatePlaceRequest)
    .when()
        .put()
    .then()
        .statusCode(405);
    }
}