package intermediate;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import pojo.UpdatePlaceRequest;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

import com.google.gson.Gson;

public class CreatingJSONObjectRequestBodyUsingJavaMap {

    @Test
    public void createJsonObjectRequestBody() {
        RestAssured.baseURI = "https://rahulshettyacademy.com/maps/api/place/add/json";

        Map<String, Object> requestBody = new HashMap<>();
        Map<String, Double> location = new HashMap<>();
        location.put("lat", -38.383494);
        location.put("lng", 33.427362);
        requestBody.put("location", location);
        requestBody.put("accuracy", 50);
        requestBody.put("name", "Frontline house");
        requestBody.put("phone_number", "(+91) 983 893 3937");
        requestBody.put("address", "29, side layout, cohen 09");
        requestBody.put("types", new String[]{"shoe park", "shop"});
        requestBody.put("website", "http://google.com");
        requestBody.put("language", "French-IN");

        
        RequestSpecification request=RestAssured.given()
          .queryParam("key", "qaclick123")
                .contentType(ContentType.JSON)
                .body(requestBody);
        
        
        Response data=request.post();
        String response=data.asString();
        AddPlaceArrayRequest sampleResponse = new Gson().fromJson(response, AddPlaceArrayRequest.class);

        System.out.println(sampleResponse);
        
        
        
       
    }
}
