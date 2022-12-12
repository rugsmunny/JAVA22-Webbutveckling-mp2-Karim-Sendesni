package model;

public class UserBean {

	private String userName;
	private String passWord;

	public String getUserName() {
		return userName;
	}

	public UserBean(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;	}

	public boolean checkValidUser() {
		return UserHandler.checkValidUser(this.userName, this.passWord);
		
	}
	
	public boolean checkValidUser2() {
		return UserHandler.checkValidUser2(this.userName, this.passWord);
		
	}

}
