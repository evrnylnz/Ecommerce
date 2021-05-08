package business.abstracts;

import dataAccess.abstracts.DatabaseLogger;
import entities.concretes.User;

public interface UserService {
	void addUser(User user,DatabaseLogger databaseLogger);
	void seeAllUsers();
	
   
}
