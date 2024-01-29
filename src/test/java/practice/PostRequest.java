package practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
 

public class PostRequest
{
	@org.testng.annotations.Test
	public void PostTest()
	{
		String requestBody="{\"name\" : \"kanak\",\"password\" : \"kanak123\"}";
		
		RequestSpecification request= RestAssured.given().baseUri("https://reqres.in/api/users")
				.body(requestBody)
				.contentType(ContentType.JSON);
		
		Response response= request.post();
		ValidatableResponse validate=response.then().statusCode(201);
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
	}

}
