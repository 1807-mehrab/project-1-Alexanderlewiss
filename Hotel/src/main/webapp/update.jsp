<%@page import="java.sql.*"%>
<%@ page import= "com.alex.hotel.ConnectionUtil" %>

    
<%
String uName =request.getParameter("user");
String firstN =request.getParameter("first");
String lastN =request.getParameter("last");

try (Connection conn = ConnectionUtil.getConnection()){
	
	PreparedStatement ps = null;
    String sql = "UPDATE GUEST SET USER_NAME='"+uName+"',FIRST_NAME='"+firstN+"',LAST_NAME="+lastN+"' where USER_NAME='"+uName+"'";
    response.sendRedirect("userProfile.jsp");	
}
catch(Exception e){
System.out.println(e);
}

%>