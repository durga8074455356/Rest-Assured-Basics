package nonBDDRequest;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.specification.RequestSpecification;

	public class PostRequest {

	    @Test
	    public void testAddPlace() {
	        RestAssured.baseURI = "https://rahulshettyacademy.com";
	        RequestSpecification request = RestAssured.given();

	        request.queryParam("key", "qaclick123");
	        request.header("Content-type", "application/json");

	        String requestBody = "{\r\n"
	        		+ "  \"location\": {\r\n"
	        		+ "    \"lat\": -38.383494,\r\n"
	        		+ "    \"lng\": 33.427362\r\n"
	        		+ "  },\r\n"
	        		+ "  \"accuracy\": 50,\r\n"
	        		+ "  \"name\": \"Madhapur house\",\r\n"
	        		+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
	        		+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
	        		+ "  \"types\": [\r\n"
	        		+ "    \"shoe park\",\r\n"
	        		+ "    \"shop\"\r\n"
	        		+ "  ],\r\n"
	        		+ "  \"website\": \"http://google.com\",\r\n"
	        		+ "  \"language\": \"French-IN\"\r\n"
	        		+ "}";

	        Response response = request.body(requestBody).post("/maps/api/place/add/json");
	        int statusCode = response.getStatusCode();
	        Assert.assertEquals(200, statusCode);
	    }
	}


