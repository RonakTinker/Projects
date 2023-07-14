package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ineuron.dto.User;
import in.ineuron.service.IUserService;
import in.ineuron.serviceFactory.UserServiceFactory;

@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	// common method for every action on browser.
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IUserService userService = UserServiceFactory.getUserService();
		HttpSession session = request.getSession();

		// registration logic.
		if (request.getRequestURI().endsWith("register")) {

			// getting the parameters of registration form
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phoneNo = request.getParameter("phoneNo");
			String password = request.getParameter("password");

			
			boolean emailStatus = userService.checkEmail(email);

			if (emailStatus == true) {
				session.setAttribute("duplicateMsg", "Email already exists..");
				response.sendRedirect("../register.jsp");
			} else {
				User user = new User();

				// setting the registration parameters in DTO object.
				user.setName(name);
				user.setEmail(email);
				user.setPhoneNo(phoneNo);
				user.setPassword(password);

				// sending the DTO object to service layer.
				String status = userService.userRegister(user);

				// getting the final message and showing that to a suitable page.
				if (status.equals("success")) {
					session.setAttribute("message", "done");
					response.sendRedirect("../register.jsp");
				} else {
					session.setAttribute("message", "close");
					response.sendRedirect("../register.jsp");
				}
			}

		}

		// login logic.
		if (request.getRequestURI().endsWith("login")) {

			// getting the parameters of login form
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			

			// statically checking the email and password of admin
			if (email.equals("admin@gmail.com") && password.equals("admin1234")) {
				User user = new User();
				user.setName("admin");
				session.setAttribute("name", "admin");
				session.setAttribute("obj", user);
				response.sendRedirect("../");
			}
			// checking the email and password of user and getting the user's data from database.
			else {

				User user = userService.login(email, password);

				if (user != null) {
					
					session.setAttribute("name", "user");
					session.setAttribute("obj", user);
					response.sendRedirect("../");
				} else {
					session.setAttribute("message", "close");
					response.sendRedirect("../login.jsp");
				}

			}
		}

	}
}
