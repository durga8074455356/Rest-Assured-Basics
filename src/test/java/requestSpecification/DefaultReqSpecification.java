package requestSpecification;

	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	import io.restassured.RestAssured;
	import io.restassured.specification.RequestSpecification;

	public class DefaultReqSpecification {
	    RequestSpecification requestSpec;

	    @BeforeClass
	    public void setUp() {
	        RestAssured.baseURI = "https://rahulshettyacademy.com";
	        requestSpec = RestAssured.given().queryParam("key", "qaclick123");
	    }

	    @Test (priority = 1)
	    public void addPlace() {
	        String requestBody = "{\n" +
	                "  \"location\": {\n" +
	                "    \"lat\": -38.383494,\n" +
	                "    \"lng\": 33.427362\n" +
	                "  },\n" +
	                "  \"accuracy\": 50,\n" +
	                "  \"name\": \"Frontline house\",\n" +
	                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
	                "  \"address\": \"29, side layout, cohen 09\",\n" +
	                "  \"types\": [\n" +
	                "    \"shoe park\",\n" +
	                "    \"shop\"\n" +
	                "  ],\n" +
	                "  \"website\": \"http://google.com\",\n" +
	                "  \"language\": \"French-IN\"\n" +
	                "}";
	        requestSpec.body(requestBody);
	        requestSpec.contentType("application/json");
	        String response = requestSpec.post("/maps/api/place/add/json").asString();
	        System.out.println(response);
	    }

	    @Test(priority = 2)
	    public void deletePlace() {
	        String requestBody = "{\n" +
	                "    \"place_id\":\"928b51f64aed18713b0d164d9be8d67f\"\n" +
	                "}";
	        requestSpec.body(requestBody);
	        requestSpec.contentType("application/json");
	        String response = requestSpec.delete("/maps/api/place/delete/json").asString();
	        System.out.println(response);
	    }

	    @Test(priority = 3)
	    public void getPlace() {
	        requestSpec.queryParam("place_id", "8d2573bdf6ceec0e474c5f388fa917fb");
	        String response = requestSpec.get("/maps/api/place/get/json").asString();
	        System.out.println(response);
	    }

	    @Test(priority = 4)
	    public void updatePlace() {
	        String requestBody = "{\n" +
	                "\"place_id\":\"8d2573bdf6ceec0e474c5f388fa917fb\",\n" +
	                "\"address\":\"70 Summer walk, USA\",\n" +
	                "\"key\":\"qaclick123\"\n" +
	                "}";
	        requestSpec.body(requestBody);
	        requestSpec.contentType("application/json");
	        String response = requestSpec.put("/maps/api/place/update/json").asString();
	        System.out.println(response);
	    }
	}

