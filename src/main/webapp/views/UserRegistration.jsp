<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>User page</title>
<script>
$(document).ready(function() {
	$("#userEmail").blur(function() {
		$("#errMsg").text("");
		 $.ajax({
				
				type : "GET",
				url : "isUniqueMail?email="+$("#userEmail").val(),
				success : function(data) {
					
						if(data=="EXISTED"){
						
							$("#errMsg").text("Duplicate Email");
							 $("#submitBtn").prop("disabled", true);
						}
						 else{
							$("#submitBtn").prop("disabled", false);
						} 
				}
				});
			
		});
	$("#countryId").change(function(){
		$('#stateId').find('option:not(:first)').remove();
		$('#cityId').find('option:not(:first)').remove();
		$.ajax({
			
			type : "GET",
			url : "countryChange?countryId="+$("#countryId").val(),
			success : function(data) {
				$.each(data, function(stateId, stateName) {
		            $('#stateId').append($('<option>').text(stateName).attr('value', stateId))
				
				 });
			}
	});
});
	$("#stateId").change(function(){
		$('#cityId').find('option:not(:first)').remove();
		$.ajax({
			type : "GET",
			url : "stateChange?stateId="+$("#stateId").val(),
			success : function(data) {
				$.each(data, function(cityId, cityName) {
		            $('#cityId').append($('<option>').text(cityName).attr('value', cityId));
		        });
			}
		});
	});
	
});
</script>
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
  <br><br>
  <div align="center">
<font color='green' >${success}</font>
<font color='red'>${fail}</font>
</div>
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
  <span >Email:</span> <form:input id="userEmail" class="input-field" type="text" path="userEmail"></form:input> <font color='red'><span  id="errMsg"></span></font> 
<br>

<br>
<label>
Country  : <form:select class="input-field" path="countryId" id="countryId">
							<form:option value="">-Select Country-</form:option>
							<form:options items="${countries}" />
						</form:select>
                    
        </label> 
      
        <br><br>
State :<form:select class="input-field" path="stateId" id="stateId">
							<form:option value="">-Select State-</form:option>
							<form:options items="${stateslist}" />
						</form:select>
        <br><br>
 City           : <form:select class="input-field" id="cityId" path="cityId">  
        <form:option value="">-Select Cities-</form:option>
							<form:options items="${cities}" />
        </form:select>  
        <br><br>       

<input class="align-center"  id="submitBtn" type="submit" value="Register">
</form:form>

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