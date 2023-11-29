package com.itsc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String query = "SELECT * FROM users WHERE email = ? AND password = ?;";
		String email = req.getParameter("email");
		String password = req.getParameter("password");


		try {
			Connection con = DBConnection.connect();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet qResults = ps.executeQuery();
			
			if (qResults.next()) {
				int id = qResults.getInt(1); 
				req.getSession().setAttribute("uid", id);
				res.sendRedirect("welcome.jsp");
			}else {
				res.sendRedirect("login.jsp");
			}
			
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
