package inheritanceImplementation;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import io.restassured.response.Response;

public class RestAssuredTest extends BaseTest {
    @Test
    public void testRestAssured() throws JSONException {
        JSONObject requestBody = new JSONObject();
        JSONObject location = new JSONObject();
        JSONArray types = new JSONArray();

        location.put("lat", -38.383494);
        location.put("lng", 33.427362);

        types.put("shoe park");
        types.put("shop");

        requestBody.put("location", location);
        requestBody.put("accuracy", 50);
        requestBody.put("name", "Frontline house");
        requestBody.put("phone_number", "(+91) 983 893 3937");
        requestBody.put("address", "29, side layout, cohen 09");
        requestBody.put("types", types);
        requestBody.put("website", "http://google.com");
        requestBody.put("language", "French-IN");

        Response addResponse = addPlace(requestBody);
        String placeId = addResponse.jsonPath().getString("place_id");

        Response getResponse = getPlace(placeId);
        String address = getResponse.jsonPath().getString("address");
        System.out.println(address);

        JSONObject updateRequestBody = new JSONObject();
        updateRequestBody.put("place_id", placeId);
        updateRequestBody.put("address", "70 Summer walk, USA");
        updateRequestBody.put("key", KEY);

        Response updateResponse = updatePlace(updateRequestBody);
        String msg = updateResponse.jsonPath().getString("msg");
        System.out.println(msg);

        JSONObject deleteRequestBody = new JSONObject();
        deleteRequestBody.put("place_id", placeId);

        Response deleteResponse = deletePlace(deleteRequestBody);
        String status = deleteResponse.jsonPath().getString("status");

        Assert.assertEquals(status, "OK");
    }
}