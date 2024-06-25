package advanced;


import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SetContentTypeForRequest {

    @Test
    public void settingContentTypeAsContentType() {
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

        RestAssured
            .given()
            .log()
            .all()
            .queryParam("key", queryParamKey)
            .contentType(ContentType.JSON)  // Setting Content-Type to JSON
            .body(jsonBody)
            .post(baseUrl + resource)
            .then()
            .log()
            .all();
    }
}
