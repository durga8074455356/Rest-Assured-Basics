package advanced;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class OAuth {

    private final String authorizationServerUrl = "https://accounts.google.com/o/oauth2/v2/auth";
    private final String accessTokenUrl = "https://www.googleapis.com/oauth2/v4/token";
    private final String clientId = "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com";
    private final String clientSecret = "erZOWM9g3UtwNRj340YYaK_W";
    private final String scope = "https://www.googleapis.com/auth/userinfo.email";
    private final String redirectUri = "https://rahulshettyacademy.com/getCourse.php";
    private final String state = "random_string";

    @Test
    public void testOAuth2AuthorizationCodeFlow() {
        // Step 1: Get Authorization Code
        String authorizationCode = getAuthorizationCode();
        System.out.println("Authorization Code: " + authorizationCode);

        // Step 2: Get Access Token
        String accessToken = getAccessToken(authorizationCode);
        System.out.println("Access Token: " + accessToken);
        //get status code  
        makeGetRequest(accessToken);

    }

    private String getAuthorizationCode() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("scope", scope);
        queryParams.put("client_id", clientId);
        queryParams.put("response_type", "code");
        queryParams.put("redirect_uri", redirectUri);
        queryParams.put("state", state);

        Response response = RestAssured.given()
                .queryParams(queryParams)
                .get(authorizationServerUrl);
//        System.out.println("Response Status Code: " + response.asPrettyString());


        // Extract authorization code from the response
        // Parse the response HTML to extract the authorization code
        // Authorization code is received through a callback URL

        //  authorization code from callback URL
        String authorizationCode = "4%2F0AbUR2VMH_3ecpFVqp1GO-5X2LJrXrTHeEQIvWEZ7BK_E-ZAl7cpGjXl5y9EygOJKlabayA";
        return authorizationCode;
    }

    private String getAccessToken(String authorizationCode) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("code", authorizationCode);
        queryParams.put("client_id", clientId);
        queryParams.put("client_secret", clientSecret);
        queryParams.put("redirect_uri", redirectUri);
        queryParams.put("grant_type", "authorization_code");

        Response response = RestAssured.given()
                .contentType(ContentType.URLENC)
                .formParams(queryParams)
                .post(accessTokenUrl);

        // Extract access token from the response
        String accessToken = response.jsonPath().getString("access_token");
        return accessToken;
    }
    private void makeGetRequest(String accessToken) {
        // Endpoint you want to access
        String apiUrl = "https://rahulshettyacademy.com/getCourse.php";

        // Send GET request with the access token in the header
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .get(apiUrl);

        // Handle response
        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);
    }
}
