package in.ineuron.daoFactory;

import in.ineuron.dao.IUserDao;
import in.ineuron.dao.UserDaoImpl;

public class UserDaoFactory {
	private static IUserDao userDao;
	
	//made the Constructor private so that no one can create object of it.
	private UserDaoFactory() {
		
	}
	
	//method to get the UserDaoImpl object.
	public static IUserDao getUserDao() {
		if(userDao==null) {
			userDao=new UserDaoImpl();
		}
		return userDao;
	}
}
