package advanced;


import java.util.Iterator;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetAllKeysFromSimpleJSON {

    @Test
    public void getAllKeysFromJsonObjectUsingObjectMapper() throws JsonMappingException, JsonProcessingException {

        String jsonObject = "{\r\n" + 
                "  \"place_id\": \"8d2573bdf6ceec0e474c5f388fa917fb\",\r\n" + 
                "  \"address\": \"70 Summer walk, USA\",\r\n" + 
                "  \"key\": \"qaclick123\"\r\n" + 
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
                String fieldName = fieldNames.next();
                JsonNode childNode = jsonNode.get(fieldName);
                String fullKey = parentKey.isEmpty() ? fieldName : parentKey + "." + fieldName;
                System.out.println(fullKey);
                getAllKeys(childNode, fullKey);
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
