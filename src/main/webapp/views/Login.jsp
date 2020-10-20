<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>

<html>

<head>
<style>
.centerrrr{
text-align: center;
}
</style>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>

<body>

<div align="center">
<h2>Please Sign in here</h2>
<br>
<br>
<font color='red' > ${INVALID}</font>
<font color='red'> ${LOCKED}</font>
<form:form action="login" method="POST"  modelAttribute="user">

<table>
 

 <tr>
<td><label>Email:</label></td>
 <td><input type="text" name="userEmail"></td>
 </tr>
 <tr>
<td><label>Password:</label></td>
 <td><input type="password" name="userPassword"></td>
 </tr>

</table>
<input type="submit" value="SignIn">
</form:form>
<a href="forgotpw">Forgot Password</a>| <a href="showPage">Sign-Up</a>
</div>
</body>
</html>