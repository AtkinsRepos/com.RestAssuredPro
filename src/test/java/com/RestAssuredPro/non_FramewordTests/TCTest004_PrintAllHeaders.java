package com.RestAssuredPro.non_FramewordTests;

import org.testng.annotations.Test;

import com.RestAssuredPro.base.TeBase;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TCTest004_PrintAllHeaders {
	
	@Test
	public void printingAllHeaders() {
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
//				String responseBody=response.getBody().asString();	
//				System.out.println("response body is:"+ responseBody);
//				
				//Status code validation
				int StatusCode=response.getStatusCode();
				System.out.println("response status Code is:"+StatusCode);
				Assert.assertEquals(200, StatusCode);
						
				
				Headers AllHeaders=response.headers();//capture all the headers and value  from the response
				
				  for(Header header:AllHeaders)
				  {
					  System.out.println(header.getName() +"   "+  header.getValue());
					  
				  }
				
	
	}

}
