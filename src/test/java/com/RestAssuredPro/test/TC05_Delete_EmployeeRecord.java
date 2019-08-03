package com.RestAssuredPro.test;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestAssuredPro.base.TeBase;
import com.RestAssuredPro.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC05_Delete_EmployeeRecord extends TeBase{
	
	RequestSpecification httpRequest;
	 Response response;
	
	@BeforeClass
	public void Delete_EmployeeRecord() throws Exception {
		logger.info("******Started TC05_Delete_EmployeeRecord ********");

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		 httpRequest = RestAssured.given();
		 response=httpRequest.request(Method.GET,"/employees");
		
		 //In Delete, First get the JsonPath object instance from the response interface
		 JsonPath jsonPathEvaluator=response.jsonPath();
		 
		 //Then capture ID from database
		 String empID=jsonPathEvaluator.get("[0].id");
		 response=httpRequest.request(Method.DELETE, "/delete/"+empID);//passes ID to be deleted
		Thread.sleep(5000);
		
	}
	
	@Test
	public void checkResponseBody() {
		logger.info("******Checking ResponseBody********");
		String responseBody=response.getBody().asString();	
	Assert.assertEquals(responseBody.contains("successfully! deleted Records"), true);
		
	}
	@Test
	public void checkStatusCode() {
		logger.info("******Checking Status Code********");
		int StatusCode = response.getStatusCode();
		logger.info("Status Code is:" + StatusCode);
		Assert.assertEquals(200, StatusCode);
	}

	@Test
	public void checkResponseTime() {
		logger.info("******Checking ResponseTime********");
		long responsetime = response.getTime();
		logger.info("Response Time is==>" + responsetime);
		if (responsetime > 5000) {
			logger.warn("Response Time is greater than 2000");
			Assert.assertTrue(responsetime < 5000);
		}
	}

	@Test
	public void checkStatusLine() {
		logger.info("******checking Status line********");
		String StatusLine = response.getStatusLine();
		logger.info("StatusLine is:" + StatusLine);
		Assert.assertEquals("HTTP/1.1 200 OK", StatusLine);
	}

	@Test
	public void checkContentType() {
		logger.info("******Checking Content-Type********");
		String ContentType = response.header("Content-Type");// capture details of Content-Type header
		 logger.info("content-type is :" + ContentType);
		Assert.assertEquals("text/html; charset=UTF-8", ContentType);
	}

	@Test
	public void checkserverType() {
		logger.info("******Checking serverType********");
		String serverType = response.header("Server");
		logger.info("Server type is=>" + serverType);
		Assert.assertEquals("Apache", serverType);
	}

//	@Test
//	public void ckeckContentEncoding() {
//		logger.info("******Checking ContentEncoding********");
//		String contentEncoding = response.header("Content-Encoding");
//	   logger.info("Content Encoding is=>" + contentEncoding);
//		Assert.assertEquals("gzip", contentEncoding);
//	}

	@Test
	public void checkContentLength() {
		logger.info("******Checking ContentLength********");
		String contentLength = response.header("Content-Length");
		logger.info("content Lenght is==>" + contentLength);

		Assert.assertTrue(Integer.parseInt(contentLength) < 1500);

	}

	@AfterClass
	public void teardown() {
		logger.info("******End of TC05_Delete_EmployeeRecord********");
	}

	

}
