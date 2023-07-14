package in.ineuron.serviceFactory;

import in.ineuron.service.IUserService;
import in.ineuron.service.UserServiceImpl;

public class UserServiceFactory {
	private static IUserService userService;
	
	//made the Constructor private so that no one can create object of it.
	private UserServiceFactory() {
		
	}
	
	//method to get the UserServiceImpl object.
	public static IUserService getUserService() {
		
		if(userService==null) {
			userService=new UserServiceImpl();
		}
		return userService;
	}
}
