package HTTPRequestPayload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetListOfUser {

	public static void main(String[] args) {
		// https://reqres.in/api/users?page=2

		RestAssured.baseURI = "https://reqres.in";

	/*	Response response = given().log().all().queryParam("page", "2").pathParam("path", "users").when()
				.get("api/{path}").then().log().all().assertThat().statusCode(200).extract().response();

		System.out.println(response.asPrettyString()); // all jo postman me response body milti hai same vaise milegi
*/
		// System.out.println(response.asString()); // one line me show hogi body

		String response = given().log().all().queryParam("page", "2").pathParam("path", "users").when()
				.get("api/{path}").then().log().all().assertThat().statusCode(200).extract().response()
				.asPrettyString();
			//asPrettyString(); humne age is use kiya to humara return type string hoga..
		
		System.out.println("**********");
		System.out.println(response); // all jo postman me response body milti hai same vaise milegi


		 JsonPath jp =given().log().all().queryParam("page", "2").pathParam("path", "users").when()
			.get("api/{path}").then().log().all().assertThat().statusCode(200).extract().response().jsonPath();
		 
		 System.out.println("**********");
		 System.out.println(jp.getString("data[0].first_name"));
	}

}


// ager hume validation krna hai to -- we have to create json path object is we use 
// ager simple response body chiye to -- go for string response  
// ager header status code validation krne hai to response code ka object use krenge 

//Note-- Delete method me payload ki jrurat nhi hoti 
//		get mthod me jrurat nhi hoti 
// hume sirf PUT and POST method me payload use krte hai 
// isme payload me body as it copy paste krnege and use krenge 


