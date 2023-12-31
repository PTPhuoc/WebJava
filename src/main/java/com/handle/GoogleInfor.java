package com.handle;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class GoogleInfor {
	public static String GOOGLE_CLIENT_ID = "200588205858-6p7j3r61fsv4k8je3o4h7p2psh1bder3.apps.googleusercontent.com";
	public static String GOOGLE_CLIENT_SECRET = "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";
	public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/ShopLinhKien/SignIn-Google";
	public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
	public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
	public static String GOOGLE_GRANT_TYPE = "authorization_code";
	
	public static String getToken(final String code) throws ClientProtocolException, IOException {
	    String response = Request.Post(GOOGLE_LINK_GET_TOKEN)
	        .bodyForm(Form.form().add("client_id", GOOGLE_CLIENT_ID)
	            .add("client_secret", GOOGLE_CLIENT_SECRET)
	            .add("redirect_uri",GOOGLE_REDIRECT_URI).add("code", code)
	            .add("grant_type", GOOGLE_GRANT_TYPE).build())
	        .execute().returnContent().asString();
	      JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
	      String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
	      return accessToken;
	  }
	
	public static GoogleAccount getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
	    String link = GOOGLE_LINK_GET_USER_INFO + accessToken;
	    String response = Request.Get(link).execute().returnContent().asString();
	    GoogleAccount Account = new Gson().fromJson(response, GoogleAccount.class);
	    System.out.println(Account);
	    return Account;
	  }
}
