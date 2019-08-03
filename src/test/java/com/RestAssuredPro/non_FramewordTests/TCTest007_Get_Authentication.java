package com.RestAssuredPro.non_FramewordTests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TCTest007_Get_Authentication {
	@Test
	public void Get_Authentication() {
		
//		logger.info("************GetWeatherDetails test is Starting*************");
		//specify base Uri
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		//basic authentication
		PreemptiveBasicAuthScheme authenicationScheme= new PreemptiveBasicAuthScheme();
		authenicationScheme.setUserName("ToolsQA");
		authenicationScheme.setPassword("TestPassword");
		RestAssured.authentication=authenicationScheme;
		
		//Request Object=httprequest; "RequestSpecification" means what type of request we are going to send
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response Object
		Response response=httpRequest.request(Method.GET,"/");
		
		
		
			//print response in console
		String responseBody=response.getBody().asString();	
		System.out.println("response body is:"+ responseBody);
		//logger.info("************* Filling the Contact form with details*********************");
		
		
		//Status code validation
		int StatusCode=response.getStatusCode();
		System.out.println("response status Code is:"+StatusCode);
		Assert.assertEquals(200, StatusCode);
		
		//Statusline verification
		
		String StatusLine=response.getStatusLine();
		System.out.println("response StatusLine is:"+StatusLine);
		Assert.assertEquals("HTTP/1.1 200 OK", StatusLine);
	}
}
