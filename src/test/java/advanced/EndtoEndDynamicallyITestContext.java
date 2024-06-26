package advanced;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class EndtoEndDynamicallyITestContext {

    @Test
    public void addPlace(ITestContext context) {
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

        // Send POST request to add place
        Response response = RestAssured.given()
                .queryParam("key", "qaclick123")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/maps/api/place/add/json");

        // Extract place ID from the response
        String placeId = response.then()
                .extract()
                .path("place_id");

        // Set place ID as an attribute in ITestContext
        context.setAttribute("placeId", placeId);

        // Log
        System.out.println("Place added successfully. Place ID: " + placeId);
    }

    @Test(dependsOnMethods = {"addPlace"})
    public void updatePlace(ITestContext context) {
        // Retrieve place ID from ITestContext
        String placeId = (String) context.getAttribute("placeId");

        // Base URL
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // Sample request body
        String requestBody = "{\n" +
                "  \"place_id\":\"" + placeId + "\",\n" +
                "  \"address\":\"70 Summer walk, USA\",\n" +
                "  \"key\":\"qaclick123\"\n" +
                "}";

        // Send PUT request to update place
        RestAssured.given()
                .queryParam("key", "qaclick123")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/maps/api/place/update/json")
                .then()
                .statusCode(200);

        // Log
        System.out.println("Place updated successfully. Place ID: " + placeId);
    }

    @Test(dependsOnMethods = {"updatePlace"})
    public void deletePlace(ITestContext context) {
        // Retrieve place ID from ITestContext
        String placeId = (String) context.getAttribute("placeId");

        // Base URL
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // Sample request body
        String requestBody = "{\n" +
                "    \"place_id\":\"" + placeId + "\"\n" +
                "}";

        // Send DELETE request to delete place
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .delete("/maps/api/place/delete/json")
                .then()
                .statusCode(200);

        // Log
        System.out.println("Place deleted successfully. Place ID: " + placeId);
    }
}
