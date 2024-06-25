package advanced;


import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;

public class ParseJsonObjectResponseToMap {

    public static void main(String[] args) {

        Map<String, Object> responseBody = null;

        responseBody = 
            RestAssured
                .given()
                    .baseUri("https://rahulshettyacademy.com")
                    .basePath("/maps/api/place/add/json")
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
                    .post()
                .then()
                    .extract()
                    .body()
                    // Extract response as Map
                    .as(new TypeRef<Map<String, Object>>() {});

        // Print the entire response body map
        System.out.println("Response Body: " + responseBody);

        // To print place_id
        System.out.println("Place ID is: " + responseBody.get("place_id"));

       
    }
}
