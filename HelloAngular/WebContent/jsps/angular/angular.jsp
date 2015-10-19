<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello Angular</title>

<%@ include file='/res/common/common.jsp' %>

</head>
<body ng-app="app">
	<div>
		<p>EXPRESSION IN ANGULAR {{5 + 5 }}</p>
	</div>
	
	<div ng-controller="firstController">
		<span>{{name}}</span> <br />
		<span>{{ref}}</span>
	</div>
	
	<br />
	<div ng-controller="secondController">
		<span>{{person.name}}</span> <br />
		<span>{{person.fname}}</span>
	</div>
</body>
</html>