package pojo;




import java.util.Arrays;

import org.testng.annotations.Test;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class JSONIgnore
{
	@Test
	
	public void testPutPlace()
	{
AddPlaceArrayRequest place1 = new AddPlaceArrayRequest();
place1.setLocation(new Location(-38.383494, 33.427362));
place1.setAccuracy(50);
place1.setName("Madhapur house");
place1.setPhone_number("9701076389");
place1.setAddress("29, side layout, cohen 09");
place1.setTypes(Arrays.asList("shoe park", "shop"));
place1.setWebsite("http://google.com");
place1.setLanguage("French-IN");



// Make the POST request using RestAssured
Response response = given()
    .baseUri("https://rahulshettyacademy.com")
    .basePath("/maps/api/place/add/json")
    .queryParam("key", "qaclick123")
    .body(Arrays.asList(place1)).log().all()
.when()
    .post();

response.then().log().all()
.statusCode(200).extract().response();

System.out.println(response.getBody().asString());


}}

