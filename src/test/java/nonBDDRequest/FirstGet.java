package nonBDDRequest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
 
public class FirstGet {
@Test
	public void get_test()
	{
		Response response = RestAssured.get("https://rahulshettyacademy.com");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
	}
}

