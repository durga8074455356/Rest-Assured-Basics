package advanced;

import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class CompareJSONStrictMode {

    @Test
    public void testCompareJsonObjects() {
        // Sample JSONs with the same fields but different values
        JSONObject jsonObject1 = new JSONObject("{\n" +
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
                "}");

        JSONObject jsonObject2 = new JSONObject("{\n" +
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
                "}");

        // Compare JSONs using JSONAssert with STRICT mode
        try {
            JSONAssert.assertEquals(jsonObject1, jsonObject2, JSONCompareMode.STRICT);
            System.out.println("JSONs are equal");
        } catch (AssertionError e) {
            System.out.println("JSONs are not equal: " + e.getMessage());
        }
    }
}

