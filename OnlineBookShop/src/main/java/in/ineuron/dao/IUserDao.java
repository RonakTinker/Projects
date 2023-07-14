package in.ineuron.dao;


import java.util.List;

import in.ineuron.dto.Admin;
import in.ineuron.dto.User;

public interface IUserDao {

	//methods related yo user.
	public String userRegister(User user);
	public User login(String email,String password);
	
	//methods related to admin.
	public String addBook(Admin admin);
	public Admin selectBook(int id);
	public String deleteBook(int id);
	public String UpdateBook(Admin admin);
	public List<Admin> searchAllBooks();
	public List<Admin> getNewBooks();
	public List<Admin> getOldBooks();
	public List<Admin> getRecentBooks();
	public String addToCart(Admin admin);
	public List<Admin> viewCart(int id);
	public String deleteBookFromCart(int userId,int bookId,int cartId);
	public String sellBook(Admin admin);
//	public List<Admin> getMyBooks(int userId);
//	public String deleteMyBook(int userId,int bookId);
	public String editProfile(User user);
	public String order(User user,List<Admin> arrayList, String paymentType);
	public List<Admin> viewOrders(int userId);
	public User getUser(int id);
	public boolean checkEmail(String email);
}
