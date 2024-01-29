package requestSpecification;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

public class ReqnResponseSpecification 
{
	RequestSpecification requestSpec = new RequestSpecBuilder()
	        .setBaseUri("https://rahulshettyacademy.com")
	        .addQueryParam("key", "qaclick123")
	        .build();
	
	ResponseSpecification responseSpec = new ResponseSpecBuilder()
	        .expectStatusCode(200)
	        .build();
	
	@Test
	public void addPlace() {
		
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
	    
	    RestAssured.given()
	            .spec(requestSpec)
	            .body(requestBody)
	            .when()
	            .post("/maps/api/place/add/json")
	            .then().log().all()
	            .spec(responseSpec);
	}
	    
	    public void getPlace() {
	        String placeId = "8d2573bdf6ceec0e474c5f388fa917fb";
	        RestAssured.given()
	                .spec(requestSpec)
	                .queryParam("place_id", placeId)
	                .when()
	                .get("/maps/api/place/get/json")
	                .then().log().all()
	                .spec(responseSpec);
	    }
	  
	    public void updatePlace() {
	        String requestBody = "{\n" +
	                "\"place_id\":\"8d2573bdf6ceec0e474c5f388fa917fb\",\n" +
	                "\"address\":\"70 Summer walk, USA\",\n" +
	                "\"key\":\"qaclick123\"\n" +
	                "}";
	        RestAssured.given()
	                .spec(requestSpec)
	                .body(requestBody)
	                .when()
	                .put("/maps/api/place/update/json")
	                .then()
	                .spec(responseSpec);
	    }
	    public void deletePlace() {
	        String requestBody = "{\n" +
	                "    \"place_id\":\"928b51f64aed18713b0d164d9be8d67f\"\n" +
	                "}";
	        RestAssured.given()
	                .spec(requestSpec)
	                .body(requestBody)
	                .when()
	                .delete("/maps/api/place/delete/json")
	                .then().log().all()
	                .spec(responseSpec);
	    }
	}

