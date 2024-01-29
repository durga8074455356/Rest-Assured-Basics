package requestSpecification;


	import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
	import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;
	import io.restassured.specification.QueryableRequestSpecification;
	import io.restassured.specification.RequestSpecification;
	import io.restassured.specification.SpecificationQuerier;
	import org.testng.Assert;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import static io.restassured.RestAssured.given;

	public class QueryableReSpecification {

	    private RequestSpecification requestSpec;

	    @BeforeClass
	    public void setup() {
	        RestAssured.baseURI = "https://rahulshettyacademy.com";
	        requestSpec = given()
	                .queryParam("key", "qaclick123")
	                .contentType(ContentType.JSON);
	    }

	    @Test
	    public void testAddPlace() {
	        String resource = "/maps/api/place/add/json";
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
	        Response response = requestSpec.body(requestBody)
	                .post(resource);
	        Assert.assertEquals(response.getStatusCode(), 200);
	        JsonPath jsonPath = response.jsonPath();
	        String placeId = jsonPath.getString("place_id");

	        

	        System.out.println("Place added with ID: " + placeId);
	    }


	  
	    @Test(dependsOnMethods = "testAddPlace")
	    public void testQueryRequestSpecification() {
	        QueryableRequestSpecification queryableRequestSpec = SpecificationQuerier.query(requestSpec);
	        String baseUri = queryableRequestSpec.getBaseUri();

	        System.out.println("Base URI: " + baseUri);
	    }
	}


