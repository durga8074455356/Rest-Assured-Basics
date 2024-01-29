package inheritanceImplementation;

import org.json.JSONObject;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class BaseTest {
	    protected static final String BASE_URL = "https://rahulshettyacademy.com";
	    protected static final String ADD_PLACE_RESOURCE = "/maps/api/place/add/json";
	    protected static final String DELETE_PLACE_RESOURCE = "/maps/api/place/delete/json";
	    protected static final String GET_PLACE_RESOURCE = "/maps/api/place/get/json";
	    protected static final String UPDATE_PLACE_RESOURCE = "/maps/api/place/update/json";
	    protected static final String KEY = "qaclick123";

	    protected Response addPlace(JSONObject requestBody) {
	        return given()
	                .queryParam("key", KEY)
	                .body(requestBody.toString())
	                .when()
	                .post(BASE_URL + ADD_PLACE_RESOURCE);
	    }

	    protected Response getPlace(String placeId) {
	        return given()
	                .queryParam("key", KEY)
	                .queryParam("place_id", placeId)
	                .when()
	                .get(BASE_URL + GET_PLACE_RESOURCE);
	    }

	    protected Response updatePlace(JSONObject requestBody) {
	        return given()
	                .queryParam("key", KEY)
	                .body(requestBody.toString())
	                .when()
	                .put(BASE_URL + UPDATE_PLACE_RESOURCE);
	    }

	    protected Response deletePlace(JSONObject requestBody) {
	        return given()
	                .queryParam("key", KEY)
	                .body(requestBody.toString())
	                .when()
	                .delete(BASE_URL + DELETE_PLACE_RESOURCE);
	    }
	}


	


