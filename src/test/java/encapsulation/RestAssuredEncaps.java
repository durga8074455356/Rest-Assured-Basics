package encapsulation;

import io.restassured.response.Response;

public class RestAssuredEncaps
{

	    private RestAssuredInterface restAssuredInterface;

	    public RestAssuredEncaps() {
	        restAssuredInterface = new RestAssuredImplementation();
	    }

	    public String addPlace() {
	        Response response = restAssuredInterface.addPlace();
	        return response.jsonPath().getString("place_id");
	    }

	    public String getPlace(String placeId) {
	        Response response = restAssuredInterface.getPlace(placeId);
	        return response.jsonPath().getString("address");
	    }

	    public String updatePlace(String placeId, String address) {
	        Response response = restAssuredInterface.updatePlace(placeId, address);
	        return response.jsonPath().getString("msg");
	    }

	    public String deletePlace(String placeId) {
	        Response response = restAssuredInterface.deletePlace(placeId);
	        return response.jsonPath().getString("status");

}
}
