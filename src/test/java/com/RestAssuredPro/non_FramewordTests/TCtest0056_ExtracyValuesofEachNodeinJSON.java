package com.RestAssuredPro.non_FramewordTests;

import org.testng.annotations.Test;

import com.RestAssuredPro.base.TeBase;

import freemarker.template.utility.ToCanonical;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TCtest0056_ExtracyValuesofEachNodeinJSON {
	
	@Test
	public void extracyValuesofEachNodeinJSON () {
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
				JsonPath jsonpath=response.jsonPath();	
				System.out.println("City=:"+jsonpath.get("City"));
				System.out.println("Temperature=:"+jsonpath.get("Temperature"));
				System.out.println("Humidity=:"+jsonpath.get("Humidity"));
				System.out.println("WeatherDescription=:"+jsonpath.get("WeatherDescription"));
				System.out.println("WindSpeed=:"+jsonpath.get("WindSpeed"));
				System.out.println("WindDirectionDegree=:"+jsonpath.get("WindDirectionDegree"));
				
				//To verify results, though may not be consistent
				Assert.assertEquals("Delhi", jsonpath.get("City"));
//				Assert.assertEquals("88 Percent", jsonpath.get("Humidity")); //works but disabled
//				Assert.assertEquals("3.32 Km per hour", jsonpath.get("WindSpeed"));
}
}
