package pojo;

import java.util.Arrays;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class POJONestedArrayputRequest
{
	@Test
	
	public void testPutPlace()
	{

AddPlaceArrayRequest place1 = new AddPlaceArrayRequest();
place1.setLocation(new Location(-38.383494, 33.427362));
place1.setAccuracy(50);
place1.setName("Madhapur house");
place1.setPhone_number("(+91) 983 893 3937");
place1.setAddress("29, side layout, cohen 09");
place1.setTypes(Arrays.asList("shoe park", "shop"));
place1.setWebsite("http://google.com");
place1.setLanguage("French-IN");

AddPlaceArrayRequest place2 = new AddPlaceArrayRequest();
place2.setLocation(new Location(-37.383494, 34.427362));
place2.setAccuracy(50);
place2.setName("BACKLINE house");
place2.setPhone_number("(+91) 983 893 3938");
place2.setAddress("29, side layout, cohen 09");
place2.setTypes(Arrays.asList("shoe park", "shop"));
place2.setWebsite("http://google.com");
place2.setLanguage("French-IN");

// Make the POST request using RestAssured
Response response = given()
    .baseUri("https://rahulshettyacademy.com")
    .basePath("/maps/api/place/add/json")
    .queryParam("key", "qaclick123")
    .body(Arrays.asList(place1, place2))
.when()
    .post();

response.then()
.statusCode(200);


}}