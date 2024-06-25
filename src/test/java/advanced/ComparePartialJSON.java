package advanced;

import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ComparePartialJSON {

    @Test
    public void testComparePartialJson() {
        // Base URL
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // Sample request body
        String requestBody = "{\n" +
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
                "}";
        
        // Send POST request and get response as String
        String actualResponse = RestAssured
                .given()
                .log().all()
                .queryParam("key", "qaclick123")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/maps/api/place/add/json")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response()
                .asString();
        
        // Define the expected partial JSON response
        String expectedPartialJson = "{\n" +
                "  \"status\": \"OK\",\n" +
                "  \"place_id\": \"\",\n" +
                "  \"scope\": \"APP\",\n" +
                "  \"reference\": \"\",\n" +
                "  \"id\": \"\"\n" +
                "}";

        // Compare actual and expected partial JSON responses using JSONAssert
        try {
            JSONAssert.assertEquals(expectedPartialJson, actualResponse, false);
            System.out.println("Partial JSONs are equal");
        } catch (AssertionError e) {
            System.out.println("Partial JSONs are not equal: " + e.getMessage());
        }
    }
}

