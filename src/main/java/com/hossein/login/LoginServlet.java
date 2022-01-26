package com.hossein.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

// Define The URL of Servlet
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		request.getRequestDispatcher("links.html").include(request, response);
		
		// Get The Data Entered By The User
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			// Connect To The Database
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/login", "postgres", "xxxx");
			
			// Search For The username
			String sql = "SELECT * FROM users WHERE username=?";
			PreparedStatement prepStatement = connection.prepareStatement(sql);
			prepStatement.setString(1, username);
			ResultSet rs = prepStatement.executeQuery();
			
			// Check For Two Things:
			// 1- username Exists?
			// 2- if 1 is True, password is Correct?
			if (rs.next() && password.equals(rs.getString("password"))) {
				
				// If True Make a Cookie with username as its Value
				out.print("You have Successfully Logged in");
				out.print("<br>Welcome " + username);
				Cookie cookie = new Cookie("username", username);
				response.addCookie(cookie);
				
			} else {
				
				// If False, Ask User For username and password Again
				out.print("Sorry, Username or Password is incorrect");
				request.getRequestDispatcher("login.html").include(request, response);
				
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		out.close();
	}

}
