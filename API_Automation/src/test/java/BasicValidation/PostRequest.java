package BasicValidation;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

public class PostRequest {
// Validation that we will consider here will be as below :
	// 1. Status code 
	// 2. Response time
	// 3. Response header 
	
	
	public static void main(String[] args) {
		// https://reqres.in/api/users
		
		// Specify the base URI to RestAssured class 
		RestAssured.baseURI=" https://reqres.in";
		
//extract the response 
		
		//You have to create response class 
		Response response =given().log().all().header("Content-Type", "application/json")
		.body("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}")
		.when().post("/api/users").then().log().all().assertThat().statusCode(201).extract().response();
	
		//response() returns --> The entire response object including headers, cookies and body etc.

		int responsecode =response.getStatusCode();  //provide response code 
		System.out.println("Response code : " + responsecode );
		Assert.assertEquals(responsecode, 201);
		
		long responseTime=response.getTime();
		
		System.out.println("Response Time :" + responseTime);
		Assert.assertTrue(responseTime < 1000);
		//The respone time in milliseconds 
		
		String serverheader=response.getHeader("server");
		System.out.println("Server header : " + serverheader);
		Assert.assertEquals(response.getHeader("server"),"CloudFlare");
	
	}

}

