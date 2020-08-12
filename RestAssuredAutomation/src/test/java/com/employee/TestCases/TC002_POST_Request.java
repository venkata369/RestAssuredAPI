package com.employee.TestCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;
import com.employeeapi.utilities.ImpRestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request extends TestBase{
	RequestSpecification httpRequest;
	Response response;
	
	String empName=ImpRestUtils.empName();
	String empSalery = ImpRestUtils.empSal();
	String empage = ImpRestUtils.empAge();
	
	@BeforeClass
	public void createEmployee() throws InterruptedException{
		logger.info("***************Started TC002_POST Employee_Record********************");
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		//RestAssured.baseURI="http://localhost:3000";
		
		httpRequest=RestAssured.given();
		JSONObject requestParams=new JSONObject();
		
		requestParams.put("name",empName);
		requestParams.put("salary",empSalery);
		requestParams.put("age",empage);
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		response = httpRequest.request(Method.POST,"/create");
		Thread.sleep(8000);	
		
		
		}
	 @Test
	 void checkResponseBody() {
		 String responseBody=response.getBody().asString();
		 Assert.assertEquals(responseBody.contains(empName),true);
		 Assert.assertEquals(responseBody.contains(empSalery),true);
		 Assert.assertEquals(responseBody.contains(empage),true);
		 //logger.info("Respose Body==>" +responseBody);
		 //Assert.assertTrue(responseBody!=null);
		 
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
		 logger.info("*********Finished TC002_POST_Employees******************");
	 }
	 
	
}
	//RestAssured.given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).when().
			//body(restutils.postempdetails()).
			//when().post("https://reqres.in/api/users").
			// then().statusCode(200).log().all();
			
	
	/* given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
	  body(requestParams.toJSONString()).
	  when().put("https://reqres.in/api/users/2").*/

/*RestAssured.given().when().headers(header.defaultHeaders()).body(restutils.postempdetails()).
when().post("/users").then().statusCode(200).log().all();*/
	
	
	
	
/*	RestUtils restutils = new RestUtils();
	RequestSpecification httpRequest;
	Response response;
	String empName= restutils.postempdetails();
	
		
	@BeforeClass
	 void createEmployee() throws InterruptedException
	 {
	  logger.info("***************Started TC002_CreateEmployee********************");
	  
	  RestAssured.baseURI="https://reqres.in/api";	  
	  httpRequest=RestAssured.given();
	  
	   JSONObject requestParams=new JSONObject();
	   requestParams.put("name","empName");
	   requestParams.put("job","empJob");
	   
	  //Add a Header stating Request Body is a Json
	   httpRequest.header("Content-Type","application/json");
	   
	   //Add Json body to the Request
	   httpRequest.body(requestParams.toJSONString());
	   
	   Thread.sleep(3000);
	 }	

 @Test
 void RegistrationSuccessful()
 {
  
  //Specify base URI
  RestAssured.baseURI="https://reqres.in/api";
  
  //Request object
  RequestSpecification httpRequest=RestAssured.given();
  
   
  //Request paylaod sending along with post request
  
  
 
  
  
  // attach above data to the request
  
  //Response object
  Response response=httpRequest.request(Method.POST,"/users");
    
  
  //print response in console window
  
  String responseBody=response.getBody().asString();
  System.out.println("Response Body is:" +responseBody);
  
  //status code validation
  int statusCode=response.getStatusCode();
  System.out.println("Status code is: "+statusCode);
  Assert.assertEquals(statusCode, 201);
  
  //success code validation
 // String successCode=response.jsonPath().get("SuccessCode");
 // Assert.assertEquals(successCode, "OPERATION_SUCCESS");
  
 }*/
 


