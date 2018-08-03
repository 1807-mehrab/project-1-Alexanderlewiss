<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a ticket </title>
 <link type="text/css" rel="stylesheet" href="stylea.css">
</head>
<body>
 <h1> Fill out the form below to create  ticket </h1>
         
           <form action ="createT" method="post">
           <input type="USERID" name="u" placeholder="Enter your user id.">
           <input type="TOPIC" name="t" placeholder="Enter a topic.">
           <input type="MESSAGE" name="m" placeholder="Enter a message">
           <button type="submit">Create Ticket</button> 
                </form>
             

</body>
</html>