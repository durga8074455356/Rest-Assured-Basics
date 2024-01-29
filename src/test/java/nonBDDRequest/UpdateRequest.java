package nonBDDRequest;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class UpdateRequest {

	    @Test
	    public void testUpdatePlace() {
	        RestAssured.baseURI = "https://rahulshettyacademy.com";
	        RequestSpecification request = RestAssured.given();

	        request.queryParam("key", "qaclick123");
	        request.header("Content-type", "application/json");

	        String requestBody = "{\n" +
	                "  \"place_id\": \"b5dd4179fa658d7360aace6d25667065\",\n" +
	                "  \"address\": \"70 Summer walk, USA\",\n" +
	                "  \"key\": \"qaclick123\"\n" +
	                "}";

	        Response response = request.body(requestBody).put("/maps/api/place/update/json");
	        int statusCode = response.getStatusCode();
	        Assert.assertEquals(200, statusCode);
	    }
	}


