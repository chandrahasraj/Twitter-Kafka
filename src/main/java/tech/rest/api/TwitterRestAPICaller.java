package tech.rest.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import tech.utils.Constants;
import tech.utils.JsonParser;

public class TwitterRestAPICaller extends Constants {

	public static void main(String as[]) {
		try {
			String bearer_token=new TokenApi().getBearerToken(Bearer_Token_url);
			String serach_url_location=Search_Url+"?q=&geocode=33.994247,-81.032410,10km&lang=en&result_type=recent";
			new TwitterRestAPICaller().getrequest(serach_url_location, bearer_token);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getrequest(String url,String bearer_token) throws Exception{
		HttpClientBuilder builder = HttpClientBuilder.create();
		HttpClient client = builder.build();
		HttpGet get = new HttpGet(url);
		get.setHeader("User-Agent", USER_AGENT);
		get.setHeader("Content-Type", CONTENT_TYPE);

		get.setHeader("Authorization", "Bearer " + bearer_token);

		HttpResponse response = client.execute(get);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		System.out.println(result.toString());
		JsonParser.parse(result.toString());
	}
}
