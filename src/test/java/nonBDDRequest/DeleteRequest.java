package nonBDDRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
	public class DeleteRequest {

	    @Test
	    public void testDeletePlace() {
	        RestAssured.baseURI = "https://rahulshettyacademy.com";
	        RequestSpecification request = RestAssured.given();

	        request.queryParam("key", "qaclick123");
	        request.header("Content-type", "application/json");

	        String requestBody = "{\n" +
	                "  \"place_id\": \"b5dd4179fa658d7360aace6d25667065\" \n" +
	                "}";

	        Response response = request.body(requestBody).delete("/maps/api/place/delete/json");
	        int statusCode = response.getStatusCode();
	        Assert.assertEquals(200, statusCode);
	    }
	}


