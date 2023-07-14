package in.ineuron.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.ineuron.dto.Admin;
import in.ineuron.dto.User;
import in.ineuron.util.JdbcUtil;

public class UserDaoImpl implements IUserDao {

	Connection connection;
	PreparedStatement pstmt;
	ResultSet resultSet;

	// method to register the user
	public String userRegister(User user) {

		// insert query for inserting the registration data to the database.
		String sqlInsertQuery = "insert into user_data(name,email,phoneNO,password)values(?,?,?,?)";

		try {
			// getting the connection to database.
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}

			if (pstmt != null) {
				// setting the data of DTO to the pstmt object.
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getEmail());
				pstmt.setString(3, user.getPhoneNo());
				pstmt.setString(4, user.getPassword());

				// executing the query
				int rowAffected = pstmt.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	// method to login a user.
	public User login(String email, String password) {

		String sqlSelectQuery = "select id,name,email,phoneNO,password,address,city,state,pin from user_data where email=? and password=?";

		try {

			// getting the connection to database.
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
			}

			if (pstmt != null) {
				pstmt.setString(1, email);
				pstmt.setString(2, password);

				resultSet = pstmt.executeQuery();
			}

			if (resultSet != null) {

				if (resultSet.next()) {
					User user = new User();

					user.setId(resultSet.getInt(1));
					user.setName(resultSet.getString(2));
					user.setEmail(resultSet.getString(3));
					user.setPhoneNo(resultSet.getString(4));
					user.setPassword(resultSet.getString(5));
					user.setAddress(resultSet.getString(6));
					user.setCity(resultSet.getString(7));
					user.setState(resultSet.getString(8));
					user.setPin(resultSet.getString(9));

					return user;
				}
			}

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	// method to add a book by admin.
	public String addBook(Admin admin) {

		// insert query for inserting the book data to the database.
		String sqlInsertQuery = "insert into books_data(book_name,book_author,book_price,book_category,book_image)values(?,?,?,?,?)";

		try {
			// getting the connection to database.
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}

			if (pstmt != null) {
				// setting the data of DTO to the pstmt object.
				pstmt.setString(1, admin.getBook_name());
				pstmt.setString(2, admin.getBook_author());
				pstmt.setString(3, admin.getBook_price());
				pstmt.setString(4, admin.getBook_category());
				pstmt.setString(5, admin.getBook_image());

				// executing the query
				int rowAffected = pstmt.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	// method to select a book by admin.
	public Admin selectBook(int id) {
		// select query for selecting a book data to the database.
		String sqlSelectQuery = "select book_id,book_name,book_author,book_price,book_category,book_image,user_id from books_data where book_id=? ";
		Admin admin = null;

		try {
			// getting the connection to database.
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
			}

			if (pstmt != null) {
				// setting the id to pstmt.
				pstmt.setInt(1, id);

				// executing the query
				resultSet = pstmt.executeQuery();

				if (resultSet.next()) {

					admin = new Admin();

					admin.setBook_id(resultSet.getInt(1));
					admin.setBook_name(resultSet.getString(2));
					admin.setBook_author(resultSet.getString(3));
					admin.setBook_price(resultSet.getString(4));
					admin.setBook_category(resultSet.getString(5));
					admin.setBook_image(resultSet.getString(6));
					admin.setUser_id(resultSet.getInt(7));

					return admin;
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;

	}

	// method to delete a book by admin.
	public String deleteBook(int id) {
		// delete query for deleting a book data to the database.
		String sqlDeleteQuery = "delete from books_data where book_id=? ";

		try {
			// getting the connection to database.
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlDeleteQuery);
			}

			if (pstmt != null) {
				// setting the id to pstmt.
				pstmt.setInt(1, id);

				// executing the query
				int rowAffected = pstmt.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failure";

	}

	// method to update a book by admin.
	public String UpdateBook(Admin admin) {

		// update query for updating a book data to the database.

		String sqlUpdateQuery = "update books_data set book_name=?,book_author=?,book_price=?,book_category=?,book_image=?  where book_id=? ";

		try {
			// getting the connection to database.
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlUpdateQuery);
			}

			if (pstmt != null) {
				// setting the data of DTO to the pstmt object.
				pstmt.setString(1, admin.getBook_name());
				pstmt.setString(2, admin.getBook_author());
				pstmt.setString(3, admin.getBook_price());
				pstmt.setString(4, admin.getBook_category());
				pstmt.setString(5, admin.getBook_image());
				pstmt.setInt(6, admin.getBook_id());

				// executing the query
				int rowAffected = pstmt.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failure";

	}

	// searching all books.
	public List<Admin> searchAllBooks() {

		// select query for selecting all books from the database.
		String sqlSelectQuery = "select book_id,book_name,book_author,book_price,book_category,book_image from books_data";
		List<Admin> arrayList = new ArrayList<Admin>();
		Admin admin = null;

		try {
			// getting the connection to database.
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
			}

			if (pstmt != null) {

				// executing the query
				resultSet = pstmt.executeQuery();
			}

			if (resultSet != null) {

				/* arrayList = new ArrayList<Admin>(); */

				while (resultSet.next()) {

					admin = new Admin();
					admin.setBook_id(resultSet.getInt(1));
					admin.setBook_name(resultSet.getString(2));
					admin.setBook_author(resultSet.getString(3));
					admin.setBook_price(resultSet.getString(4));
					admin.setBook_category(resultSet.getString(5));
					admin.setBook_image(resultSet.getString(6));

					arrayList.add(admin);
				}

				return arrayList;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arrayList;
	}

	// logic of getting books of category new
	public List<Admin> getNewBooks() {

		// select query for selecting New books from the database.
		String sqlSelectQuery = "select book_id,book_name,book_author,book_price,book_category,book_image from books_data where book_category=?";
		List<Admin> arrayList = new ArrayList<Admin>();
		Admin admin = null;

		try {
			// getting the connection to database.
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
			}

			if (pstmt != null) {

				pstmt.setString(1, "new");
				// executing the query
				resultSet = pstmt.executeQuery();
			}

			if (resultSet != null) {

				/* arrayList = new ArrayList<Admin>(); */

				int i = 1;
				while (resultSet.next() && i <= 4) {

					admin = new Admin();
					admin.setBook_id(resultSet.getInt(1));
					admin.setBook_name(resultSet.getString(2));
					admin.setBook_author(resultSet.getString(3));
					admin.setBook_price(resultSet.getString(4));
					admin.setBook_category(resultSet.getString(5));
					admin.setBook_image(resultSet.getString(6));

					arrayList.add(admin);
					i++;
				}

				return arrayList;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arrayList;
	}

	// logic of getting books of category old
	public List<Admin> getOldBooks() {
		// select query for selecting New books from the database.
		String sqlSelectQuery = "select book_id,book_name,book_author,book_price,book_category,book_image from books_data where book_category=?";
		List<Admin> arrayList = new ArrayList<Admin>();
		Admin admin = null;

		try {
			// getting the connection to database.
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
			}

			if (pstmt != null) {

				pstmt.setString(1, "old");
				// executing the query
				resultSet = pstmt.executeQuery();
			}

			if (resultSet != null) {

				/* arrayList = new ArrayList<Admin>(); */

				int i = 1;
				while (resultSet.next() && i <= 4) {

					admin = new Admin();
					admin.setBook_id(resultSet.getInt(1));
					admin.setBook_name(resultSet.getString(2));
					admin.setBook_author(resultSet.getString(3));
					admin.setBook_price(resultSet.getString(4));
					admin.setBook_category(resultSet.getString(5));
					admin.setBook_image(resultSet.getString(6));

					arrayList.add(admin);
					i++;
				}

				return arrayList;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arrayList;
	}

	// logic of getting recent books
	public List<Admin> getRecentBooks() {

		// select query for selecting recent books from the database.
		String sqlSelectQuery = "select book_id,book_name,book_author,book_price,book_category,book_image from books_data";
		List<Admin> arrayList = new ArrayList<Admin>();
		Admin admin = null;

		try {
			// getting the connection to database.
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
			}

			if (pstmt != null) {

				// executing the query
				resultSet = pstmt.executeQuery();
			}

			if (resultSet != null) {

				/* arrayList = new ArrayList<Admin>(); */

				resultSet.afterLast();

				int i = 1;
				while (resultSet.previous() && i <= 4) {

					admin = new Admin();
					admin.setBook_id(resultSet.getInt(1));
					admin.setBook_name(resultSet.getString(2));
					admin.setBook_author(resultSet.getString(3));
					admin.setBook_price(resultSet.getString(4));
					admin.setBook_category(resultSet.getString(5));
					admin.setBook_image(resultSet.getString(6));

					arrayList.add(admin);
					i++;
				}

				return arrayList;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arrayList;
	}

	// logic to add the book to the cart data.
	public String addToCart(Admin admin) {
		// insert query for inserting the cart data to the database.
		String sqlInsertQuery = "insert into cart_data(book_id,user_id,book_name,book_author,book_price)values(?,?,?,?,?)";

		try {
			// getting the connection to database.
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}

			if (pstmt != null) {
				// setting the data of DTO to the pstmt object.
				pstmt.setInt(1, admin.getBook_id());
				pstmt.setInt(2, admin.getUser_id());
				pstmt.setString(3, admin.getBook_name());
				pstmt.setString(4, admin.getBook_author());
				pstmt.setString(5, admin.getBook_price());

				// executing the query
				int rowAffected = pstmt.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	// method to send data to the cart page.
	public List<Admin> viewCart(int id) {
		// select query for selecting the books added to the cart.
		String sqlSelectQuery = "select cart_id,book_id,user_id,book_name,book_author,book_price from cart_data where user_id=?";
		List<Admin> arrayList = new ArrayList<Admin>();
		Admin admin = null;
		Double total_price = 0.0;

		try {
			// getting the connection to database.
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
			}

			if (pstmt != null) {

				pstmt.setInt(1, id);
				// executing the query
				resultSet = pstmt.executeQuery();
			}

			if (resultSet != null) {

				/* arrayList = new ArrayList<Admin>(); */

				while (resultSet.next()) {

					admin = new Admin();
					admin.setCart_id(resultSet.getInt(1));
					admin.setBook_id(resultSet.getInt(2));
					admin.setUser_id(resultSet.getInt(3));
					admin.setBook_name(resultSet.getString(4));
					admin.setBook_author(resultSet.getString(5));
					admin.setBook_price(resultSet.getString(6));

					total_price = total_price + Double.parseDouble(resultSet.getString(6));
					admin.setTotal_price(total_price);

					arrayList.add(admin);

				}

				return arrayList;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arrayList;
	}

	// logic of deleting a book from cart.
	public String deleteBookFromCart(int userId, int bookId, int cartId) {

		// delete query for deleting a book from cart database.
		String sqlDeleteQuery = "delete from cart_data where user_id=? and book_id=? and cart_id=? ";

		try {
			// getting the connection to database.
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlDeleteQuery);
			}

			if (pstmt != null) {
				// setting the id to pstmt.
				pstmt.setInt(1, userId);
				pstmt.setInt(2, bookId);
				pstmt.setInt(3, cartId);

				// executing the query
				int rowAffected = pstmt.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	// logic of adding book to sell to the database.
	public String sellBook(Admin admin) {
		// insert query for inserting the book data to the database.
		String sqlInsertQuery = "insert into books_data(book_name,book_author,book_price,book_category,book_image, user_id)values(?,?,?,?,?,?)";

		try {
			// getting the connection to database.
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}

			if (pstmt != null) {
				// setting the data of DTO to the pstmt object.
				pstmt.setString(1, admin.getBook_name());
				pstmt.setString(2, admin.getBook_author());
				pstmt.setString(3, admin.getBook_price());
				pstmt.setString(4, admin.getBook_category());
				pstmt.setString(5, admin.getBook_image());
				pstmt.setInt(6, admin.getUser_id());

				// executing the query
				int rowAffected = pstmt.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failure";
	}


	// logic to update the user's profile
	public String editProfile(User user) {

		// update query for updating a user data to the database.
		String sqlUpdateQuery = "update user_data set name=?,email=?,phoneNO=?,password=?,address=? ,city=? ,state=? ,pin=?  where id=? ";

		try {
			// getting the connection to database.
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlUpdateQuery);
			}

			if (pstmt != null) {
				// setting the data of DTO to the pstmt object.
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getEmail());
				pstmt.setString(3, user.getPhoneNo());
				pstmt.setString(4, user.getPassword());
				pstmt.setString(5, user.getAddress());
				pstmt.setString(6, user.getCity());
				pstmt.setString(7, user.getState());
				pstmt.setString(8, user.getPin());
				pstmt.setInt(9, user.getId());

				// executing the query
				int rowAffected = pstmt.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	// logic to order the books
	public String order(User user, List<Admin> arrayList, String paymentType) {

		boolean flag = true;
		// insert query for inserting the order data to the database.
		String sqlInsertQuery = "insert into order_data(user_id,user_name,user_email,user_address,user_city,user_state,user_pin,user_phoneNo,book_name,book_author,book_price,payment_type)values(?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			// getting the connection to database.
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}

			if (pstmt != null) {

				for (Admin admin : arrayList) {
					pstmt.setInt(1, user.getId());
					pstmt.setString(2, user.getName());
					pstmt.setString(3, user.getEmail());
					pstmt.setString(4, user.getAddress());
					pstmt.setString(5, user.getCity());
					pstmt.setString(6, user.getState());
					pstmt.setString(7, user.getPin());
					pstmt.setString(8, user.getPhoneNo());
					pstmt.setString(9, admin.getBook_name());
					pstmt.setString(10, admin.getBook_author());
					pstmt.setString(11, admin.getBook_price());
					pstmt.setString(12, paymentType);

					pstmt.addBatch();
				}

				int[] rowAffected = pstmt.executeBatch();

				for (int i : rowAffected) {
					if (i != 1) {
						flag = false;
						break;
					}
				}

				if (flag == true) {
					return "success";
				} else {
					return "failure";
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	public List<Admin> viewOrders(int userId) {

		// select query for getting the orders.
		String sqlSelectQuery = "select order_id,user_name,book_name,book_author,book_price,payment_type from order_data where user_id=?";
		List<Admin> arrayList = new ArrayList<Admin>();
		Admin admin = null;

		try {
			// getting the connection to database.
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
			}

			if (pstmt != null) {

				pstmt.setInt(1, userId);
				// executing the query
				resultSet = pstmt.executeQuery();
			}

			if (resultSet != null) {

				/* arrayList = new ArrayList<Admin>(); */

				while (resultSet.next()) {

					admin = new Admin();
					admin.setOrder_id(resultSet.getInt(1));
					admin.setUser_name(resultSet.getString(2));
					admin.setBook_name(resultSet.getString(3));
					admin.setBook_author(resultSet.getString(4));
					admin.setBook_price(resultSet.getString(5));
					admin.setPayment_type(resultSet.getString(6));

					arrayList.add(admin);

				}

				return arrayList;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arrayList;
	}

	// method to get a user by its id.
	public User getUser(int id) {

		// select query for selecting a user's data from the database.
		String sqlSelectQuery = "select name,email,phoneNO from user_data where id=?";
		User user = null;

		try {
			// getting the connection to database.
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
			}

			if (pstmt != null) {
				// setting the id to pstmt.
				pstmt.setInt(1, id);

				// executing the query
				resultSet = pstmt.executeQuery();

				if (resultSet.next()) {

					user = new User();

					user.setName(resultSet.getString(1));
					user.setEmail(resultSet.getString(2));
					user.setPhoneNo(resultSet.getString(3));

					return user;
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	
	// logic to check email existence in database while registering.
	public boolean checkEmail(String email) {
		// select query for checking the email.
		String sqlSelectQuery = "select email from user_data";
		

		try {
			// getting the connection to database.
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
			}

			if (pstmt != null) {
				
				// executing the query
				resultSet = pstmt.executeQuery();

				while (resultSet.next()) {

					if(email.equals(resultSet.getString(1))) {
						return true;
					}
					else {
						return false;
					}
				
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
