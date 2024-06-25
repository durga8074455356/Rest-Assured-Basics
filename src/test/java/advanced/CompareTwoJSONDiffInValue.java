package advanced;

import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.Test;

public class CompareTwoJSONDiffInValue {

    @Test
    public void testCompareJsonObjects() {
        // Sample JSONs with the same fields but different values
        String json1 = "{\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";
        
        String json2 = "{\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"English\"\n" + // Modified field value
                "}";
        
        // Compare JSONs using JSONAssert
        try {
            JSONAssert.assertEquals(json1, json2, false);
            System.out.println("JSONs are equal");
        } catch (AssertionError e) {
            System.out.println("JSONs are not equal: " + e.getMessage());
        }
    }
}
