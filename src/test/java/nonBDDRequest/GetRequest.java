package nonBDDRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class GetRequest {

	    @Test
	    public void testGetPlace() {
	        RestAssured.baseURI = "https://rahulshettyacademy.com";
	        RequestSpecification request = RestAssured.given();

	        request.queryParam("key", "qaclick123");
	        request.queryParam("place_id", "b5dd4179fa658d7360aace6d25667065");
	        request.header("Content-type", "application/json");

	        Response response = request.get("/maps/api/place/get/json");
	        int statusCode = response.getStatusCode();
	        Assert.assertEquals(200, statusCode);
	    }
	}


