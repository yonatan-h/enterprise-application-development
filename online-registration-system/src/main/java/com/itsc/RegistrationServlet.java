package com.itsc;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


@WebServlet("/registration-servlet")
public class RegistrationServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String query = "INSERT INTO users (name, email, password) VALUES (?,?,?);";
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		
		try {
			Connection con = DBConnection.connect();
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			int rowCount = ps.executeUpdate();
			if (rowCount != 0) {
				res.sendRedirect("confirmation.jsp");	
				ps.close();
				con.close();
			}else {
				res.getWriter().println("Error: Registration Did Not Work");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Redirect to confirmation page
	}

}
