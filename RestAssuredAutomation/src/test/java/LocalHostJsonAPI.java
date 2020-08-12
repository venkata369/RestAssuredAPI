import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class LocalHostJsonAPI {
	
	
	//@Test
	public void test_get() {
		baseURI = "http://localhost:3000";
		given().param("name", "Automation").
		get("/subjects").then().statusCode(200).
		log().all();
		
	}
	
	//@Test
	public void test_post() {
		JSONObject requestParams=new JSONObject();
		requestParams.put("firstName","Tom");
		requestParams.put("lastName","Mike");
		requestParams.put("subjectId",1);
		
		baseURI = "http://localhost:3000";
		 given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
		  body(requestParams.toJSONString()).
		  when().post("/users").		  
		  
		  then().statusCode(201).log().all();
	}
	
	//@Test
	public void test_patch() {
		JSONObject requestParams=new JSONObject();
		
		requestParams.put("lastName","Mike-Test for pathch");
		
		
		baseURI = "http://localhost:3000";
		 given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
		  body(requestParams.toJSONString()).
		  when().patch("/users/4").		  
		  
		  then().statusCode(200).log().all();
	}
	//@Test
	public void test_put() {
		JSONObject requestParams=new JSONObject();
		
		requestParams.put("firstName","Marry");
		requestParams.put("lastName","Jane");
		requestParams.put("subjectId",1);
		
		
		baseURI = "http://localhost:3000";
		 given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
		  body(requestParams.toJSONString()).
		  when().put("/users/4").		  
		  
		  then().statusCode(200).log().all();
	}
	@Test
	public void test_Delete() {
		baseURI = "http://localhost:3000";
		when().delete("/users/4").then().statusCode(200);
		
	}
	}


