package com.RestAssuredPro.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TeBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID="23153"; //Hard coded - Input for //Get details of Single Employee & update employee
	
	
	public static Logger logger;
	
	@BeforeClass
	public void setup(){
		
		logger=Logger.getLogger("RestAssuredPro");//added Logger
		PropertyConfigurator.configure("Log4j.properties"); //added logger
		//logger.setLevel(Level.DEBUG);
		
	}
	


}
