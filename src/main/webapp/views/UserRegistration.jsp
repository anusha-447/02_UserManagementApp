<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->


<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User page</title>
</head>
<style>
.card{
width:500%;
height:auto;
}
.card-header{
background-color:#00bcd4c7;
}
.text-colr{
text-decoration-color:white;
}
.input-field{
width: 276px;
}
.span{
 font-family: "Times New Roman", Times, serif;
}
.label {
   text-align: center;
   margin-right:20px;
}

</style>
<body>


<div class="container">
<div class="row">
<div class="col-sm-2">
</div>
<div class="col-sm-6">


<div class="card" style="width: 39rem;">
  <div class="card-header text-center">
  <b class="text-colr">Registration Page</b>
  </div>
  <div class="card-body">

  <div class="row">
  <div class="col-sm-1">
</div>
<div class="col-sm-10">
<form:form action="save" method="POST"  modelAttribute="user">

<span>First Name:</span> <form:input class="input-field" type="text" path="firstName"></form:input>
<br>
<br>
<span>Last Name:</span> <form:input class="input-field" type="text" path="lastName"></form:input>
<br>
<br>
<span>Mobile No:</span> <form:input class="input-field" type="text" path="accountStatus"></form:input>
<br><br>
<span>Gender   :</span>      Male <form:radiobutton path="Gender" value="Male"/>   Female <form:radiobutton path="Gender" value="Female"/>  
   <br><br>   
    <span>DOB:</span> <form:input class="input-field" type="text" path="dob"></form:input>
    <br><br>
  <span>Email:</span> <form:input class="input-field" type="text" path="userEmail"></form:input>
<br><br>
<label>
Country  : <form:select class="input-field" path="countryId">  
        <form:option value = "NONE" label = "Select"/>
            <form:options items = "${countries}" />     
                </form:select>     
        </label> 
      
        <br><br>
State           : <form:select class="input-field" path="stateId">  
        <form:option value="Ghaziabad" label="Ghaziabad"/>  
        <form:option value="Modinagar" label="Modinagar"/>  
        <form:option value="Meerut" label="Meerut"/>  
        <form:option value="Amristar" label="Amristar"/>  
        </form:select>  
        <br><br>
City           : <form:select class="input-field" path="cityId">  
        <form:option value="Ghaziabad" label="Ghaziabad"/>  
        <form:option value="Modinagar" label="Modinagar"/>  
        <form:option value="Meerut" label="Meerut"/>  
        <form:option value="Amristar" label="Amristar"/>  
        </form:select>  
        <br><br>        
</form:form>
<input class="align-center"type="submit" value="Register">
</div>

<div class="col-sm-2">
</div>
  </div>
    
  </div>
</div>
</div>
<div class="col-sm-4">
</div>
</div>

</div>

</body>

</html>