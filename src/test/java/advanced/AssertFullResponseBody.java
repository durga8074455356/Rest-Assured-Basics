package advanced;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class AssertFullResponseBody {

    @Test
    public void testAddPlace() {
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

        // Send POST request and assert the response
        RestAssured
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
                    .body("status", Matchers.equalTo("OK"))
                    .body("place_id", Matchers.notNullValue())
                    .body("scope", Matchers.equalTo("APP"))
                    .body("reference", Matchers.notNullValue())
                    .body("id", Matchers.notNullValue());
    }
}
