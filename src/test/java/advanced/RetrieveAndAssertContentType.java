package advanced;


import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class RetrieveAndAssertContentType {

    @Test
    public void retrieveAndAssertContentType() {
        String baseUrl = "https://rahulshettyacademy.com";
        String resource = "/maps/api/place/add/json";
        String queryParamKey = "qaclick123";

        String jsonBody = "{\r\n" +
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

        // Making the POST request
        Response response = RestAssured
                .given()
                .queryParam("key", queryParamKey)
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .post(baseUrl + resource);

        // Retrieve and assert Content-Type using getContentType() method
        String contentType = response.getContentType();
                       
        assertEquals(contentType, "application/json;charset=UTF-8", "Content-Type assertion failed");

        // Retrieve and assert Content-Type using getHeader("Content-Type") method
        String contentTypeHeader = response.getHeader("Content-Type");
       
        assertEquals(contentTypeHeader, "application/json;charset=UTF-8", "Content-Type header assertion failed");
    }
}

