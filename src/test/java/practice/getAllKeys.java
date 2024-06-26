package practice;

import java.util.Iterator;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class getAllKeys
{
	@Test
	public void test() throws JsonMappingException, JsonProcessingException {
		String object= "{\r\n" + 
                "  \"location\": {\r\n" + 
                "    \"lat\": -38.383494,\r\n" + 
                "    \"lng\": 33.427362\r\n" + 
                "  },\r\n" + 
                "  \"accuracy\": 50,\r\n" + 
                "  \"name\": \"Frontline house\",\r\n" + 
                "  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
                "  \"address\": \"29, side layout, cohen 09\",\r\n" + 
                "  \"types\": [\r\n" + 
                "    \"shoe park\",\r\n" + 
                "    \"shop\"\r\n" + 
                "  ],\r\n" + 
                "  \"website\": \"http://google.com\",\r\n" + 
                "  \"language\": \"French-IN\"\r\n" + 
                "}";
		ObjectMapper objectMapper= new ObjectMapper();
		JsonNode parseJsonNode=objectMapper.readTree(object);
		System.out.println("All Keys are");
		getAllKeys(parseJsonNode,"");
		
	}
	
	private void getAllKeys(JsonNode jsonNode, String parentNode)
	{
		if(jsonNode.isObject())
		{
			Iterator<String> fieldNames=jsonNode.fieldNames();
			while(fieldNames.hasNext()) {
				String fieldName=fieldNames.next();
				JsonNode childNode=jsonNode.get(fieldName);
				String fullKey= parentNode.isEmpty()? fieldName: parentNode+"."+fieldName;
				System.out.println(fullKey);
				getAllKeys(childNode, fullKey);			
				
		}
	}
		else if(jsonNode.isArray())
		{
			for(int i=0;i<=jsonNode.size();i++)
			{
				JsonNode arrayElement=jsonNode.get(i);
                String fullKey = parentNode + "[" + i + "]";
                getAllKeys(arrayElement,fullKey);
				
			}
		}
		
}}
