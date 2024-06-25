package advanced;


import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UsingJsonObjectForGetPathAt {

    @Test
    public void parseJsonObjectToReadValues() throws JsonMappingException, JsonProcessingException {
        String jsonObject = "{\r\n" + 
                "  \"place_id\": \"8d2573bdf6ceec0e474c5f388fa917fb\",\r\n" + 
                "  \"address\": \"70 Summer walk, USA\",\r\n" + 
                "  \"key\": \"qaclick123\"\r\n" + 
                "}";

        // Creating an instance of ObjectMapper class
        ObjectMapper objectMapper = new ObjectMapper();
        // Get tree representation of JSON
        JsonNode jsonTree = objectMapper.readTree(jsonObject);

        // Using get() method
        String placeIdGet = jsonTree.get("place_id").asText();
        String addressGet = jsonTree.get("address").asText();
        String keyGet = jsonTree.get("key").asText();

        System.out.println("Using get() method:");
        System.out.println("Place ID is  : " + placeIdGet);
        System.out.println("Address is   : " + addressGet);
        System.out.println("Key is       : " + keyGet);

        // Using path() method
        String placeIdPath = jsonTree.path("place_id").asText();
        String addressPath = jsonTree.path("address").asText();
        String keyPath = jsonTree.path("key").asText();

        System.out.println("Using path() method:");
        System.out.println("Place ID is  : " + placeIdPath);
        System.out.println("Address is   : " + addressPath);
        System.out.println("Key is       : " + keyPath);

        // Using at() method
        String placeIdAt = jsonTree.at("/place_id").asText();
        String addressAt = jsonTree.at("/address").asText();
        String keyAt = jsonTree.at("/key").asText();

        System.out.println("Using at() method:");
        System.out.println("Place ID is  : " + placeIdAt);
        System.out.println("Address is   : " + addressAt);
        System.out.println("Key is       : " + keyAt);
    }
}
