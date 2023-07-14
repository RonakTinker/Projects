package in.ineuron.service;


import java.util.List;

import in.ineuron.dao.IUserDao;
import in.ineuron.daoFactory.UserDaoFactory;
import in.ineuron.dto.Admin;
import in.ineuron.dto.User;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao;
	
	//method to transfer data from service to dao layer using DTO.
	public String userRegister(User user) {
		userDao=UserDaoFactory.getUserDao();
		return userDao.userRegister(user);
	}
	
	//method to login a user.
	public User login(String email,String password) {
		userDao=UserDaoFactory.getUserDao();
		return userDao.login(email,password);
	}
	
	//method to add a book for admin
	public String addBook(Admin admin) {
		userDao=UserDaoFactory.getUserDao();
		return userDao.addBook(admin);
	}
	
	//method to select a book for admin
	public Admin selectBook(int id) {
		userDao=UserDaoFactory.getUserDao();
		return userDao.selectBook(id);
	}
	
	//method to delete a book for admin
	public String deleteBook(int id) {
		userDao=UserDaoFactory.getUserDao();
		return userDao.deleteBook(id);
	}
	
	
	//method to update a book for admin
	public String UpdateBook(Admin admin) {
		userDao=UserDaoFactory.getUserDao();
		return userDao.UpdateBook(admin);
	}
	
	//method to search all the books
	public List<Admin> searchAllBooks() {
		userDao=UserDaoFactory.getUserDao();
		return userDao.searchAllBooks();
	}
	
	//method to get the new books.
	public List<Admin> getNewBooks(){
		userDao=UserDaoFactory.getUserDao();
		return userDao.getNewBooks();
	}
	
	//method to get old books.
	public List<Admin> getOldBooks(){
		userDao=UserDaoFactory.getUserDao();
		return userDao.getOldBooks();
	}
	
	//method to get recent books
	public List<Admin> getRecentBooks(){
		userDao=UserDaoFactory.getUserDao();
		return userDao.getRecentBooks();
	}
	
	//method to add the book to cart
	public String addToCart(Admin admin) {
		userDao=UserDaoFactory.getUserDao();
		return userDao.addToCart(admin);
	}
	
	//method to send data to the cart page.
	public List<Admin> viewCart(int id){
		userDao=UserDaoFactory.getUserDao();
		return userDao.viewCart(id);
	}
	
	//method to delete book from cart
	public String deleteBookFromCart(int userId,int bookId,int cartId) {
		userDao=UserDaoFactory.getUserDao();
		return userDao.deleteBookFromCart(userId, bookId, cartId);
	}
	
	//method to sell a book by user.
	public String sellBook(Admin admin) {
		userDao=UserDaoFactory.getUserDao();
		return userDao.sellBook(admin);
	}
	
//	//method to get the books data which are for selling and published by user.
//	public List<Admin> getMyBooks(int userId){
//		userDao=UserDaoFactory.getUserDao();
//		return userDao.getMyBooks(userId);
//	}
//	
//	//method to delete my book from books data
//	public String deleteMyBook(int userId,int bookId) {
//		userDao=UserDaoFactory.getUserDao();
//		return userDao.deleteMyBook(userId, bookId);
//	}
	
	//method to update the user's profile
	public String editProfile(User user) {
		userDao=UserDaoFactory.getUserDao();
		return userDao.editProfile(user);
	}
	
	//method to order the books
	public String order(User user,List<Admin> arrayList, String paymentType) {
		userDao=UserDaoFactory.getUserDao();
		return userDao.order(user, arrayList, paymentType);
	}
	
	
	//method to get the order data.
	public List<Admin> viewOrders(int userId){
		userDao=UserDaoFactory.getUserDao();
		return userDao.viewOrders(userId);
	}
	
	//method to get a user by its id.
	public User getUser(int id) {
		userDao=UserDaoFactory.getUserDao();
		return userDao.getUser(id);
	}
	
	//method to check email existence in database while registering.
	public boolean checkEmail(String email) {
		userDao=UserDaoFactory.getUserDao();
		return userDao.checkEmail(email);
	}
}
