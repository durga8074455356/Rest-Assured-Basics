package practice;


import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class WritingResponseInTXTFile 
{
	@Test
	public void txtFile() throws IOException
	{
		String body="{\"name\" : \"kanak\",\"password\" : \"kanak123\"}";
		String BaseURI="https://reqres.in/api/users";
		
		
		RequestSpecification request= RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.baseUri(BaseURI)
				.body(body);
		Response response= request.post();
		System.out.println("The StatusCode is"+response.getStatusCode());
		ValidatableResponse validate=response.then();
				
		int statusCode=response.getStatusCode();
		byte[] txtdata=response.asByteArray();

//		assertEquals(statusCode, 201);
		File txtfile=new File("D:\\Eclipse\\BasicRestAssuredPOCProject\\src\\test\\resources\\testingtheLog.txt");
		Files.write(txtdata, txtfile);
		System.out.println("recorded");
	}

}
