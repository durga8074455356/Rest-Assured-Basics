package advanced;


import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UsingJsonArrayGetPathMethods {

    @Test
    public void parseJsonObjectToReadValues() throws JsonMappingException, JsonProcessingException {
        String jsonObject = "{\r\n" + 
                "  \"location\": {\r\n" + 
                "    \"lat\": -38.383494,\r\n" + 
                "    \"lng\": 33.427362\r\n" + 
                "  },\r\n" + 
                "  \"accuracy\": 50,\r\n" + 
                "  \"name\": \"Frontline house\",\r\n" + 
                "  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
                "  \"address\": \"29, side layout, cohen 09\",\r\n" + 
                "  \"types\": [\r\n" + 
                "    \"shoe park\",\r\n" + 
                "    \"shop\"\r\n" + 
                "  ],\r\n" + 
                "  \"website\": \"http://google.com\",\r\n" + 
                "  \"language\": \"French-IN\"\r\n" + 
                "}";

        // Creating an instance of ObjectMapper class
        ObjectMapper objectMapper = new ObjectMapper();
        // Get tree representation of JSON
        JsonNode jsonTree = objectMapper.readTree(jsonObject);

        // Get values using get() and path() methods
        double lat = jsonTree.path("location").path("lat").asDouble();
        double lng = jsonTree.path("location").path("lng").asDouble();
        int accuracy = jsonTree.get("accuracy").asInt();
        String name = jsonTree.get("name").asText();
        String phoneNumber = jsonTree.get("phone_number").asText();
        String address = jsonTree.get("address").asText();
        String type1 = jsonTree.path("types").get(0).asText();
        String type2 = jsonTree.path("types").get(1).asText();
        String website = jsonTree.get("website").asText();
        String language = jsonTree.get("language").asText();

        // Print values
        System.out.println("Latitude is    : " + lat);
        System.out.println("Longitude is   : " + lng);
        System.out.println("Accuracy is    : " + accuracy);
        System.out.println("Name is        : " + name);
        System.out.println("Phone Number is: " + phoneNumber);
        System.out.println("Address is     : " + address);
        System.out.println("Type 1 is      : " + type1);
        System.out.println("Type 2 is      : " + type2);
        System.out.println("Website is     : " + website);
        System.out.println("Language is    : " + language);
    }
}
