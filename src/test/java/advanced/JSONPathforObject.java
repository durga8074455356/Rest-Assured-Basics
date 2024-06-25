package advanced;


import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import org.testng.Assert;

public class JSONPathforObject {

    @Test
    public void testNestedJsonObject() {
        String jsonString = "{\r\n" +
                "  \"place_id\": \"8d2573bdf6ceec0e474c5f388fa917fb\",\r\n" +
                "  \"address\": \"70 Summer walk, USA\",\r\n" +
                "  \"key\": \"qaclick123\"\r\n" +
                "}";

        // Get JsonPath instance of above JSON string
        JsonPath jsonPath = JsonPath.from(jsonString);

        // Extracting values using JsonPath
        String placeId = jsonPath.getString("place_id");
        String address = jsonPath.getString("address");
        String key = jsonPath.getString("key");

        System.out.println("Place ID is : " + placeId);
        System.out.println("Address is : " + address);
        System.out.println("Key is : " + key);

        // Assert the extracted values
        Assert.assertEquals(placeId, "8d2573bdf6ceec0e474c5f388fa917fb");
        Assert.assertEquals(address, "70 Summer walk, USA");
        Assert.assertEquals(key, "qaclick123");

        // Print the whole JSON object
        System.out.println(jsonPath.getString("$"));
    }
}

