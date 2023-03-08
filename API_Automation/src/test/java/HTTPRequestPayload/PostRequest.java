package HTTPRequestPayload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

import Utility.PayloadClass;

public class PostRequest {

	public static void main(String[] args) {
		// https://reqres.in/api/users

		// Specify the base URI to RestAssured Class
		RestAssured.baseURI = "https://reqres.in/api/users";

		String userName = "Sagar";
		String userJob = "Engineer";
		JsonPath jp = given().log().all().header("Content-Type", "application/json")
				.body(PayloadClass.PostRequestPayload(userName,userJob)).when().post("api/users").then().log().all()
				.assertThat().statusCode(201).extract().response().jsonPath();

		// jsonpath use krenge aur validation krenge hume
		Assert.assertEquals(jp.getString("name"), userName);
		Assert.assertTrue(userJob.equals(jp.getString("job")));
	}

}
//BDD Approach
//1. Given - precodition /pre-requsites (reuest parameter, request header,request body,authorization)
// 	 When - user action (specify HTTP method,POST/GET/PUT/DELETE)
// 	 then - Validation (status code,resposne body, response header)

//log - log().all()  -- > (request or response ) 

// Note --String username= "Sagar"; String userjob="Engineer"
// jo payload me name hai vha doublequotes use krenge and then name write krenge 