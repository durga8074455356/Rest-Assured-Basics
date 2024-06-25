package advanced;


import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RemoveTheExistingKey {

    @Test
    public void quickEditToJsonObject() throws JsonMappingException, JsonProcessingException {
        String jsonObject = "{\r\n" +
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

        // Creating an instance of ObjectMapper class
        ObjectMapper objectMapper = new ObjectMapper();
        // Get ObjectNode representation of json as json is an Object
        ObjectNode objectNode = objectMapper.readValue(jsonObject, ObjectNode.class);
        
        // Remove existing fields from the JSON object
        objectNode.remove("accuracy");
        
        System.out.println(objectNode.toPrettyString());
        
        // Optionally, you can send this updated JSON in a RestAssured request
        sendPostRequest(objectNode.toString());
    }

    public void sendPostRequest(String jsonBody) {
        RestAssuredProgram restAssuredProgram = new RestAssuredProgram();
        restAssuredProgram.postRequestWithModifiedJson(jsonBody);
    }
  public class RestAssuredProgram {
        
        public void postRequestWithModifiedJson(String jsonBody) {
            RestAssured
                .given()
                .baseUri("https://rahulshettyacademy.com")
                .queryParam("key", "qaclick123")
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .log().all()
                .post("/maps/api/place/add/json")
                .then()
                .log().all();
        }
  }
}

