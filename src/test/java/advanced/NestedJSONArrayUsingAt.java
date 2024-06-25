package advanced;


import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NestedJSONArrayUsingAt {

    @Test
    public void parseJsonToReadValues() throws JsonMappingException, JsonProcessingException {
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

        // Using pattern expression with at() method
        double lat = jsonTree.at("/location/lat").asDouble();
        double lng = jsonTree.at("/location/lng").asDouble();
        int accuracy = jsonTree.at("/accuracy").asInt();
        String name = jsonTree.at("/name").asText();
        String phoneNumber = jsonTree.at("/phone_number").asText();
        String address = jsonTree.at("/address").asText();
        String type1 = jsonTree.at("/types/0").asText();
        String type2 = jsonTree.at("/types/1").asText();
        String website = jsonTree.at("/website").asText();
        String language = jsonTree.at("/language").asText();

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
