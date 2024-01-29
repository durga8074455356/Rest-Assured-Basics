package encapsulation;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class RestAssuredImplementation	implements RestAssuredInterface {
	    private static final String BASE_URL = "https://rahulshettyacademy.com";

	    public Response addPlace() {
	        String resource = "/maps/api/place/add/json";
	        String key = "qaclick123";
	        String body = "{\n" +
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
	        return given()
	                .baseUri(BASE_URL)
	                .basePath(resource)
	                .queryParam("key", key)
	                .contentType(ContentType.JSON)
	                .body(body)
	                .when()
	                .post();
	    }

	    public Response deletePlace(String placeId) {
	        String resource = "/maps/api/place/delete/json";
	        String key = "qaclick123";
	        String body = "{\n" +
	                "    \"place_id\":\"" + placeId + "\"\n" +
	                "}";
	        return given()
	                .baseUri(BASE_URL)
	                .basePath(resource)
	                .queryParam("key", key)
	                .contentType(ContentType.JSON)
	                .body(body)
	                .when()
	                .delete();
	    }

	    public Response getPlace(String placeId) {
	        String resource = "/maps/api/place/get/json";
	        String key = "qaclick123";
	        return given()
	                .baseUri(BASE_URL)
	                .basePath(resource)
	                .queryParam("key", key)
	                .queryParam("place_id", placeId)
	                .when()
	                .get();
	    }

	    public Response updatePlace(String placeId, String address) {
	        String resource = "/maps/api/place/update/json";
	        String key = "qaclick123";
	        String body = "{\n" +
	                "\"place_id\":\"" + placeId + "\",\n" +
	                "\"address\":\"" + address + "\",\n" +
	                "\"key\":\"" + key + "\"\n" +
	                "}";
	        return given()
	                .baseUri(BASE_URL)
	                .basePath(resource)
	                .queryParam("key", key)
	                .contentType(ContentType.JSON)
	                .body(body)
	                .when()
	                .put();
	    }

}
