package com.employee.TestCases;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_1_GET_SingleEmp_Request extends TestBase{
	@BeforeClass
	 void getAllEmployees() throws InterruptedException
	 {
	  logger.info("***************Started TC001_1_Get_Single_Employe********************");
	  RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	  
	   httpRequest=RestAssured.given();
	   response=httpRequest.request(Method.GET,"/employee/"+empID);
	   
	   Thread.sleep(6000);
	 }
	 @Test
	 void checkResponseBody() {
		 String responseBody=response.getBody().asString();
		 logger.info("Respose Body==>" +responseBody);
		 Assert.assertEquals(responseBody.contains(empID),true);
		 
	 }
	 @Test
	 void checkStatusCode() {
		 logger.info("********Checking Status Code*************");
		 
		 int statusCode=response.getStatusCode();
		 logger.info("Status Code is==>" +statusCode);
		 Assert.assertEquals(statusCode, 200);
		 	 
	 }
	 @Test
	 void checkResponseTime() {
		 logger.info("********Checking Response Time***********");
		 long responsetime = response.getTime();
		 logger.info("Response Time is ==>" +responsetime);
		 
		 if(responsetime>6000) 
			 logger.warn("Response Time is greater than 2000");
		 Assert.assertTrue(responsetime<6000);		 
		 
	 }
	 @Test
	 void checkStatusLine() {
		 logger.info("*********Checking Status Line************");
		 String statusline = response.getStatusLine();
		 logger.info("Status Line is==>" +statusline);
		 Assert.assertEquals(statusline, "HTTP/1.1 200 OK");	 
		 
	 }
	 
	 @Test
	 void contentType() {
		 logger.info("*********Checking Content Type************");
		 String contentType = response.header("Content-Type");
		 logger.info("Content Type is==>" +contentType);
		 //Assert.assertEquals(contentType, "text/html; charset=UTF-8");
		 //Assert.assertEquals(contentType, "application/json;charset=utf-8");
		 
	 }
	 @Test
	 void serverType() {
		 logger.info("*********Checking Server******************");
		 String serverType = response.header("Server");
		 logger.info("Server Type is==>" +serverType);
		 //Assert.assertEquals(serverType,"nginx/1.14.1");
		// Assert.assertEquals(serverType,"nginx/1.16.1");
		 
	 }
	 
	 @Test
	 void checkContentEncoding() {
		 logger.info("*********Check Content Encoding******************");
		 String ContentEncoding = response.header("contentEncoding");
		 logger.info("Content Encoding is" +ContentEncoding);
		 //Assert.assertEquals(ContentEncoding, "gzip");
		 //Assert.assertEquals(ContentEncoding, "null");
		 
	 }
	 
	 @Test
	 void checkContentLength() {
		 logger.info("*********Checking Content Length******************");
		 String ContentLength = response.header("Content-Length");
		 logger.info("Content Length is" +ContentLength);
		 if(Integer.parseInt(ContentLength)<100)
			 logger.warn("Content Length is lessthan 100");
		 Assert.assertTrue(Integer.parseInt(ContentLength)>100);	 
		 
	 }
	 
	 @Test
	 void checkCookies() {
		 logger.info("*********Checking Cookies******************");
		 String cookie = response.cookie("PHPSESSID");
		 
	 }
	 @AfterClass
	 void tearDown() {
		 logger.info("*********Finished TC001_1_Single_Employe******************");
	 }
	 

}
