<%@page language="java"%>
<%@page import="java.sql.*"%>
<%@ page import= "com.alex.hotel.ConnectionUtil" %>    
<%@ page import= "com.alex.hotel.Guest"%>    

<%@page language="java"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<link type="text/css" rel="stylesheet" href="stylea.css">
<h1>Update your profile information!</h1>
</head>
<body>

 <h2>Fill out the form below to update your profile information!</h2>
<div class="form" >
    <form action="updateI" method="post">
        <input type="text" name="User_Name" placeholder="User Name">
        <input type="text" name="Pass" placeholder="Password">
        <input type="text" name="First_Name" placeholder="First Name">
        <input type="text" name="Last_Name" placeholder="Last Name">
        <input class="button" type="submit">
    </form>
</div>

</body>