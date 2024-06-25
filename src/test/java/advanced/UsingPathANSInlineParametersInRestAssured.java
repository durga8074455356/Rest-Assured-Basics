package advanced;


import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UsingPathANSInlineParametersInRestAssured {

    @Test
    public void testWithPathParameter() {
        // Base URL
        String baseURL = "https://rahulshettyacademy.com";

        // Resource path
        String resource = "/maps/api/place/details/json/{placeId}";

        // Path parameter value
        String placeId = "8d2573bdf6ceec0e474c5f388fa917fb";

        // Send GET request with path parameter and inline parameter
        Response response = RestAssured
            .given()
            .pathParam("placeId", placeId) // Set path parameter
            .queryParam("key", "qaclick123") // Query parameter
            .when()
            .get(baseURL + resource + "?key=qaclick123"); // Use path parameter in the URL path and add inline parameter

        // Print response body
        System.out.println("Response Body:");
        System.out.println(response.getBody().asString());

        // Validate response status code
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
    }
}
