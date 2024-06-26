package advanced;


import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;

public class JSONPathForNestedArray {

    @Test
    public void testNestedJsonArray() {
        String jsonString = "{\r\n" +
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

        // Get JsonPath instance of above JSON string
        JsonPath jsonPath = JsonPath.from(jsonString);

        // Extract and print specific values
        String placeId = jsonPath.getString("location.lat");
        String address = jsonPath.getString("address");
        String key = jsonPath.getString("language");

        System.out.println("Latitude is: " + placeId);
        System.out.println("Address is: " + address);
        System.out.println("Language is: " + key);

        // Extract and print nested array values
        List<String> types = jsonPath.getList("types");
        System.out.println("Types: " + types);
        Assert.assertEquals(types.size(), 2);
    }
}


