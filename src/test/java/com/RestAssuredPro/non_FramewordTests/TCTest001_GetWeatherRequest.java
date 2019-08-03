package com.RestAssuredPro.non_FramewordTests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.RestAssuredPro.base.TeBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TCTest001_GetWeatherRequest {
	TeBase tebase;
	
	@Test
	public void getWeatherDetails() {
		
//		logger.info("************GetWeatherDetails test is Starting*************");
		//specify base Uri
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request Object=httprequest; "RequestSpecification" means what type of request we are going to send
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response Object
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
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
