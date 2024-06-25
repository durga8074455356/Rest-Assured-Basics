package advanced;


import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo; // Import equalTo from Hamcrest Matchers
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class WriteJSONSyntax {

    @Test
    public void extractDataFromJsonRequest() {
    	
    	  String baseUrl = "https://rahulshettyacademy.com";
          String resource = "/maps/api/place/add/json";
        String requestBody = "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";

        //Get JsonPath instance of above JSON string
        JsonPath jsonPath = JsonPath.from(requestBody);

        // Extracting values using JsonPath expressions
        String phoneNumber = jsonPath.getString("phone_number");
        System.out.println("Phone Number: " + phoneNumber);

        String website = jsonPath.getString("website");
        System.out.println("Website: " + website);

        String language = jsonPath.getString("language");
        System.out.println("Language: " + language);

        // Extracting values from nested objects
        double latitude = jsonPath.getDouble("location.lat");
        double longitude = jsonPath.getDouble("location.lng");
        System.out.println("Latitude: " + latitude);
        System.out.println("Longitude: " + longitude);

        // Extracting values from JSON array
        String firstType = jsonPath.getString("types[0]");
        String secondType = jsonPath.getString("types[1]");
        System.out.println("First Type: " + firstType);
        System.out.println("Second Type: " + secondType);
        
      
    }
}
