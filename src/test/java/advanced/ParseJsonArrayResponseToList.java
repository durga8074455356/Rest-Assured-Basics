package advanced;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.Map;

public class ParseJsonArrayResponseToList {

    @Test
    public void addPlaceAndGetPlace() {
        // Base URL
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // Step 1: Add a new place using POST request
        Map<String, Object> addPlaceResponse = RestAssured
                .given()
                    .queryParam("key", "qaclick123")
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                          "  \"location\": {\n" +
                          "    \"lat\": -38.383494,\n" +
                          "    \"lng\": 33.427362\n" +
                          "  },\n" +
                          "  \"accuracy\": 50,\n" +
                          "  \"name\": \"Frontline house\",\n" +
                          "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                          "  \"address\": \"29, side layout, cohen 09\",\n" +
                          "  \"types\": [\n" +
                          "    \"shoe park\",\n" +
                          "    \"shop\"\n" +
                          "  ],\n" +
                          "  \"website\": \"http://google.com\",\n" +
                          "  \"language\": \"French-IN\"\n" +
                          "}")
                .when()
                    .post("/maps/api/place/add/json")
                .then()
                    .statusCode(200)
                    .extract()
                    .as(new TypeRef<Map<String, Object>>() {});

        // Extracting place_id from the response
        String placeId = (String) addPlaceResponse.get("place_id");
        System.out.println("Added Place ID: " + placeId);

        // Step 2: Get the place details using GET request
        Map<String, Object> getPlaceResponse = RestAssured
                .given()
                    .queryParam("key", "qaclick123")
                    .queryParam("place_id", placeId)  // Correct parameter for getting place details
                .when()
                    .get("/maps/api/place/get/json")
                .then()
                    .statusCode(200)
                    .extract()
                    .as(new TypeRef<Map<String, Object>>() {});

        // Print the place details
        System.out.println("Place details: " + getPlaceResponse);
    }
}
