package com.RestAssuredPro.non_FramewordTests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.RestAssuredPro.base.TeBase;
import com.RestAssuredPro.utilities.DataProviderGenerator;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TCTest_DDT008_AddNewEmployee {
	
	@Test(dataProvider = "EmployeeData", dataProviderClass = DataProviderGenerator.class)
	public void postNewEmployee(String ename, String sal, String Age) {
		
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	RequestSpecification httpRequest=RestAssured.given();
	
	JSONObject requestParams= new JSONObject();
	requestParams.put("name", ename);
	requestParams.put("salary", sal);
	requestParams.put("age", Age);
	
	
	//also specify a post header
	httpRequest.header("Content-Type", "application/json");
	
	//and convert to JSON format
	httpRequest.body(requestParams.toJSONString());
			
	//Now send the post request
	Response response=httpRequest.request(Method.POST,"create");
	
	String responseBody=response.getBody().asString();	
	System.out.println("response body is:"+ responseBody);
	Assert.assertEquals(responseBody.contains(ename), true);
	Assert.assertEquals(responseBody.contains(sal), true);
	Assert.assertEquals(responseBody.contains(Age), true);
	//Status code validation
	int StatusCode=response.getStatusCode();
	System.out.println("response status Code is:"+StatusCode);
	Assert.assertEquals(200, StatusCode);
//	//Success Code Validation
//	String successCode=response.jsonPath().get("SuccessCode");
//	Assert.assertEquals("OPERATION_SUCCESS", successCode);
	
	
	}
	

}
