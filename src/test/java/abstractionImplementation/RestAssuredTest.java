package abstractionImplementation;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RestAssuredTest {
    private static String placeId;

    @Test(priority = 1)
    public void testAddPlace() {
        Response response = RestAssuredProgram.addPlace();
        Assert.assertEquals(response.getStatusCode(), 200);
        placeId = response.jsonPath().getString("place_id");
    }

    @Test(priority = 2)
    public void testGetPlace() {
        Response response = RestAssuredProgram.getPlace(placeId);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("address"), "29, side layout, cohen 09");
    }

    @Test(priority = 3)
    public void testUpdatePlace() {
        Response response = RestAssuredProgram.updatePlace(placeId, "70 Summer walk, USA");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("msg"), "Address successfully updated");
    }

    @Test(priority = 4)
    public void testDeletePlace() {
        Response response = RestAssuredProgram.deletePlace(placeId);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("status"), "OK");
    }
}