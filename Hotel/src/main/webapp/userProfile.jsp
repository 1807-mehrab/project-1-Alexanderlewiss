<%@ page import="java.sql.*"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="com.alex.hotel.ConnectionUtil"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="stylea.css">
<title>User Profile</title>
<h1>Welcome to your profile page!</h1>

<nav>
	<ul>
		<li class="returnDash"><a href="Dashboard.html">Return to
				dashboard</a></li>
	</ul>

</nav>

</head>
<hr>
<body>
	

	<br>
	<br>
	<form method="post" name="form">
		<table border="1">
			<tr>
				<th>User name</th>
				<th>Password</th>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
			<%
				
				String id = request.getParameter("Ahs282");
				try (Connection conn = ConnectionUtil.getConnection()) {
					PreparedStatement ps = conn.prepareStatement("SELECT * FROM GUEST WHERE USER_NAME = ?");

					ps.setString(1, "Ahs282");
					ResultSet rs = ps.executeQuery();
			%>
			<%
				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString(1)%></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
				<td><%=rs.getString(4)%></td>
			</tr>


			<%
				}
			%>
			<%
				} catch (Exception e) {
					e.printStackTrace();
				}
			%>

		</table>
	</form>
	<hr>
	<footer>
		<p>Enchanted Escapes, Copyright &copy; 2018</p>
	</footer>
</body>
</html>



