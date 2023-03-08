package Utility;

public class PayloadClass {

	public static String complxJson() {
		return "{\r\n" + "\r\n" + "	\"dashboard\": {\r\n" + "	\"purchaseAmount\": 115,\r\n"
				+ "	\"website\": \"demotesting.com\"\r\n" + "	},\r\n" + "\r\n" + "	\"courses\": [\r\n"
				+ "		{\r\n" + "			\"title\": \"Selenium Java\",\r\n" + "			\"price\": 45,\r\n"
				+ "			\"copies\": 7\r\n" + "		},\r\n" + "\r\n" + "		{\r\n"
				+ "			\"title\": \"Playwrit\",\r\n" + "			\"price\": 30,\r\n"
				+ "			\"copies\": 5\r\n" + "		},\r\n" + "\r\n" + "		{\r\n"
				+ "			\"title\": \"RestAssured\",\r\n" + "			\"price\": 65,\r\n"
				+ "			\"copies\": 10\r\n" + "		},\r\n" + "		{\r\n" + "			\"title\": \"Cypress\",\r\n"
				+ "			\"price\": 35,\r\n" + "			\"copies\": 8\r\n" + "		}\r\n" + "	]\r\n" + "}";
	}
	public static String putRequestPayload() {
	 return "{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"zion resident\"\r\n" + "}";
	}
	

	public static String PostRequestPayload( String userName, String userJob ) {
		return "{\r\n" + "    \"name\": \" " + userName + "\",\r\n" + "    \"job\": \"leader\"\r\n" + "}";
	}
}