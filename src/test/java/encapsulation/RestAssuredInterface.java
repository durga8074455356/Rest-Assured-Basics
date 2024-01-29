package encapsulation;

import io.restassured.response.Response;

public interface RestAssuredInterface 
{
	Response addPlace();

    Response deletePlace(String placeId);

    Response getPlace(String placeId);

    Response updatePlace(String placeId, String address);

}
