package HTTPRequestPayload;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import Utility.PayloadClass;

public class PutRequest {

	public static void main(String[] args) {
		// https://reqres.in/api/users/2

		RestAssured.baseURI = "https://reqres.in";

/*		given().log().all().header("Content-Type", "application/json")
				.body("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"zion resident\"\r\n" + "}").when()
				.put("api/users/2").then().assertThat().log().all().statusCode(200);*/

		given().log().all().header("Content-Type", "application/json")
		.body(PayloadClass.putRequestPayload()).when()
		.put("api/users/2").then().assertThat().log().all().statusCode(200);
	}
// isme hume payload class me path likar class name se call kiya hai direct aur string valiue privde hogi 
}
