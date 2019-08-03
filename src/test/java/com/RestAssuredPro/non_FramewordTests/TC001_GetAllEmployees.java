package com.RestAssuredPro.non_FramewordTests;

import org.testng.annotations.BeforeClass;

import com.RestAssuredPro.base.TeBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GetAllEmployees extends TeBase{
	
	@BeforeClass
	public void getAllEmployees() throws Exception {
		
		logger.info("*******StartedTC001_GetAllEmployees*******");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/employees");
		Thread.sleep(3);
		
	}
	

}
