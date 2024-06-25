package advanced;

import java.util.Iterator;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetAllKeysFromJsonObject {

    @Test
    public void getAllKeysFromJsonObjectUsingObjectMapper() throws JsonMappingException, JsonProcessingException {

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

        ObjectMapper objectMapper = new ObjectMapper();
        // Converting JSON Object string to JsonNode
        JsonNode parsedJsonObject = objectMapper.readTree(jsonObject);

        // Get all keys recursively
        System.out.println("All keys are : ");
        getAllKeys(parsedJsonObject, "");
    }

    private void getAllKeys(JsonNode jsonNode, String parentKey) {
        if (jsonNode.isObject()) {
            Iterator<String> fieldNames = jsonNode.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next(); // Get the next field name (key)
                JsonNode childNode = jsonNode.get(fieldName);// Get the value associated with the field name
                String fullKey = parentKey.isEmpty() ? fieldName : parentKey + "." + fieldName;// Construct the full key path
                System.out.println(fullKey);
                getAllKeys(childNode, fullKey); // Recursively call getAllKeys to process the child node
            }
        } else if (jsonNode.isArray()) {
            for (int i = 0; i < jsonNode.size(); i++) {
                JsonNode arrayElement = jsonNode.get(i);
                String fullKey = parentKey + "[" + i + "]";
                getAllKeys(arrayElement, fullKey);
            }
        }
    }
}
