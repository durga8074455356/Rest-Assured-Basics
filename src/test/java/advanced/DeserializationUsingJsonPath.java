
package advanced;

import org.testng.annotations.Test;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeserializationUsingJsonPath {

    @Test
    public void testDeserialization() {
        // Base URL and resource endpoint
        String baseURL = "https://rahulshettyacademy.com";
        String resource = "/maps/api/place/add/json";

        // Sample body JSON
        String requestBody = "{\r\n" + 
            "  \"location\": {\r\n" + 
            "    \"lat\": -38.383494,\r\n" + 
            "    \"lng\": 33.427362\r\n" + 
            "  },\r\n" + 
            "  \"accuracy\": 50,\r\n" + 
            "  \"name\": \"Frontline house\",\r\n" + 
            "  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
            "  \"address\": \"29, side layout, cohen 09\",\r\n" + 
            "  \"types\": [\r\n" + 
            "    \"shoe park\",\r\n" + 
            "    \"shop\"\r\n" + 
            "  ],\r\n" + 
            "  \"website\": \"http://google.com\",\r\n" + 
            "  \"language\": \"French-IN\"\r\n" + 
            "}";

        // Send POST request and get response
        Response response = RestAssured.given()
            .baseUri(baseURL)
            .queryParam("key", "qaclick123")
            .contentType("application/json")
            .body(requestBody)
            .post(resource);

        // Extract JSON response
        String jsonResponse = response.getBody().asString();
        System.out.println("JSON Response:");
        System.out.println(jsonResponse);

        // Deserialize JSON using JSONPath
        JsonPath jsonPath = response.jsonPath();

        // Extract specific data using JSONPath
        String placeID = jsonPath.getString("place_id");
        System.out.println("Place ID: " + placeID);

        // Assertion to ensure place ID is not null
        Assert.assertNotNull(placeID, "Place ID is null");
    }
}
