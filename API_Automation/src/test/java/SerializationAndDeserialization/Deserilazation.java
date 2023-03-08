package SerializationAndDeserialization;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.Iterator;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import PojoClasses.ListOfUsers;
import PojoClasses.UserData;

public class Deserilazation {

	public static void main(String[] args) {
		// https://reqres.in/api/users?page=2

		RestAssured.baseURI = "https://reqres.in";

		ListOfUsers listOfUsers = given().log().all().queryParam("page", "2").pathParam("path", "users").when()
				.get("api/{path}").then().log().all().extract().as(ListOfUsers.class);

		System.out.println("Page : " + listOfUsers.getPage());
		System.out.println("Per_page : " + listOfUsers.getPer_page());
		System.out.println("Total : " + listOfUsers.getTotal());
		System.out.println("Total_Page : " + listOfUsers.getTotal_pages());

		System.out.println("Support url :" + listOfUsers.getSupport().getUrl());
		System.out.println("Support url :" + listOfUsers.getSupport().getText());

		List<UserData> userData = listOfUsers.getData();
		// print the data from single loop
		System.out.println(userData.get(0).getId());
		System.out.println(userData.get(0).getFirst_name());
		System.out.println(userData.get(0).getLast_name());
		System.out.println(userData.get(0).getEmail());
		System.out.println(userData.get(0).getAvatar());

		// It will use to the print the all the data
		for (int i = 0; i < userData.size(); i++) {
			System.out.println(userData.get(i).getId());
			System.out.println(userData.get(i).getFirst_name());
			System.out.println(userData.get(i).getLast_name());
			System.out.println(userData.get(i).getEmail());
			System.out.println(userData.get(i).getAvatar());
		}
// iteratore thorugh 
		Iterator<UserData> itr = userData.iterator();

		while (itr.hasNext());
		UserData user = itr.next();
		
		System.out.println(user.getId());
		System.err.println(user.getFirst_name());
		System.out.println(user.getLast_name());
		System.out.println(user.getEmail());
		System.out.println(user.getAvatar());
	
	
	}

}
