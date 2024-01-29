package intermediate;


import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
public class CreateArrayNode


     {
	@Test
	public void arrayNodeTest() {
        // Base URL
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // Create request body for POST
        ObjectNode requestBody = new ObjectMapper().createObjectNode();
        ObjectNode location = new ObjectMapper().createObjectNode();
        location.put("lat", -38.383494);
        location.put("lng", 33.427362);
        requestBody.set("location", location);
        requestBody.put("accuracy", 50);
        requestBody.put("name", "Frontline house");
        requestBody.put("phone_number", "(+91) 983 893 3937");
        requestBody.put("address", "29, side layout, cohen 09");
        ArrayNode types = new ObjectMapper().createArrayNode();
        types.add("shoe park");
        types.add("shop");
        requestBody.set("types", types);
        requestBody.put("website", "http://google.com");
        requestBody.put("language", "French-IN");

        // Send POST request
        Response response = given().contentType(ContentType.JSON)
            .queryParam("key", "qaclick123")
            .body(requestBody)
            .when().post("/maps/api/place/add/json");

        // Extract place_id from the response
        String placeId = response.then().extract().path("place_id");

        // Send GET request
        given().queryParam("key", "qaclick123")
            .queryParam("place_id", placeId)
            .when().get("/maps/api/place/get/json")
            .then().statusCode(200);
    }
}