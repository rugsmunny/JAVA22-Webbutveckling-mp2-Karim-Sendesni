package model;

public class UserHandler {

public static boolean checkValidUser(String userIsCorrect, String passIsCorrect) {
		
		if(userIsCorrect.equals("Karim") && passIsCorrect.equals("123")) {
			return true;
		}else   {
			return false;
		
		}
		
}

public static boolean checkValidUser2(String userIsCorrect, String passIsCorrect) {
	
	if(userIsCorrect.equals("Omar") && passIsCorrect.equals("321")) {
		return true;
	}else   {
		return false;
	
	}
	
}
}
	

	
	
