<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot password</title>
</head>
<body>
<div align="center">
<h2>Recover Your Password</h2>
<font color='green'>${success}</font>
 <font color='red'>${fail} </font>
<form:form action="sendPw" method="POST">
<table>
 
<tr>
<td><label>Email:</label></td>
 <td><input type="text" name="userEmail"></td>
 </tr>
 </table>
 <input type="submit" value="SUBMIT">
 </form:form>
 </div>
</body>
</html>