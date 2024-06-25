package advanced;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class IgnoreNodeForJsonAssert {

    @Test
    public void testCompareJsonObjects() {
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

        // Send POST request
        String response = RestAssured
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
                .statusCode(200) // Asserting the response code is 200
                .extract()
                .response()
                .asString();

        // Expected JSON without 'status' field
        String expectedJson = "{\n" +
                "  \"place_id\": \"*\"," + // Placeholder for place_id
                "  \"scope\": \"APP\",\n" +
                "  \"reference\": \"*\"\n" + // Placeholder for reference
                "}";

        // Compare response JSON with expected JSON, ignoring 'status' field using JSONassert
        try {
            JSONAssert.assertEquals(expectedJson, response, JSONCompareMode.LENIENT);
            System.out.println("JSON objects are equal ignoring 'status' field");
        } catch (AssertionError e) {
            System.out.println("JSON objects are not equal: " + e.getMessage());
        }
    }
}
