<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
HOME!!	
<s:property value="name"/>


<s:url action="test123.action" var="urlRef">
	<s:param name="param1">1</s:param>
	<s:param name="param2">2</s:param>
</s:url>
<s:a href="%{#urlRef}">LINK</s:a>


<s:if test="hasFieldErrors()">
	ERROR :: 
	<s:fielderror></s:fielderror>
</s:if>	
</body>
</html>