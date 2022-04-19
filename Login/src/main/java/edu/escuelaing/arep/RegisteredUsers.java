package edu.escuelaing.arep;

import java.util.ArrayList;
import java.util.List;

public class RegisteredUsers {

	private List<User> users;
	
	public RegisteredUsers() {
		users = new ArrayList<User>();
	}
	
	public void AddNewUser(User user) {
		users.add(user);
	}
		
	public boolean IsRegistered(String uName, String uPasswd) {
		boolean isRegistered = false;
		for (User user: users) {
			if (user.getName().equals(uName) && user.getPassword().equals(uPasswd)) {
				isRegistered = true;
			}
		}
		return isRegistered;
	}
}
