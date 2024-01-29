package pojo;


	import com.google.gson.Gson;
	import io.restassured.RestAssured;
	import io.restassured.response.Response;
	import org.testng.annotations.Test;


import org.testng.Assert;

	public class DeserializeGson {

	    @Test
	    public void testDeserialization() {
	        String baseUrl = "https://rahulshettyacademy.com";
	        String key = "qaclick123";
	        String resource = "/maps/api/place/update/json";
	        UpdatePlaceRequest request = new UpdatePlaceRequest();
	        request.setPlace_id("b5d6aafa9a22eb484fcd786346118f8");
	        request.setAddress("Cogniant, HYD");
	        request.setKey("qaclick123");
	        Response response = RestAssured.given().baseUri(baseUrl).queryParam("key", key).body(request).when().put(resource);

	        String responseBody = response.getBody().asString();
	        // Deserialize the JSON object from the API response using Gson

	        UpdatePlaceRequest sampleResponse = new Gson().fromJson(responseBody, UpdatePlaceRequest.class);
	        Assert.assertEquals(sampleResponse.getMsg(), "Update address operation failed, looks like the data doesn't exists");
	        System.out.println(sampleResponse.getMsg());
	        
	}
	}

