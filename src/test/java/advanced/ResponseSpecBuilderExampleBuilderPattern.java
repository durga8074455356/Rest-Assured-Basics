package advanced;


import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecBuilderExampleBuilderPattern {
	
	ResponseSpecification responseSpecification = null;
	
	@BeforeClass
	public void setupResponseSpecification()
	{
		// Create a ResponseSpecification using ResponseSpecBuilder
		responseSpecification = new ResponseSpecBuilder()
			.expectStatusCode(200)
		    .expectStatusLine("HTTP/1.1 200 OK")
		    .expectContentType(ContentType.JSON)
		    .expectResponseTime(Matchers.lessThan(5000L))	
		    .build();
	}
	
	@Test
	public void addPlace() {
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
			.baseUri(baseUrl)
			.queryParam("key", queryParamKey)
			.contentType(ContentType.JSON)
			.body(jsonBody)
			.post(resource)
			.then()
			.spec(responseSpecification)
			.log().body()
			.log().headers();
	}
}

