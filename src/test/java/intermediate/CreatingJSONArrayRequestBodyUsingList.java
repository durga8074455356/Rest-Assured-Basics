package intermediate;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;

public class CreatingJSONArrayRequestBodyUsingList {

    @Test
    public void createJsonArrayRequestBody() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        List<Map<String, Object>> requestBody = new ArrayList<>();

        Map<String, Object> jsonObject1 = new HashMap<>();
        jsonObject1.put("location", new HashMap<String, Double>()
        {{
            put("lat", -38.383494);
            put("lng", 33.427362);
        }});
        jsonObject1.put("accuracy", 50);
        jsonObject1.put("name", "Frontline house");
        jsonObject1.put("phone_number", "(+91) 983 893 3937");
        jsonObject1.put("address", "29, side layout, cohen 09");
        jsonObject1.put("types", new String[]{"shoe park", "shop"});
        jsonObject1.put("website", "http://google.com");
        jsonObject1.put("language", "French-IN");

        Map<String, Object> jsonObject2 = new HashMap<>();
        jsonObject2.put("location", new HashMap<String, Double>() {{
            put("lat", -33.8669710);
            put("lng", 151.1958750);
        }});
        jsonObject2.put("accuracy", 50);
        jsonObject2.put("name", "Sydney Opera House");
        jsonObject2.put("phone_number", "(02) 9250 7111");
        jsonObject2.put("address", "Bennelong Point, Sydney NSW 2000, Australia");
        jsonObject2.put("types", new String[]{"opera house"});
        jsonObject2.put("website", "http://sydneyoperahouse.com");
        jsonObject2.put("language", "English");

        requestBody.add(jsonObject1);
        requestBody.add(jsonObject2);

        RestAssured.given()
                .queryParam("key", "qaclick123")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/maps/api/place/add/json")
                .then()
                .statusCode(200);
    }
}


