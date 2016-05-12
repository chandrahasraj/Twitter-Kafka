package tech.rest.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import tech.utils.Base64Encoder;
import tech.utils.Constants;
import tech.utils.JsonParser;

public class TokenApi extends Constants{

	protected String getBearerToken(String url) throws Exception {
		HttpClientBuilder builder = HttpClientBuilder.create();
		HttpClient client = builder.build();
		HttpPost post = new HttpPost(url);
		post.setHeader("User-Agent", USER_AGENT);
		post.setHeader("Content-Type", CONTENT_TYPE);

		post.setHeader("Authorization", "Basic " + Base64Encoder.encodeData(CONSUMER_KEY + ":" + CONSUMER_SECRET));

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("grant_type", GRANT_TYPE));

		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		HttpResponse response = client.execute(post);
		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		return JsonParser.getParsedBearerToken(result.toString());
	}
	
}
