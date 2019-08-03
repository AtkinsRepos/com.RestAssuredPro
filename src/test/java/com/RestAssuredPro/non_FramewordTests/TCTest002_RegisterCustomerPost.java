package com.RestAssuredPro.non_FramewordTests;

import static org.testng.Assert.assertEquals;

import org.apache.commons.math3.analysis.solvers.SecantSolver;
import org.codehaus.groovy.control.customizers.builder.PostCompletionFactory;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.RestAssuredPro.base.TeBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TCTest002_RegisterCustomerPost {
	
	@Test
	public void registerCustomer() {
		TeBase tebase=new TeBase();
		tebase.setup();
	RestAssured.baseURI="http://restapi.demoqa.com/customer";
	RequestSpecification httpRequest=RestAssured.given();
//RequestSpecification payload SecantSolver for assertEquals(PostCompletionFactory request, expected);
	JSONObject requestParams= new JSONObject();
	requestParams.put("FirstName", "Marykt");
	requestParams.put("LastName", "Bungatt");
	requestParams.put("UserName", "Marybugatt");
	requestParams.put("Password", "MKbuga22tt");
	requestParams.put("Email", "marttyk22@email.com");
	//also specify a post header
	httpRequest.header("Content-Type", "application/json");
	//and convert to JSON format
	httpRequest.body(requestParams.toJSONString());
			
	//Now send the post request
	Response response=httpRequest.request(Method.POST,"/register");
	
//	String responseBody=response.getBody().asString();	
//	System.out.println("response body is:"+ responseBody);
	
	//Status code validation
	int StatusCode=response.getStatusCode();
	System.out.println("response status Code is:"+StatusCode);
	Assert.assertEquals(201, StatusCode);
	//Success Code Validation
	String successCode=response.jsonPath().get("SuccessCode");
	Assert.assertEquals("OPERATION_SUCCESS", successCode);
	
	
	}
	
}
