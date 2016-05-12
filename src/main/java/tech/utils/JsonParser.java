package tech.utils;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import tech.beans.Entities;
import tech.beans.HashTags;
import tech.beans.Statuses;
import tech.beans.TwitterBean;

public class JsonParser {
	public static void parse(String json) throws Exception {
		ObjectMapper mapper=new ObjectMapper();
		TwitterBean bean=mapper.readValue(json, TwitterBean.class);
		Statuses[] status=bean.getStatuses();
		for(Statuses stat:status){
			Entities entity=stat.getEntities();
			HashTags hashtags[]=entity.getHashtags();
			for(HashTags hashtag:hashtags){
				System.out.println(hashtag.getText());
			}
		}
	}
	
	public static String getParsedBearerToken(String json) throws Exception{
		JsonFactory factory = new JsonFactory();

		ObjectMapper mapper = new ObjectMapper(factory);
		JsonNode rootNode;
		String bearer_token=null;
		try {
			rootNode = mapper.readTree(json);
			Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
			while (fieldsIterator.hasNext()) {

				Map.Entry<String, JsonNode> field = fieldsIterator.next();
				if(field.getKey().equals("error"))
					throw new Exception("Invalid Credentials");
				else if(field.getKey().equals("access_token"))
					bearer_token=field.getValue().textValue();
				System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());
				
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bearer_token;
	}
}
