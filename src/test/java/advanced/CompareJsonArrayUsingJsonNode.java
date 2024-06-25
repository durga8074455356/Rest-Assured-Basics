package advanced;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CompareJsonArrayUsingJsonNode {

    @Test
    public void testAddPlaceAndCompareJson() throws JsonProcessingException {
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

        // Expected JSON response
        String expectedResponse = "{\n" +
                "  \"status\": \"OK\"\n" +
                "}";

        // Parse actual and expected JSON responses
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode actualJsonNode = objectMapper.readTree(actualResponse);
        JsonNode expectedJsonNode = objectMapper.readTree(expectedResponse);

        // Compare the status field in the actual JSON with the expected JSON
        assertEquals(actualJsonNode.get("status").asText(), expectedJsonNode.get("status").asText());
    }
}
