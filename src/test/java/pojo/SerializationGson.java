package pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class SerializationGson {
    @Test
    public void testRequest() throws JsonProcessingException{
        UpdatePlaceRequest place = new UpdatePlaceRequest();
        place.setPlace_id("b5d6aafa9a22eb484fcd786346118f8");
        place.setAddress("Cogniant, HYD");
        place.setKey("qaclick123");

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(place);

        given()
            .baseUri("https://rahulshettyacademy.com")
            .basePath("/maps/api/place/put/json")
            .queryParam("key", "qaclick123")
            .body(requestBody)
        .when()
            .put()
        .then()
            .statusCode(405);
        Gson gson = new Gson();
        String requestBody1 = gson.toJson(place);
        System.out.println(requestBody1);
    }
}



