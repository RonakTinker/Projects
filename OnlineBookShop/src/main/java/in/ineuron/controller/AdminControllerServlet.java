package in.ineuron.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ineuron.dto.Admin;
import in.ineuron.dto.User;
import in.ineuron.service.IUserService;
import in.ineuron.serviceFactory.UserServiceFactory;

@WebServlet("/admincontroller/*")
public class AdminControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// method to validate name.
	private boolean validateName(String name) {
		boolean flag = true;
		if (name == null || name.equals("")) {
			flag = false;

		} else {

			// second level validation.
			name = name.trim();
			String[] split_name = name.split(" ");

			for (String elem : split_name) {
				int len = elem.length();
				for (int i = 0; i < len; i++) {
					if ((elem.charAt(i) >= 'a' && elem.charAt(i) <= 'z')
							|| (elem.charAt(i) >= 'A' && elem.charAt(i) <= 'Z')) {

					} else {
						flag = false;
						break;
					}
				}

				if (flag == false) {
					
					break;
				}

			}
		}

		return flag;
	}

	// method to validate id.
	private boolean validateId(String id) {
		boolean flag = true;

		if (id == null || id.equals("")) {
			flag = false;
		} else {
			id = id.trim();
			int len = id.length();

			if (id.equals("0")) {
				flag = false;
			} else {
				for (int i = 0; i < len; i++) {
					if ((id.charAt(i) >= '0' && id.charAt(i) <= '9')) {

					} else {
						
						flag = false;
						break;
					}
				}
			}

		}

		return flag;
	}

	// method to validate price
	private boolean validatePrice(String price) {
		boolean flag = true;

		if (price == null || price.equals("")) {
			flag = false;
		} else {

			// second level validation.
			price = price.trim();
			int len = price.length();

			for (int i = 0; i < len; i++) {
				if ((price.charAt(i) >= '0' && price.charAt(i) <= '9')) {

				} else {
					
					flag = false;
					break;
				}
			}

		}

		return flag;
	}

	// method to validate image.
	private boolean validateImage(String image) {
		boolean flag = true;

		if (image == null || image.equals("")) {
			flag = false;
		} else {

			// second level validation.
			image = image.trim();
			if (image.endsWith(".jpg") || image.endsWith(".png")) {

			} else {
				flag = false;
			}

		}

		return flag;
	}

	// method to validate email.
	private boolean validateEmail(String email) {
		boolean flag = true;

		// first level validation.
		if (email == null || email.equals("")) {
			flag = false;
		} else {

			// second level validation.
			email = email.trim();
			int len = email.length();

			if (email.endsWith("@gmail.com")) {

				for (int i = 0; i < len - 10; i++) {
					if ((email.charAt(i) >= 'a' && email.charAt(i) <= 'z')
							|| (email.charAt(i) >= 'A' && email.charAt(i) <= 'Z')
							|| (email.charAt(i) >= '0' && email.charAt(i) <= '9')) {

					} else {
						
						flag = false;
						break;
					}
				}
			}

			else {
				
				flag = false;
			}
		}

		return flag;
	}

	// method to validate phone number.
	private boolean validatePhoneNo(String phoneNo) {
		boolean flag = true;

		// first level validation
		if (phoneNo == null || phoneNo.equals("")) {
			flag = false;
		} else {

			// second level validation.
			phoneNo = phoneNo.trim();
			int len = phoneNo.length();

			if (len != 10) {
				
				flag = false;
			} else {

				for (int i = 0; i < len; i++) {
					if ((phoneNo.charAt(i) >= '0' && phoneNo.charAt(i) <= '9')) {

					} else {
						
						flag = false;
						break;
					}
				}

			}
		}

		return flag;
	}

	// method to validate password.
	private boolean validatePassword(String password) {
		boolean flag = true;

		// password validation.
		if (password == null || password.equals("")) {
			flag = false;
		} else {

			// second level validation.
			password = password.trim();
			int len = password.length();

			if (len < 8) {
				
				flag = false;
			} else {

				for (int i = 0; i < len; i++) {
					if (password.charAt(i) == ' ') {
						
						flag = false;
						break;
					}
				}
			}
		}

		return flag;
	}

	// method to validate Street address.
	private boolean validateAddress(String address) {
		boolean flag = true;

		if (address == null || address.equals("")) {
			flag = false;
		} else {

			// second level validation.
			address = address.trim();
			String[] split_address = address.split(" ");

			for (String elem : split_address) {
				int len = elem.length();
				for (int i = 0; i < len; i++) {
					if ((elem.charAt(i) >= 'a' && elem.charAt(i) <= 'z')
							|| (elem.charAt(i) >= 'A' && elem.charAt(i) <= 'Z')
							|| (elem.charAt(i) >= '0' && elem.charAt(i) <= '9')) {

					} else {
						flag = false;
						break;
					}
				}

				if (flag == false) {
					
					break;
				}

			}
		}

		return flag;

	}

	// method to validate pin code.
	private boolean validatePinCode(String pin) {
		boolean flag = true;

		if (pin == null || pin.equals("")) {
			flag = false;
		} else {
			// pin validation
			pin = pin.trim();
			int len = pin.length();

			if (len != 6) {
				flag = false;
			} else {
				if (pin.charAt(0) > '0' && pin.charAt(0) <= '9') {

					for (int i = 1; i < len; i++) {
						if (pin.charAt(i) >= '0' && pin.charAt(i) <= '9') {

						} else {
							flag = false;
							break;
						}
					}
				} else {
					flag = false;
				}
			}

		}

		return flag;
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IUserService userService = UserServiceFactory.getUserService();
		HttpSession session = request.getSession();
		boolean flag = true;

		

		// logic of adding a book.
		if (request.getRequestURI().endsWith("addBook")) {

			// getting the parameters of add books form
			String bookName = request.getParameter("bookName");
			String authorName = request.getParameter("authorName");
			String price = request.getParameter("price");
			String category = request.getParameter("category");
			String image = request.getParameter("image");

			

			// book name validation
			if (validateName(bookName) == false) {
				flag = validateName(bookName);

			}

			// author name validation
			if (validateName(authorName) == false) {
				flag = validateName(authorName);

			}

			// price validation
			if (validatePrice(price) == false) {
				flag = validatePrice(price);

			}

			// category validation
			if (category.equals("noselect")) {
				flag = false;

			}

			// image validation
			if (validateImage(image) == false) {
				flag = validateImage(image);

			}

			if (flag == false) {
				session.setAttribute("message", "close");
				response.sendRedirect("../admin/add_books.jsp");
			} else {

				Admin admin = new Admin();

				// setting the add books form parameters in DTO object.
				admin.setBook_name(bookName);
				admin.setBook_author(authorName);
				admin.setBook_price(price);
				admin.setBook_category(category);
				admin.setBook_image(image);

				// sending the DTO object to service layer.
				String status = userService.addBook(admin);
				System.out.println("succcess");
				// getting the final message and showing that to a suitable page.
				if (status.equals("success")) {
					session.setAttribute("message", "done");
					response.sendRedirect("../admin/add_books.jsp");
				} else {
					session.setAttribute("message", "close");
					response.sendRedirect("../admin/add_books.jsp");
				}
			}

		}

		// logic of searching a book.
		if (request.getRequestURI().endsWith("searchBook")) {

			// id validation
			if (validateId(request.getParameter("id")) == false) {
				flag = validateId(request.getParameter("id"));
			}

			if (flag == false) {
				session.setAttribute("message", "close");
				response.sendRedirect("../admin/search_book.jsp");
			} else {

				// getting the parameters of search form
				int id = Integer.parseInt(request.getParameter("id"));

				

				Admin admin = userService.selectBook(id);

				if (admin != null) {

					session.setAttribute("admin_obj", admin);
					response.sendRedirect("../admin/book_data.jsp");
				} else {

					session.setAttribute("message", "close");
					response.sendRedirect("../admin/search_book.jsp");
				}
			}

		}

		// logic of deleting a book.
		if (request.getRequestURI().endsWith("deleteBook")) {

			// id validation
			if (validateId(request.getParameter("id")) == false) {
				flag = validateId(request.getParameter("id"));
			}

			if (flag == false) {
				session.setAttribute("message", "close");
				response.sendRedirect("../admin/delete_book.jsp");
			} else {
				// getting the parameters of delete form
				int id = Integer.parseInt(request.getParameter("id"));

				

				String status = userService.deleteBook(id);

				// getting the final message and showing that to a suitable page.
				if (status.equals("success")) {
					session.setAttribute("message", "done");
					response.sendRedirect("../admin/delete_book.jsp");
				} else {
					session.setAttribute("message", "close");
					response.sendRedirect("../admin/delete_book.jsp");
				}
			}

		}

		// logic of updating a book.
		if (request.getRequestURI().endsWith("updateBook")) {

			// id validation
			if (validateId(request.getParameter("id")) == false) {
				flag = validateId(request.getParameter("id"));
			}

			if (flag == false) {
				session.setAttribute("message", "close");
				response.sendRedirect("../admin/update_book.jsp");
			} else {
				// getting the parameters of update form
				int id = Integer.parseInt(request.getParameter("id"));

				

				Admin admin = userService.selectBook(id);

				if (admin != null) {
					session.setAttribute("admin_obj", admin);
					response.sendRedirect("../admin/update_book2.jsp");
				} else {

					session.setAttribute("message", "close");
					response.sendRedirect("../admin/update_book.jsp");
				}
			}

		}

		// logic of Updating a book further.
		if (request.getRequestURI().endsWith("updateBook2")) {

			// getting the parameters of add books form
			String bookId = request.getParameter("id");
			String bookName = request.getParameter("bookName");
			String authorName = request.getParameter("authorName");
			String price = request.getParameter("price");
			String category = request.getParameter("category");
			String image = request.getParameter("image");

			

			// book name validation
			if (validateName(bookName) == false) {
				flag = validateName(bookName);
			}

			// author name validation
			if (validateName(authorName) == false) {
				flag = validateName(authorName);
			}

			// price validation
			if (validatePrice(price) == false) {
				flag = validatePrice(price);
			}

			if (flag == false) {
				session.setAttribute("message", "close");
				response.sendRedirect("../admin/update_book2.jsp");
			} else {
				Admin admin = userService.selectBook(Integer.parseInt(bookId));

				image = image.trim();
				if (image == null || image.equals("")) {

					// setting the add books form parameters in DTO object.
					admin.setBook_id(Integer.parseInt(bookId));
					admin.setBook_name(bookName);
					admin.setBook_author(authorName);
					admin.setBook_price(price);
					admin.setBook_category(category);

					// sending the DTO object to service layer.
					String status = userService.UpdateBook(admin);

					// getting the final message and showing that to a suitable page.
					if (status.equals("success")) {
						session.setAttribute("message", "done");
						response.sendRedirect("../admin/update_book2.jsp");
					} else {
						session.setAttribute("message", "close");
						response.sendRedirect("../admin/update_book2.jsp");
					}
				} else {
					// image validation
					if (image.endsWith(".jpg") || image.endsWith(".png")) {
						admin.setBook_image(image);

						// setting the add books form parameters in DTO object.
						admin.setBook_id(Integer.parseInt(bookId));
						admin.setBook_name(bookName);
						admin.setBook_author(authorName);
						admin.setBook_price(price);
						admin.setBook_category(category);

						// sending the DTO object to service layer.
						String status = userService.UpdateBook(admin);

						// getting the final message and showing that to a suitable page.
						if (status.equals("success")) {
							session.setAttribute("message", "done");
							response.sendRedirect("../admin/update_book2.jsp");
						} else {
							session.setAttribute("message", "close");
							response.sendRedirect("../admin/update_book2.jsp");
						}
					} else {
						response.sendRedirect("../admin/update_book2.jsp");
					}

				}

			}

		}

		// logic of searching all books.
		if (request.getRequestURI().endsWith("searchAllBooks")) {

			List<Admin> arrayList = userService.searchAllBooks();

			if (arrayList.isEmpty() != true) {
				session.setAttribute("arrayList1", arrayList);
				response.sendRedirect("../admin/search_all_books.jsp");

			} else {
				session.setAttribute("dataMessage", "No records available");
				response.sendRedirect("../admin/search_all_books.jsp");
			}

		}

		// logic of logout an admin.
		if (request.getRequestURI().endsWith("logout")) {
			System.out.println("logout...");

			// removing the used attributes.
			session.removeAttribute("obj");
			session.removeAttribute("name");
			response.sendRedirect("../index.jsp");
		}

		// logic of home page.
		if (request.getRequestURI().endsWith("index.jsp") || request.getRequestURI().endsWith("OnlineBookShop/")) {

			List<Admin> arrayList = userService.getNewBooks();
			List<Admin> arrayList_old = userService.getOldBooks();
			List<Admin> arrayList_recent = userService.getRecentBooks();

			if (arrayList.isEmpty() != true && arrayList_old.isEmpty() != true && arrayList_recent.isEmpty() != true) {
				
				session.setAttribute("arrayList", arrayList);
				session.setAttribute("arrayList_old", arrayList_old);
				session.setAttribute("arrayList_recent", arrayList_recent);

			} else if (arrayList.isEmpty() != true && arrayList_old.isEmpty() != true) {
				session.setAttribute("arrayList", arrayList);
				session.setAttribute("arrayList_old", arrayList_old);
				session.setAttribute("arrayList_recent", arrayList_recent);
				session.setAttribute("message1", "No books available");

			} else if (arrayList_old.isEmpty() != true && arrayList_recent.isEmpty() != true) {
				session.setAttribute("message1", "No books available");
				session.setAttribute("arrayList_old", arrayList_old);
				session.setAttribute("arrayList_recent", arrayList_recent);
				session.setAttribute("arrayList", arrayList);

			} else if (arrayList.isEmpty() != true && arrayList_recent.isEmpty() != true) {
				
				session.setAttribute("arrayList", arrayList);
				session.setAttribute("message1", "No books available");
				session.setAttribute("arrayList_recent", arrayList_recent);
				session.setAttribute("arrayList_old", arrayList_old);

			} else if (arrayList.isEmpty() != true) {
				
				session.setAttribute("arrayList", arrayList);
				session.setAttribute("message1", "No books available");
				session.setAttribute("arrayList_recent", arrayList_recent);
				session.setAttribute("arrayList_old", arrayList_old);

			}

			else if (arrayList_old.isEmpty() != true) {
				
				session.setAttribute("arrayList_old", arrayList_old);
				session.setAttribute("message1", "No books available");
				session.setAttribute("arrayList", arrayList);
				session.setAttribute("arrayList_recent", arrayList_recent);

			}

			else if (arrayList_recent.isEmpty() != true) {
				
				session.setAttribute("arrayList_recent", arrayList_recent);
				session.setAttribute("message1", "No books available");
				session.setAttribute("arrayList", arrayList);
				session.setAttribute("arrayList_old", arrayList_old);

			} else {

				session.setAttribute("arrayList", arrayList);
				session.setAttribute("arrayList_old", arrayList_old);
				session.setAttribute("arrayList_recent", arrayList_recent);
				session.setAttribute("message1", "No books available");

			}

		}

		// logic of adding the books to cart.
		if (request.getRequestURI().endsWith("cart")) {

			User user = (User) session.getAttribute("obj");
			int user_id = user.getId();

			int book_id = Integer.parseInt(request.getParameter("bid"));

			Admin admin = userService.selectBook(book_id);
			admin.setUser_id(user_id);

			String status = userService.addToCart(admin);

			// getting the final message and showing that to a suitable page.
			if (status.equals("success")) {
				session.setAttribute("message", "Added to cart successfully..");
				response.sendRedirect("../success.jsp");
			} else {
				session.setAttribute("message", "Something went wrong..");
				response.sendRedirect("../success.jsp");
			}
		}

		// logic of showing the books to the cart page.
		if (request.getRequestURI().endsWith("cart.jsp")) {

			User user = (User) session.getAttribute("obj");
			int user_id = user.getId();
			List<Admin> arrayList_cart = userService.viewCart(user_id);

			if (arrayList_cart.isEmpty() != true) {

				session.setAttribute("arrayList_cart", arrayList_cart);
			} else {
				session.setAttribute("arrayList_cart", arrayList_cart);
			}
		}

		// logic of removing a book from cart.
		if (request.getRequestURI().endsWith("removeBook")) {

			User user = (User) session.getAttribute("obj");
			int userId = user.getId();
			int bookId = Integer.parseInt(request.getParameter("bid"));
			int cartId = Integer.parseInt(request.getParameter("cid"));
			String status = userService.deleteBookFromCart(userId, bookId, cartId);

			// getting the final message and showing that to a suitable page.
			if (status.equals("success")) {
				response.sendRedirect("../cart.jsp");

			} else {
				response.sendRedirect("../cart.jsp");
			}
		}

		// logic of selling a old book by user.
		if (request.getRequestURI().endsWith("sellBook")) {
			// getting the parameters of add books form
			String bookName = request.getParameter("bookName");
			String authorName = request.getParameter("authorName");
			String price = request.getParameter("price");
			String image = request.getParameter("image");
			String category = request.getParameter("category");

			// book name validation
			if (validateName(bookName) == false) {
				flag = validateName(bookName);
			}

			// author name validation
			if (validateName(authorName) == false) {
				flag = validateName(authorName);
			}

			// price validation
			if (validatePrice(price) == false) {
				flag = validatePrice(price);
			}

			// image validation
			if (validateImage(image) == false) {
				flag = validateImage(image);
			}

			// category validation
			if (category.equals("noselect")) {
				flag = false;
			}

			if (flag == false) {
				session.setAttribute("message", "close");
				response.sendRedirect("../sell_old_book.jsp");
			} else {
				User user = (User) session.getAttribute("obj");
				int userId = user.getId();

				

				Admin admin = new Admin();

				// setting the add books form parameters in DTO object.
				admin.setBook_name(bookName);
				admin.setBook_author(authorName);
				admin.setBook_price(price);
				admin.setBook_image(image);
				admin.setBook_category(category);
				admin.setUser_id(userId);

				// sending the DTO object to service layer.
				String status = userService.sellBook(admin);

				// getting the final message and showing that to a suitable page.
				if (status.equals("success")) {
					session.setAttribute("message", "done");
					response.sendRedirect("../sell_old_book.jsp");
				} else {
					session.setAttribute("message", "close");
					response.sendRedirect("../sell_old_book.jsp");
				}
			}

		}

		
		// logic of removing my book from books data.
		if (request.getRequestURI().endsWith("edit")) {
			System.out.println("profile changed");

			// getting the parameters of the edit profile form.
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phoneNo = request.getParameter("phoneNo");
			String password = request.getParameter("password");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String pin = request.getParameter("pin");

			// name validation
			if (validateName(name) == false) {
				flag = validateName(name);
			}

			// Email validation
			if (validateEmail(email) == false) {
				flag = validateEmail(email);
			}

			// Phone number validation
			if (validatePhoneNo(phoneNo) == false) {
				flag = validatePhoneNo(phoneNo);
			}

			// Password validation
			if (validatePassword(password) == false) {
				flag = validatePassword(password);
			}

			// Address validation

			if (address == null || address.equals("")) {

			} else {

				// second level validation.
				address = address.trim();
				String[] split_address = address.split(" ");

				for (String elem : split_address) {
					int len = elem.length();
					for (int i = 0; i < len; i++) {
						if ((elem.charAt(i) >= 'a' && elem.charAt(i) <= 'z')
								|| (elem.charAt(i) >= 'A' && elem.charAt(i) <= 'Z')
								|| (elem.charAt(i) >= '0' && elem.charAt(i) <= '9')) {

						} else {
							flag = false;
							break;
						}
					}

					if (flag == false) {
						
						break;
					}

				}
			}

			// city validation

			if (city == null || city.equals("")) {

			} else {
				city = city.trim();
				String[] split_city = city.split(" ");

				for (String elem : split_city) {
					int len = elem.length();
					for (int i = 0; i < len; i++) {
						if ((elem.charAt(i) >= 'a' && elem.charAt(i) <= 'z')
								|| (elem.charAt(i) >= 'A' && elem.charAt(i) <= 'Z')) {

						} else {
							flag = false;
							break;
						}
					}

					if (flag == false) {
						
						break;
					}

				}
			}

			// state validation
			if (state == null || state.equals("")) {

			} else {
				state = state.trim();
				String[] split_state = state.split(" ");

				for (String elem : split_state) {
					int len = elem.length();
					for (int i = 0; i < len; i++) {
						if ((elem.charAt(i) >= 'a' && elem.charAt(i) <= 'z')
								|| (elem.charAt(i) >= 'A' && elem.charAt(i) <= 'Z')) {

						} else {
							flag = false;
							break;
						}
					}

					if (flag == false) {
						
						break;
					}

				}
			}

			// pin code validation
			if (pin == null || pin.equals("")) {

			} else {
				// pin validation
				pin = pin.trim();
				int len = pin.length();

				if (len != 6) {
					flag = false;
				} else {
					if (pin.charAt(0) > '0' && pin.charAt(0) <= '9') {

						for (int i = 1; i < len; i++) {
							if (pin.charAt(i) >= '0' && pin.charAt(i) <= '9') {

							} else {
								flag = false;
								break;
							}
						}
					} else {
						flag = false;
					}
				}

			}

			if (flag == false) {
				session.setAttribute("message", "close");
				response.sendRedirect("../edit_profile.jsp");
			} else {
				User user = (User) session.getAttribute("obj");

				// setting the parameters to the user object.
				user.setName(name);
				user.setEmail(email);
				user.setPhoneNo(phoneNo);
				user.setPassword(password);
				user.setAddress(address);
				user.setCity(city);
				user.setState(state);
				user.setPin(pin);

				String status = userService.editProfile(user);

				// getting the final message and showing that to a suitable page.
				if (status.equals("success")) {
					session.setAttribute("obj", user);
					session.setAttribute("message", "done");
					response.sendRedirect("../edit_profile.jsp");

				} else {
					session.setAttribute("message", "close");
					response.sendRedirect("../edit_profile.jsp");
				}
			}

		}

		// logic of removing my book from books data.
		if (request.getRequestURI().endsWith("order")) {
			

			// getting the parameters of the edit profile form.
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phoneNo = request.getParameter("phoneNo");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String pin = request.getParameter("pin");
			String paymentType = request.getParameter("paymentType");

			// name validation
			if (validateName(name) == false) {
				flag = validateName(name);
			}

			// Email validation
			if (validateEmail(email) == false) {
				flag = validateEmail(email);
			}

			// Phone number validation
			if (validatePhoneNo(phoneNo) == false) {
				flag = validatePhoneNo(phoneNo);
			}

			// address validation
			if (validateAddress(address) == false) {
				flag = validateAddress(address);
			}

			// city validation
			if (validateName(city) == false) {
				flag = validateName(city);
			}

			// state validation
			if (validateName(state) == false) {
				flag = validateName(state);
			}

			// pin validation
			if (validatePinCode(pin) == false) {
				flag = validatePinCode(pin);
			}

			// payment type validation
			if (paymentType.equals("noselect")) {
				flag = false;
			}

			if (flag == false) {
				session.setAttribute("message", "close");
				response.sendRedirect("../cart.jsp");
			} else {

				@SuppressWarnings("unchecked")
				List<Admin> cart = (List<Admin>) session.getAttribute("arrayList_cart");

				if (cart.isEmpty()) {
					session.setAttribute("message", "close");
					response.sendRedirect("../cart.jsp");
				} else {
					int userId = Integer.parseInt(request.getParameter("id"));
					User user = new User();
					user.setId(userId);
					user.setName(name);
					user.setEmail(email);
					user.setPhoneNo(phoneNo);
					user.setAddress(address);
					user.setCity(city);
					user.setState(state);
					user.setPin(pin);

					List<Admin> arrayList = userService.viewCart(userId);

					String status = userService.order(user, arrayList, paymentType);

					// getting the final message and showing that to a suitable page.
					if (status.equals("success")) {
						response.sendRedirect("../order_success.jsp");

					} else {
						session.setAttribute("message", "close");
						response.sendRedirect("../cart.jsp");
					}
				}
			}
		}

		// logic of removing my book from books data.
		if (request.getRequestURI().endsWith("my_orders.jsp")) {
			

			User user = (User) session.getAttribute("obj");
			int userId = user.getId();

			List<Admin> arrayList_orders = userService.viewOrders(userId);

			if (arrayList_orders.isEmpty() != true) {

				session.setAttribute("arrayList_orders", arrayList_orders);
			} else {
				session.setAttribute("arrayList_orders", arrayList_orders);
			}
		}



		// logic of searching all books.
		if (request.getRequestURI().endsWith("all_books.jsp")) {
			
			List<Admin> arrayList_all = userService.searchAllBooks();
			
			if (arrayList_all.isEmpty() != true) {
				session.setAttribute("arrayList_all", arrayList_all);

			} else {
				session.setAttribute("arrayList_all", arrayList_all);
				session.setAttribute("message2", "No records available");
			}

		}
	}

}
