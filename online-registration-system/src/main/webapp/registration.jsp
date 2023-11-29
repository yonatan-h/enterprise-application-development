<!DOCTYPE html>

<%@ page contentType="text/html" language="java" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<h1>Welcome, please register</h1>

	<form method="POST" action="registration-servlet">
		Name: <input type="text" name="name" required />
		<br/>
		Email: <input type="email" name="email" required/>
		<br/>
		Password: <input type="password" name="password" required/>
		<br/>

		<button>Join Us</button>
	</form>

</body>
</html>