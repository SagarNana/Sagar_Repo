package BasicValidation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

public class PutRequest {
//How to validate the response body or data present in the response body  
	
	public static void main(String[] args) {
		//https://reqres.in/api/users/2

	RestAssured.baseURI="https://reqres.in";
	
	Response response =given().log().all().header("Content-Type","application/json").body("{\r\n" + 
			"    \"name\": \"morpheus\",\r\n" + 
			"    \"job\": \"zion resident\"\r\n" + 
			"}").when().put("api/users/2").then().assertThat().log().all().statusCode(200).extract().response();
	
	//How to print the response body --Ye usko string ki trh print krega 
	System.out.println(response.toString());
	System.out.println(response.asString()); // one line me print krega 
	System.out.println(response.asPrettyString()); // mtlub pura postman format me print hoga
	
	// to validate the response body, we are pass the json response using JasonPath class 
	
	JsonPath JP=new JsonPath(response.toString());
	
	//console ka name and id cheack krene ke liye print out kiya hai
	String UserName=JP.getString("name");
	System.out.println(UserName);
	Assert.assertEquals(UserName, "morpheus");
	
	String userJob= JP.getString("job");
	System.out.println("User job is " + userJob);
	Assert.assertEquals(userJob, "zion resident ");
	}

}
