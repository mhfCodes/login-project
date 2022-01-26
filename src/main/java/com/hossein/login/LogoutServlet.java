package com.hossein.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LogoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		request.getRequestDispatcher("links.html").include(request, response);
		
		// Make a New Cookie
		// Name It Same As Our Login Cookie
		Cookie cookie = new Cookie("username", "");
		
		// Set It To Expire As Soon As It Gets Made
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		out.print("You Have Successfully Logged Out");
		out.close();
		
	}


}
