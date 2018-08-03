<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
<link type="text/css" rel="stylesheet" href="stylea.css">
<nav>
                    <ul>
                        <li class="current"><a href="hDashboard.html">Return to dashboard </a></li>
                        
                    </ul>
                    
                </nav>
</head>
<hr>
<body>

<h1>Upload a picture of the hotel room </h1>
    <form method="post" action="imgUpload"
        enctype="multipart/form-data">
        <table>
        <tr>
                <td> Select an Image    </td>
                <td> <input type = "file" name="image" size="10" required="required"/> </td>
        </tr>
        <tr>
             <td><input type="submit" value="Submit"></td>
             <td><input type="reset" value="Clear" /></td>
        </tr>     
        </table>
        </form>

</body>
</html>