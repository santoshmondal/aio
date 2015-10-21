<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>

<%
	List<String> list = new ArrayList<String>();
	list.add("REDIFF");
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<s:action name="helloAction"  executeResult="true">
	<s:param name="req.mode">ABCD</s:param>
	
	<s:iterator var="val" value="req.msgs">
		<s:param name="req.msgs" value="#val"></s:param>
	</s:iterator>
</s:action>

</body>
</html>