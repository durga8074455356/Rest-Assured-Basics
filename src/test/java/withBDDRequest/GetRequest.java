package withBDDRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class GetRequest {

	@Test
	public void testAddUpdateGetDeletePlace() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		// Add place
		String addPlaceRequestBody = "{\n" +
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
		String placeId = given()
				.log().all()
				.queryParam("key", "qaclick123")
				.contentType(ContentType.JSON)
				.body(addPlaceRequestBody)
				.when()
				.post("/maps/api/place/add/json")
				.then()
				.log().all()
				.assertThat()
				.statusCode(200)
				.body("scope", equalTo("APP"))
				.extract()
				.path("place_id");

		// Update place
		String updatePlaceRequestBody = "{\n" +
				"  \"place_id\": \"" + placeId + "\",\n" +
				"  \"address\": \"70 Summer walk, USA\",\n" +
				"  \"key\": \"qaclick123\"\n" +
				"}";
		given()
		.log().all()
		.queryParam("key", "qaclick123")
		.contentType(ContentType.JSON)
		.body(updatePlaceRequestBody)
		.when()
		.put("/maps/api/place/update/json")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.body("msg", equalTo("Address successfully updated"));

		// Get place
		given()
		.log().all()
		.queryParam("key", "qaclick123")
		.queryParam("place_id", placeId)
		.contentType(ContentType.JSON)
		.when()
		.get("/maps/api/place/get/json")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.body("address", equalTo("70 Summer walk, USA"));

		// Delete place
		String deletePlaceRequestBody = "{\n" +
				"    \"place_id\":\"" + placeId + "\"\n" +
				"}";
		given()
		.log().all()
		.queryParam("key", "qaclick123")
		.contentType(ContentType.JSON)
		.body(deletePlaceRequestBody)
		.when()
		.delete("/maps/api/place/delete/json")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.body("status", equalTo("OK"));
	}
}


