package practice;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequest 
{
	@Test
	public void putTest()
	{
		JSONObject jsonBody= new JSONObject();
		jsonBody.put("name", "Durga");
		jsonBody.put("job", "QA");
		System.out.println(jsonBody);		
		System.out.println(jsonBody.toString());
		
		RestAssured.given().header("Contente-Type", "application/JSON").contentType(ContentType.JSON)
		.body(jsonBody.toString())
		.when()
		.put("https://reqres.in/api/users/2")
		.then()
		.statusCode(200).log().all();
	}
}