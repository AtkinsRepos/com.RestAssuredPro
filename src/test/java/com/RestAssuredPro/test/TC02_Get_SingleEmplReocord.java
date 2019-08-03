package com.RestAssuredPro.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestAssuredPro.base.TeBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class TC02_Get_SingleEmplReocord extends TeBase {

	@BeforeClass
	public void Get_AllEmployeeData() throws Exception {
		logger.info("******Started TC02_Get_SingleEmplReocord ********");

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employee/" + empID);
		Thread.sleep(3000);
	}

	// Note: logging is optional,  they could be disabled and  re-enabled

	@Test
	public void checkResponseBody() {
		logger.info("******Checking Response body********");
		String responseBody = response.getBody().asString();
		 logger.info("Response Body is:" + responseBody);
		Assert.assertEquals(responseBody.contains(empID), true);
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

	@Test
	public void ckeckContentEncoding() {
		logger.info("******Checking ContentEncoding********");
		String contentEncoding = response.header("Content-Encoding");
	   logger.info("Content Encoding is=>" + contentEncoding);
		Assert.assertEquals("gzip", contentEncoding);
	}

	@Test
	public void checkContentLength() {
		logger.info("******Checking ContentLength********");
		String contentLength = response.header("Content-Length");
		logger.info("content Lenght is==>" + contentLength);

		Assert.assertTrue(Integer.parseInt(contentLength) < 1500);

	}

	@AfterClass
	public void teardown() {
		logger.info("******End of TC01********");
	}

}