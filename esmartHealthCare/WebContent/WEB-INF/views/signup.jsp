
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<core:url value="/resources/js/dept.js" />"></script>
<script type="text/javascript">
var path = '${pageContext.request.contextPath}';

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- <form action="/savedepartmet">
First Name<span style= "color:red" >*</span>:<input type="text" name="firstname"><br>
Middile Name:<input type="text" name="lastname"><br>
Last Name<span style= "color:red" >*</span>:<input type="text" name="lastname"><br>
Email<span style= "color:red" >*</span>:<input type="text" name="email"><br>
UserId<span style= "color:red" >*</span>:<input type="text" name="userid"><br>
Password<span style= "color:red" >*</span>:<input type="password" name="pwd"><br>
MobileNumber<span style= "color:red" >*</span>:<input type="text" name="mnumber"><br>
Gender<span style= "color:red" >*</span>:<input type="radio" name="radioValue" checked="checked">male<input type="radio" name="radioValue">female<br>
Department:<select style="width:300px">
<option>${deptList}</option>
</select>
<core:forEach items="${deptList}" var="deptbean">
<option>${deptbean.getDeptName()}</option>
</core:forEach></select><br>
<input type="checkbox" name="chbox"><span>accept terms and conditions</span><br>
<input type="submit" value="Submit"/>
<input type="submit" value="Cancel"/>

</form> --%>
<form:form action="signupPage" commandName="signup" method="POST">
First Name<form:input path="firstname"/>
<form:errors path="firstname"/>
<br>
Middile Name:<form:input path="middlename"/><br>
Lastname<form:input path="lastname"/><br>
Email<form:input path="email"/><br>
User Id<form:input path="userid"/><br>
Password<form:input path="password"/><br>
Mobile No<form:input path="mobilenumber"/><br>
<form:radiobutton path="gender"  value="male"/>Male
<form:radiobutton path="gender" value="female"/>Female<br>

role:<form:select path="role" id="roleId" ><br>
<form:option value="-" label="--Select role--"/>
<form:options items="${roleList}"/>
</form:select><br><br>

<%-- department:<form:select path="department" id="deptId"><br>
<form:option value="-" label="--Select detp--"/>
<form:options items="${deptList}"/>
</form:select> --%>
<%-- <core:choose>
  <core:when test="${condition1}">
    ...
  </core:when>

  <c:otherwise>
    ...
  </c:otherwise>
</core:choose> --%>
<label id="lableId"></label><div id="deptId"></div>
<form:checkbox path="acceptTerm" value="accept terms and conditions" />accept terms and conditions<br>
<input type="submit" value="Submit"/>
<input type="submit" value="Cancel"/><br><br><br><br>
<div style="color: green">
${message}
</div>
</form:form>
</body>
</html>