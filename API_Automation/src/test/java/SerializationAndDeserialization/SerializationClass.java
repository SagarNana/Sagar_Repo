package SerializationAndDeserialization;

import static io.restassured.RestAssured.given;

import PojoClasses.Bookingdates;
import PojoClasses.CreateBooking;
import io.restassured.RestAssured;

public class SerializationClass {

	public static void main(String[] args) {
		// https://restful-booker.herokuapp.com/booking

		RestAssured.baseURI = "https://restful-booker.herokuapp.com";

// for Serialization first create the object of required pojo class 
		CreateBooking createBooking = new CreateBooking(); // import ke lie ctrl+shift+o

// use the setter method intilize variable declare inside the pojo class 
		createBooking.setFirstname("Jim");
		createBooking.setLastname("Brown");
		createBooking.setAdditionalneeds("Breakfast");
		createBooking.setTotalprice(111);
		createBooking.setDepositpaid(true);

// how to call of checkin and cheakout method --> so we create object of bookingdates 

		Bookingdates bookingDates = new Bookingdates();
		bookingDates.setCheckin("2018-01-01");
		bookingDates.setCheckout("2019-01-01");

		createBooking.setBookingdates(bookingDates);

//now pass the pojo class object inside the body method  
		

		given().log().all().header("Content-Type", "application/json").body(createBooking).when().post("booking").then().log()		
		.all().statusCode(200);

	}

}
