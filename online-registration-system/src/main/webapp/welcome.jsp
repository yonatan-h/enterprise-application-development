<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.itsc.DBConnection" %>
<%@ page import="java.sql.*" %>
<% 
	Connection con = DBConnection.connect();
	String query = "SELECT id, name, email, password FROM users WHERE id=?;";
	PreparedStatement ps = con.prepareStatement(query);

	Object id =  request.getSession().getAttribute("uid");
	String name = null;
	String email = null;
	String password = null;
			
	
	if (id != null){
		ps.setInt(1, (Integer) id);

		ResultSet rs = ps.executeQuery();

		rs.next();
		name = rs.getString(2);
		email = rs.getString(3);
		password = rs.getString(4);
	}

%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome <%= name %></title>
</head>
<body>

<%@ include file="header.jsp" %>

	<h1>Welcome <%= name %></h1>
	<p>Your id is '<%= id %>'</p>
	<p>Your email is '<%= email %>'</p>
	<p>Your password is '<%= password %>'</p>


</body>
</html>
