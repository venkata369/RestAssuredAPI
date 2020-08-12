import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class T006_ResponseBody {

	@Test
	void getweatherDetails()
	{
		//Specify base URI
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";

		//Request object
		RequestSpecification httpRequest=RestAssured.given();

		//Response object
		Response response=httpRequest.request(Method.GET,"/employees");
		
		//Printing individual values using json path
		/*JsonPath jsonpath = response.jsonPath();
		System.out.println(jsonpath.get("id"));
		System.out.println(jsonpath.get("employee_name"));
		System.out.println(jsonpath.get("employee_salary"));
		System.out.println(jsonpath.get("employee_age"));*/

		//print response in console window

		String responseBody=response.getBody().asString();
		
		System.out.println("Response Body is:" +responseBody);
		
		

		//status code validation
		/*int statusCode=response.getStatusCode();
		System.out.println("Status code is: "+statusCode);
		Assert.assertEquals(statusCode, 200);

		//status line verification
		String statusLine=response.getStatusLine();
		System.out.println("Status line is:"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		System.out.println(response.getHeader("content-type"));
		given().log().all();

		System.out.println("===========================================");
		Headers allheaders = response.headers();
		for(Header header:allheaders) {
			System.out.println(header.getName()+"    "+header.getValue());	
			Assert.assertEquals(responseBody.contains("1"), true);

		}*/


	}

}
