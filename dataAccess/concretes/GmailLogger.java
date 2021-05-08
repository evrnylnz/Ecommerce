package dataAccess.concretes;

import dataAccess.abstracts.DatabaseLogger;

public class GmailLogger implements DatabaseLogger{

	@Override
	public void addToDatabase() {
		System.out.println("User added with Gmail logger");
		
	}

}
