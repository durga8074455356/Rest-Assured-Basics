package pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

public class DeserializeJacksonAPI {

    @Test
    public void testDeserialization() throws JsonProcessingException {
    	String baseURI = "https://rahulshettyacademy.com";

        // Perform the API request and get the response
        String key = "qaclick123";
        String resource = "/maps/api/place/update/json";
        UpdatePlaceRequest request = new UpdatePlaceRequest();
        request.setPlace_id("f5fa784d5bcbc71046e29e0bee99a1e4");
        request.setAddress("Cogniant, HYD");
        request.setKey("qaclick123");
        Response response = RestAssured.given().baseUri(baseURI).queryParam("key", key).body(request).when().put(resource);
        // Deserialize the JSON response to a Java object
        ObjectMapper objectMapper = new ObjectMapper();
        UpdatePlaceRequest responseObject = objectMapper.readValue(response.asString(), UpdatePlaceRequest.class);
        Assert.assertEquals(responseObject.getMsg(), "Update address operation failed, looks like the data doesn't exists");
        System.out.println(responseObject.getMsg());
        

         
    }
}