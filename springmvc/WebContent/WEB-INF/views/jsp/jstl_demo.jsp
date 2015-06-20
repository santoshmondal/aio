<%@page import="com.helloworld.pojos.Person"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<title>spring mvc</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
</head>

<%
	request.setAttribute("key", "Values of key");

	session.setAttribute("key", "Sesion Values of key");
	session.setAttribute("key1", "Sesion Values of key");
	
	List<String> list = new ArrayList<String>();
	list.add("RAJ");
	list.add("RAJ1");
	list.add("RAJ2");
	list.add("RAJ3");
	list.add("RAJ4");
	request.setAttribute("list", list);
	
	
	
	List<Person> persons=new ArrayList<Person>();
	persons.add(new Person("Ram", "ram@ram.com"));
	persons.add(new Person("Raj", "raj@raj.com"));
	persons.add(new Person("San", "san@san.com"));
	request.setAttribute("persons", persons);
	
	String str = "it,cse,ece,me,be";
	request.setAttribute("str", str);
%>


<body>
	HELLO KRRISH! ${title}
	
	<h3>Expression Language Demo</h3>	
	${key} <br />
	${requestScope.key} <br />
	${sessionScope.key1} <br />
	${pageContext.request.contextPath}
	
	
	
	<h3>URL DEMO</h3>
	<c:url value="home.jsp" var="urlref">
		<c:param name="a">abcd</c:param>
		<c:param name="b">bcd@bcd.com</c:param>
	</c:url>
	<a href="${urlref}">Hello</a>
	
	<h3>FOR LOOP DEMO</h3>
	<c:forEach var="mesasge" items="${list}" varStatus="status">
		<c:out value="message" />
		<a href="${urlref}">${status.count}</a><br />
	</c:forEach>
	
	
	<h5>FOR LOOP CUSTOM OBJECT</h5>
	<c:forEach var="person" items="${persons}" varStatus="status">
		<c:out value="${person.id}"></c:out>
		<c:out value="${person.email}"></c:out>
		
		<c:url var="u1" value="home.jsp">
			<c:param name="a" value="${person.id}" />
			<c:param name="b" value="${person.email}" />
		</c:url>
		<a href="${u1}">
			<c:out value="${person.id}"></c:out>
		</a>
		<br />
	</c:forEach>
	
	
	<h5>FOR TOKENS DEMO</h5>
	<c:forTokens items="${str}" delims="," var="s">
		<c:out value="${s}"></c:out><br />
	</c:forTokens>
	
</body>
</html>