package com.employee.TestCases;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class TC005_DELETE_Request extends TestBase {
	
	RequestSpecification httpRequest;
	Response response;
	
	@BeforeClass
	public void deleteEmployee() throws InterruptedException {
	
		logger.info("***************Started TC003_PUT Employee_Record********************");
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		//RestAssured.baseURI="http://localhost:3000";
		
		httpRequest=RestAssured.given();	
		
		response = httpRequest.request(Method.GET, "/employees");
		
		JsonPath jsonpathElevator= response.jsonPath();
		
		//Capture id
		String empID = jsonpathElevator.get("[0].id");
		response = httpRequest.request(Method.DELETE,"/delete/" +empID);
		
		
		Thread.sleep(3000);		 
		
		
	}
	
	@Test
	 void checkResponseBody() {
		 String responseBody=response.getBody().asString();
		 Assert.assertEquals(responseBody.contains("Successfully! deleted Records"),false);
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
		 logger.info("*********Finished TC005_Deleted_Employe Record******************");
	 }
}

