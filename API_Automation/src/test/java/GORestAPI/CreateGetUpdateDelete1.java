package GORestAPI;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import GORestAPIPojoClasses.CreateUser;
import GORestAPIPojoClasses.CreateUserResponse;
import GORestAPIPojoClasses.GetUserResponse;
import GORestAPIPojoClasses.UpdateResponse;
import GORestAPIPojoClasses.UpdateUser;

public class CreateGetUpdateDelete1 {

	public static void main(String[] args) {

		RequestSpecification requestspec = (RequestSpecification) new RequestSpecBuilder()
				.setBaseUri("https://gorest.co.in")
				.addHeader("Authorization", "Bearer 0431b2f96b1525e9b03c6dff1a4b2474b662d2dba722b3328112654c5d6fbdda")
				.build();

		// ************ CREATE API USER ************ ye humne post ke liye kiya hai
// Create the object of pojo class for create user 
		CreateUser createUser = new CreateUser();
		createUser.setName("Sponserr");
		createUser.setEmail("Sponserr2@gmail.com");
		createUser.setGender("male");
		createUser.setStatus("Active");

		CreateUserResponse createUserResponse = given().log().all().header("Content-Type", "application/json")
				.spec(requestspec).body(createUser).when().post("public/v2/users").then().log().all().extract()
				.as(CreateUserResponse.class);

// one create object in integer class
		Integer createUserId = createUserResponse.getId();
		System.out.println(createUserId);

// ************ CREATE API USER ************ ye humne get read ke liye kiya hai
		// public/v2/users ye source hai and userID path hai
//		https://gorest.co.in/public/v2/users/userId  (userid mtlun humne jo create ki post method se vho peste krni hai )

		GetUserResponse getUserResponse = given().log().all().pathParam("userId", createUserId) // ya per hume userId
																								// direct varible
																								// provide kr rhe hai
				.spec(requestspec).when().get("public/v2/users/{userId}").then().log().all().extract()
				.as(GetUserResponse.class);

		// userId pathparamter me jo humne declare kiya hai vho ya pr /{userId} add kr
		// denge
		// extract().as(GetUserResponse.class) mtlub humne pojo class ka usee kiya hai
		// validation ke liye understood .

// Hard Assert ke though hum ise run kr rhe hai 
		// Hard Assert method ko isme static way me defined kiya hai
		// tabhi hum isme classname se call kr rh hai Assert.assertEquals
		Assert.assertEquals(getUserResponse.getName(), "Sponserr");
		Assert.assertEquals(getUserResponse.getEmail(), "Sponserr2@gmail.com");

// To use testNG Soft Assert, ke thorugh hum ise run kr rhe hai 
		// first we create object of soft assert class--predefined class

		SoftAssert softAssert = new SoftAssert(); // softAssert method ko isme non static way me defined kiya hai
		softAssert.assertEquals(getUserResponse.getName(), "Sponserr");
		softAssert.assertEquals(getUserResponse.getEmail(), "Sponserr2@gmail.com", "Email verification failed");

		softAssert.assertAll(); // ager dono softassert method cheack krne hai to asserall ko call krna
								// important hai

// ************ CREATE API USER ************ ye humne put ke liye kiya hai
// https://gorest.co.in/public/v2/users/userId

		UpdateUser updateUser = new UpdateUser();
		updateUser.setName("Sponserr_Bhaiya");
		updateUser.setEmail("Sponserr_Bhaiya@gmail.com");
		updateUser.setGender("male");
		updateUser.setStatus("active");

		UpdateResponse updateResponse = given().log().all().pathParam("userId", createUserId)
				.header("Content-Type", "application/json").spec(requestspec).body(updateUser).when()
				.put("public/v2/users/{userId}").then().log().all().extract().as(UpdateResponse.class);

		Assert.assertEquals(updateResponse.getName(), "Sponserr_Bhaiya");
		Assert.assertEquals(updateResponse.getEmail(), "Sponserr_Bhaiya@gmail.com");
		Assert.assertEquals(updateResponse.getId(), createUserId);

// ************ CREATE API USER ************ ye humne Delete ke liye kiya hai
// https://gorest.co.in/public/v2/users/userId

		given().log().all().pathParam("userId", createUserId).spec(requestspec).when()
				.delete("public/v2/users/{userId}").then().log().all().extract();

	}

}
