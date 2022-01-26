package com.hossein.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Define The URL of Servlet
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ProfileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		request.getRequestDispatcher("links.html").include(request, response);
		
		// Get Cookies
		Cookie[] cookies = request.getCookies();
		
		// Check If There Are Any Cookies
		if (cookies != null) {
			
			// If We Have Cookies
			// Check For a Cookie Named username
			// We Could've Also Used cookies[0]
			// But We're Considering We Have Multiple Cookies
			for (Cookie c : cookies) {
				if (c.getName().equals("username")) {
					out.print("<b>Welcome To Your Profile " + c.getValue() + "</b>");
				}
			}
			
		} else {
			
			// If There Are No Cookies
			// Then Tell User To Login First
			out.print("Please Login First");
			request.getRequestDispatcher("login.html").include(request, response);
		
		}
	
		out.close();
	}

}
