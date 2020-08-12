package com.employee.TestCases;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;
import com.employeeapi.utilities.ImpRestUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class TC003_PUT_Requesut extends TestBase{
	
	RequestSpecification httpRequest;
	Response response;
	
	String empName=ImpRestUtils.empName();
	String empSalery = ImpRestUtils.empSal();
	String empage = ImpRestUtils.empAge();
	
	@BeforeClass
	public void createEmployee() throws InterruptedException{
		logger.info("***************Started TC003_PUT Employee_Record********************");
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		//RestAssured.baseURI="http://localhost:3000";
		
		httpRequest=RestAssured.given();
		JSONObject requestParams=new JSONObject();
		
		requestParams.put("name",empName);
		requestParams.put("salary",empSalery);
		requestParams.put("age",empage);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		response = httpRequest.request(Method.PUT,"/update/" +empID);
		Thread.sleep(3000);			
		
		}
	@Test
	 void checkResponseBody() {
		 String responseBody=response.getBody().asString();
		 Assert.assertEquals(responseBody.contains(empName),true);
		 Assert.assertEquals(responseBody.contains(empSalery),true);
		 Assert.assertEquals(responseBody.contains(empage),true);
	}
	@Test
	 void checkStatusCode() {
		 logger.info("********Checking Status Code*************");
		 
		 int statusCode=response.getStatusCode();
		 logger.info("Status Code is==>" +statusCode);
		 Assert.assertEquals(statusCode, 200);
		 	 
	 }
	@AfterClass
	 void tearDown() {
		 logger.info("*********Finished TC003_Update_Employess******************");
	 }

}
