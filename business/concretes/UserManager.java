package business.concretes;

import java.util.ArrayList;

import business.abstracts.UserService;
import dataAccess.abstracts.DatabaseLogger;
import entities.concretes.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements UserService{
	
	private ArrayList<User> userList = new ArrayList<User>();

	@Override
	public void addUser(User user,DatabaseLogger databaseLogger) {
		if(user.getPassword().length() < 6) {
			System.out.println("Password is too short.User could not added to system.");
			return;
		}
		Pattern format = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
		//example@example.com
		Matcher m = format.matcher(user.getEmail());
		if(!m.find()) {
			System.out.println("Format is not valid.User could not added to system.");
			return;
		}
		
		if(user.getFirstName().length() < 2 || user.getLastName().length() < 2) {
			System.out.println("First name or last name is too short.User could not added to system.");
			return;
		}
		
		if(!this.userList.isEmpty()) {
			for(User u : userList) {
				if(u.getEmail() == user.getEmail()) {
					System.out.println("Email error");
					return;
				}
			}
		}
		System.out.println("Verification email sent to your address.");
		databaseLogger.addToDatabase();
		this.userList.add(user);
		
	}

	@Override
	public void seeAllUsers() {
		int i = 1;
		if(userList.isEmpty()) {
			System.out.println("No user exist.");
			return;
		}
		for(User u : userList) {
			System.out.println("User " + i + " : "+ u.getFirstName());
			i++;
		}
		
	}
	public void login(String email,String password) {
		for(User u : userList) {
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
				System.out.println("Login succesfull");
			}
			
		}
	}

}
