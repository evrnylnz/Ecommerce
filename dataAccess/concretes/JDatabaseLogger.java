package dataAccess.concretes;

import dataAccess.abstracts.DatabaseLogger;

public class JDatabaseLogger implements DatabaseLogger{

	@Override
	public void addToDatabase() {
		System.out.println("User added with JDatabaseLogger");
		
	}

}
