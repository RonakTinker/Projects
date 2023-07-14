package in.ineuron.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/controller/*")
public class Validation implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session = req.getSession();
		
		boolean flag=true;
		
		//validation logic of registration data
		if(req.getRequestURI().endsWith("register")) 
		{
			
			//getting the parameters of registration form
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String phoneNo=request.getParameter("phoneNo");
			String password=request.getParameter("password");
			
			
			
			//name validation//
			
			//first level validation.
			if(name==null || name.equals("")) {
				flag=false;
				
			}
			else {
				
				//second level validation.
				name=name.trim();
				String[] split_name = name.split(" ");
				
				for (String elem : split_name) {
					int len=elem.length();
					for(int i=0; i<len; i++) {
						if((elem.charAt(i)>='a' && elem.charAt(i)<='z') || (elem.charAt(i)>='A' && elem.charAt(i)<='Z') ) {
							
						}
						else {
							flag=false;
							break;
						}
					}
					
					if(flag==false) {
						
						break;
					}
					
				}
			}
			
			
			//email validation//
			
			
			//first level validation.
			if(email==null || email.equals("")) {
				flag=false;
			}
			else {
				
				//second level validation.
				email=email.trim();
				int len=email.length();
				
				if(email.endsWith("@gmail.com")) {
					
					for(int i=0;i<len-10;i++) {
						if((email.charAt(i)>='a' && email.charAt(i)<='z') || (email.charAt(i)>='A' && email.charAt(i)<='Z') || (email.charAt(i)>='0' && email.charAt(i)<='9')) {
							
						}
						else {
							
							flag=false;
							break;
						}
					}
				}
				
				else {
					
					flag=false;
				}
			}
			
			
			
			//phoneNo validation//
			
			
			//first level validation
			if(phoneNo==null || phoneNo.equals("")) {
				flag=false;
			}
			else {
				
				//second level validation.
				phoneNo=phoneNo.trim();
				int len=phoneNo.length();
				
				if(len!=10) {
					
					flag=false;
				}
				else {
					
					for(int i=0;i<len;i++) {
						if((phoneNo.charAt(i)>='0' && phoneNo.charAt(i)<='9')) {
							
						}
						else {
							
							flag=false;
							break;
						}
					}
					
				}
			}
			
			
			//password validation//
			
			//password validation.
			if(password==null || password.equals("")) {
				
				flag=false;
			}
			else {
				
				//second level validation.
				password=password.trim();
				int len=password.length();
				
				if(len<8) {
					
					flag=false;
				}
				else {
					
					for(int i=0;i<len;i++) {
						if(password.charAt(i)==' ') {
							
							flag=false;
							break;
						}
					}
				}
			}
	 
			
			
			//final dispatching logic.
			if(flag==true) {
				
				chain.doFilter(request, response);
			}
			else {
				
				session.setAttribute("message", "close");
				res.sendRedirect("../register.jsp");
			}
		}
		
	
		
		
		//validation logic of login data
		if(req.getRequestURI().endsWith("login")) {
			
			//getting the parameters of registration form
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			
			//email validation//
			
			
			//first level validation.
			if(email==null || email.equals("")) {
				
				flag=false;
			}
			else {
				
				//second level validation.
				email=email.trim();
				int len=email.length();
				
				if(email.endsWith("@gmail.com")) {
					
					for(int i=0;i<len-10;i++) {
						if((email.charAt(i)>='a' && email.charAt(i)<='z') || (email.charAt(i)>='A' && email.charAt(i)<='Z') || (email.charAt(i)>='0' && email.charAt(i)<='9')) {
							
						}
						else {
							
							flag=false;
							break;
						}
					}
				}
				
				else {
					
					flag=false;
				}
			}
			
			
			
			//password validation//
			
			//first level validation.
			if(password==null || password.equals("")) {
				
				flag=false;
			}
			else {
				
				//second level validation.
				password=password.trim();
				int len=password.length();
				
				if(len<8) {
					
					flag=false;
				}
				else {
					
					for(int i=0;i<len;i++) {
						if(password.charAt(i)==' ') {
							
							flag=false;
							break;
						}
					}
				}
			}
			
			
			
			//final dispatching logic.
			if(flag==true) {
				
				chain.doFilter(request, response);
			}
			else {
				
				session.setAttribute("message", "close");
				res.sendRedirect("../login.jsp");
			}
		}
		
	
	}

}
