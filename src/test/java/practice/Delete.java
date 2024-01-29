package practice;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Delete 
{
	@Test
	public void deleteTest()
	{
		
		RequestSpecification request= RestAssured.given()
				.contentType(ContentType.JSON).accept(ContentType.JSON);
		Response response= request.delete("https://reqres.in/api/users/2");
		
		ValidatableResponse validate=response.then().statusCode(204);
		System.out.println("The Response Code is "+response.getStatusCode());
		assertEquals(response.getStatusCode(), 204);
				
		
		
	}

}
