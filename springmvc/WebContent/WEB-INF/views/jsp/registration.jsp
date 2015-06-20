<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
 <form:form action="process" method="post" commandName="userForm">
 	ID <form:input path="id" /> <br />
 	EMAIL <form:input path="email" /> <br />
 	<input type="submit" value="Register" />
 </form:form>
</body>
</html>