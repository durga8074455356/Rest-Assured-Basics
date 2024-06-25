package advanced;


import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class AddingHeaders {

    @Test
    public void addKeyvaluePairHeaders() {
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

        // Add a header as key-value pair
        Response response1 = RestAssured.given()
                .header("Content-Type", "application/json")
                .queryParam("key", queryParamKey)
                .body(jsonBody)
                .when()
                .post(baseUrl + resource);
        System.out.println("Response 1: " + response1.asString());

        // Add headers using Map
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        Response response2 = RestAssured.given()
                .headers(requestHeaders)
                .queryParam("key", queryParamKey)
                .body(jsonBody)
                .when()
                .post(baseUrl + resource);
        System.out.println("Response 2: " + response2.asString());

        // Add header using Header class
        Header requestHeader1 = new Header("Content-Type", "application/json");
        Response response3 = RestAssured.given()
                .header(requestHeader1)
                .queryParam("key", queryParamKey)
                .body(jsonBody)
                .when()
                .post(baseUrl + resource);
        System.out.println("Response 3: " + response3.asString());

        // Add headers using Header and Headers classes
        Header requestHeader2 = new Header("Content-Type", "application/json");
        Headers requestHeaders3 = new Headers(requestHeader2);
        Response response4 = RestAssured.given()
                .headers(requestHeaders3)
                .queryParam("key", queryParamKey)
                .body(jsonBody)
                .when()
                .post(baseUrl + resource);
        System.out.println("Response 4: " + response4.asString());

        // Add header with multiple values
        Response response5 = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Custom-Header", "value1", "value2")
                .queryParam("key", queryParamKey)
                .body(jsonBody)
                .when()
                .post(baseUrl + resource);
        System.out.println("Response 5: " + response5.asString());
      
        
        // Change overwrite behavior to merge

        RestAssured.config = RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("Content-Type"));
        Response response6 = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Content-Type", "text/plain")
                .queryParam("key", queryParamKey)
                .body(jsonBody)
                .when()
                .post(baseUrl + resource);
        System.out.println("Response 6: " + response6.asString());

        // Changing default behavior of merging
        RestAssured.config = RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().mergeHeadersWithName("Content-Type"));
        Response response7 = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Content-Type", "text/plain")
                .queryParam("key", queryParamKey)
                .body(jsonBody)
                .when()
                .post(baseUrl + resource);
        System.out.println("Response 7: " + response7.asString());
    }
}
