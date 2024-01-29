package storeTheJSONData;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class RestAssuredStoreJSON {

	@Test
	public void addPlaceTest() throws IOException {
		// Set base URI
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		// Create request body
		JSONObject requestBody = new JSONObject();
		requestBody.put("location", new JSONObject()
				.put("lat", -38.383494)
				.put("lng", 33.427362));
		requestBody.put("accuracy", 50);
		requestBody.put("name", "Frontline house");
		requestBody.put("phone_number", "(+91) 983 893 3937");
		requestBody.put("address", "29, side layout, cohen 09");
		requestBody.put("types", new String[]{"shoe park", "shop"});
		requestBody.put("website", "http://google.com");
		requestBody.put("language", "French-IN");

		// Send POST request
		Response response = RestAssured.given()
				.queryParam("key", "qaclick123")
				.contentType(ContentType.JSON)
				.body(requestBody.toString())
				.when()
				.post("/maps/api/place/add/json");

		// Store response in a JSON file

		byte[] responseBody = response.asByteArray();

		File jsonFile = new File("src/test/resources/response.json");
		Files.write(responseBody, jsonFile);
		System.out.println("Response recorded");
	}
}



