package ComplexValidation;

import Utility.PayloadClass;

import io.restassured.path.json.JsonPath;

public class ComplexJsonValidation {

	private static final int i = 0;

	public static void main(String[] args) {
// First parse that complex json using JsonPath class
		JsonPath jp=new JsonPath(PayloadClass.complxJson()); //payload class has static so direct call to classname
		
//  Print the website name 
		String WebsiteName =jp.getString("dashboard.website");
		System.out.println("WebSite Name :" + WebsiteName);
			
//  print the total amount purches 
		int purchaseAmount =jp.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount : " + purchaseAmount);
	
// 	Print the number of courses		-- by using size method 
		int numberOfCourses = jp.getInt("courses.size()");
		System.out.println("Number of courses : " + numberOfCourses );

// Print title of first course 
		String firstcourseTitle =jp.getString("courses[0].title");  // index alwayas sstart from zero
		System.out.println("First course title : " + firstcourseTitle);
	
// 	Print the title of all the courses 
		for(int i=0; i<jp.getInt("courses.size()");i++);
		System.out.println( i + 1 + " " +jp.getString("courses[" + i + "].title")); //courses[0].title
																					//" + i + " metlub concedination 
			
// consider courses are appearing at random index after every call, validate the price of Playwrit course 
		for (int i=0; i < numberOfCourses; i ++) {
			if(jp.getString("courses[" + i + "].title").equalsIgnoreCase("Playwrit")) {
				System.out.println("playwrit course price : " + jp.getInt("courses[" + i + "].price"));
			
			}
		}
		
	
	}

}
