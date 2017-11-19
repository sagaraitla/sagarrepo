<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery-3.1.0.min.js"></script>
<script>
$(document).ready(function() { 
    $('#login').click(function() {
        if (!$.trim($('#uid').val())) {
            alert("textbox value can't be empty");
        }
    });
});
</script>
</head>
<body>
<form action="">
UserId:<input type="text" name="userid" id="uid"><br>
Password:<input type="password" name="password" id="pwd"><br>
<input type="button" value="login">
<input type="button" value="cancel"> 
</form>
<%-- <form:form action="">
UserId:<form:input path="userid"/><br><br>
PassWord:<form:input path="password"/><br><br>
<input type="submit" value="laogin">
<input type="submit" value="cancel">
</form:form> --%>
</body>
</html>