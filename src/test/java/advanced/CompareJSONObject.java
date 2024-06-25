package advanced;

import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class CompareJSONObject {

    @Test
    public void testCompareJsonObjects() {
        // Given JSON object
        String givenJson = "{\n" +
                "  \"place_id\": \"8d2573bdf6ceec0e474c5f388fa917fb\",\n" +
                "  \"address\": \"70 Summer walk, USA\",\n" +
                "  \"key\": \"qaclick123\"\n" +
                "}";
        
        // Expected JSON object
        String expectedJson = "{\n" +
                "  \"place_id\": \"8d2573bdf6ceec0e474c5f388fa917fb\",\n" +
                "  \"address\": \"70 Summer walk, USA\",\n" +
                "  \"key\": \"qaclick123\"\n" +
                "}";
        
        // Compare JSON objects using JSONAssert with STRICT mode
        try {
            JSONAssert.assertEquals(expectedJson, givenJson, JSONCompareMode.STRICT);
            System.out.println("JSONs are equal");
        } catch (AssertionError e) {
            System.out.println("JSONs are not equal: " + e.getMessage());
        }
    }
}
