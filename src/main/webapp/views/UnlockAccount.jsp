<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>unlocking</title>
</head>
<body>

<div align="center">
<font color='red'> ${fail}</font>
<font color='green' > ${success }</font>
<br>
<h2>Please Unlock Here</h2>
  
<form:form action="unlockAccountUser?email=${userAcc.email}" method="POST"  modelAttribute="userAcc">
<table>
 
<tr>
<td><label>Email</label></td>
 <td>${userAcc.email}</td>
 </tr>
 <tr>
<td><label>Temporary Password</label></td>
 <td><form:input type="password" path="tempPw"></form:input></td>
 </tr>
 <tr>
<td><label>New Password</label></td>
 <td><form:input type="password" id="txtPassword" path="newPw"></form:input></td>
 </tr>
<tr>
<td><label>Confirm  Password</label></td>
 <td><form:input type="password" id="txtConfirmPassword" path="confirmPw"></form:input></td>
 </tr>
</table>
<input type="submit" id="btnSubmit"   value="Submit">


</form:form>
</div>
</body>


</html>