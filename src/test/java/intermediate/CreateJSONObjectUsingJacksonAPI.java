package intermediate;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CreateJSONObjectUsingJacksonAPI 
{
	@Test
	
    public void ObjectNode() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode locationNode = mapper.createObjectNode();
        locationNode.put("lat", -38.383494);
        locationNode.put("lng", 33.427362);

        ObjectNode jsonObject = mapper.createObjectNode();
        jsonObject.set("location", locationNode);
        jsonObject.put("accuracy", 50);
        jsonObject.put("name", "Frontline house");
        jsonObject.put("phone_number", "(+91) 983 893 3937");
        jsonObject.put("address", "29, side layout, cohen 09");
        jsonObject.putArray("types").add("shoe park").add("shop");
        jsonObject.put("website", "http://google.com");
        jsonObject.put("language", "French-IN");

        System.out.println(jsonObject.toPrettyString());
    }
}