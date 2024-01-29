package intermediate;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.io.File;

public class SendPaloadAsFile {

    @Test
    public void sendJsonPayload() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // Send JSON file as payload
        File jsonPayload = new File("src/test/resources/GooglePostAddress.json");

        given()
                .queryParam("key", "qaclick123")
                .contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .post("/maps/api/place/add/json")
                .then()
                .statusCode(200);
    }
}

