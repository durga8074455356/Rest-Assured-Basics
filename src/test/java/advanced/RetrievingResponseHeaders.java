package advanced;


import java.util.List;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class RetrievingResponseHeaders {

    @Test
    public void getAllHeadersFromResponse() {
        // Base URL
        String baseUrl = "https://rahulshettyacademy.com";
        // Resource
        String resource = "/maps/api/place/add/json";
        // Query parameter
        String queryParamKey = "qaclick123";
        // JSON body
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
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .post(baseUrl + resource)
                .then()
                .extract()
                .response();

        // Printing all headers
        System.out.println("All Headers of response are :- ");
        Headers allHeaders = response.getHeaders();
        for (Header header : allHeaders) {
            System.out.print(header.getName() + " : ");
            System.out.println(header.getValue());
        }

        // Retrieving and printing single header value
        System.out.println("Value of Header Content-Type: " + response.getHeader("Content-Type"));

        // Retrieving and printing headers with multiple values
        System.out.println("All values of Header Set-Cookie: ");
        List<String> cookies = response.getHeaders().getValues("Set-Cookie");
        for (String cookie : cookies) {
            System.out.println(cookie);
        }
    }
}

