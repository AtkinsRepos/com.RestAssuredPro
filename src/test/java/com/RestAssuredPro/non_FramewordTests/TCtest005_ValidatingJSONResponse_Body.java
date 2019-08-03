package com.RestAssuredPro.non_FramewordTests;

import org.testng.annotations.Test;

import com.RestAssuredPro.base.TeBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TCtest005_ValidatingJSONResponse_Body {
	
	@Test
	public void ValidatingJSONResponseBody_GetweatherDetails() {
		TeBase tebase=new TeBase();
		tebase.setup();
		
	
		
		//logger.info("************GetWeatherDetails test is Starting*************");
				//specify base Uri
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
				
				//Request Object=httprequest; "RequestSpecification" means what type of request we are going to send
				RequestSpecification httpRequest=RestAssured.given();
				
				//Response Object
				Response response=httpRequest.request(Method.GET,"/Delhi");
					//print response in console
				String responseBody=response.getBody().asString();	
				System.out.println("response body is:"+ responseBody);
				
				Assert.assertEquals(responseBody.contains("Delhi"), true);
				
				
}
}