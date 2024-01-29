package pojo;


import static io.restassured.RestAssured.given;
 

import org.testng.annotations.Test;



public class POJOARRAYJSONAddArrayrequest {

	@Test
	public void updatePlaces() {
	    UpdatePlaceRequestArray[] places = {
	            new UpdatePlaceRequestArray("2573bdf6ceec0e474c5f388fa917fb", "71 Summer walk, USA", "qaclick123"),
	            new UpdatePlaceRequestArray("d2573bdf6ceec0e474c5f388fa917fb", "70 Summer walk, USA", "qaclick123"),
	            new UpdatePlaceRequestArray("9d2573bdf6ceec0e474c5f388fa917fb", "73 Summer walk, USA", "qaclick123")
	    };

	    given()
	        .queryParam("key", "qaclick123")
	        .body(places)
	    .when()
	        .put("https://rahulshettyacademy.com/maps/api/place/update/json")
	    .then()
	        .statusCode(200).log().all();
	    
	    
	}
}