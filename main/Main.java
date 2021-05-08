package main;

import business.concretes.UserManager;
import entities.concretes.User;
import dataAccess.concretes.GmailLogger;
import dataAccess.concretes.JDatabaseLogger;

public class Main {

	public static void main(String[] args) {
		UserManager userService = new UserManager();
		User user = new User("Evren", "Yalnýz", "evren@gmail.com", "123456", 1);
		userService.addUser(user, new JDatabaseLogger());
		
		User user2 = new User("Çaðla","Kýsýk","cagla@gmail.com","1234567",2);
		userService.addUser(user2, new GmailLogger());
		
		userService.login("cagla@gmail.com", "1234567");
		System.out.println("*****************");
		userService.seeAllUsers();

	}

}
