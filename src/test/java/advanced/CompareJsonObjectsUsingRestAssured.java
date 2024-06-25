package advanced;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class CompareJsonObjectsUsingRestAssured {

    @Test
    public void testCompareJsonObjects() {
        // Base URI
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

        // Expected JSON response (exact same as actual response)
        String expectedResponse = actualResponse;

        // Compare actual and expected JSON responses using JSONAssert
        try {
            JSONAssert.assertEquals(expectedResponse, actualResponse, true);
            System.out.println("JSON objects are equal");
        } catch (AssertionError e) {
            System.out.println("JSON objects are not equal: " + e.getMessage());
        }
    }
}
