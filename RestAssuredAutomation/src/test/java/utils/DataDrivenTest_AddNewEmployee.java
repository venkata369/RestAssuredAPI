package utils;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class DataDrivenTest_AddNewEmployee{


	@Test(dataProvider="empdataprovider")
	void postNewEmployees(String ename,String eage,String esal) {

		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		//RestAssured.baseURI= "http://localhost:3000/";
		RequestSpecification httpRequest=RestAssured.given();
		JSONObject requestParams=new JSONObject();
		requestParams.put("name",ename);
		requestParams.put("salary",eage);
		requestParams.put("age",esal);

		httpRequest.header("Content-Type","application/json");

		httpRequest.body(requestParams.toJSONString());

		//send above created data request for POST Request
		Response response = httpRequest.request(Method.POST,"/create");
		//Response response = httpRequest.request(Method.POST,"/users");
		//Capture response body to perform validation
		String responseBody=response.getBody().asString();

		System.out.println("Response body is:" +responseBody);

		Assert.assertEquals(responseBody.contains(ename),true);
		Assert.assertEquals(responseBody.contains(eage),true);
		Assert.assertEquals(responseBody.contains(esal),true);

		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode,200);


	}


	@DataProvider(name="empdataprovider")
	String[][] getData() throws IOException{
		XLUtils XLUtils = new XLUtils();
		String path= System.getProperty("user.dir")+"/excel/api.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);

		//Store two dimensional Array

		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				System.out.println("Data is:"+XLUtils.getCellData(path, "Sheet1", i, j));
			}

		}
		return logindata;		
	}


}

