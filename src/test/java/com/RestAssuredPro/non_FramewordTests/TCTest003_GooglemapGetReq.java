package com.RestAssuredPro.non_FramewordTests;

import org.testng.annotations.Test;

import com.RestAssuredPro.base.TeBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TCTest003_GooglemapGetReq {
	
	@Test
	public void googlgemapGetRequest() {
		TeBase tebase=new TeBase();
		tebase.setup();
		
		//logger.info("************GetWeatherDetails test is Starting*************");
		//specify base Uri
		RestAssured.baseURI="https://maps.googleapis.com";
		
		//Request Object=httprequest; "RequestSpecification" means what type of request we are going to send
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response Object
		Response response=httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
			//print response in console
//		String responseBody=response.getBody().asString();	
//		System.out.println("response body is:"+ responseBody);
		
		//Status code validation
		int StatusCode=response.getStatusCode();
		System.out.println("response status Code is:"+StatusCode);
		Assert.assertEquals(200, StatusCode);
		
		//Validating Headers
		
		String ContentType=response.header("Content-Type");//capture details of Content-Type header
		System.out.println("content-type is :"+ContentType);
		Assert.assertEquals("application/xml; charset=UTF-8", ContentType);
		
		String contentEncoding=response.header("Content-Encoding");//capture details of Content-Encoding header
		System.out.println("Content Encoding is :"+contentEncoding);
		Assert.assertEquals("gzip", contentEncoding);
		
}
	}
