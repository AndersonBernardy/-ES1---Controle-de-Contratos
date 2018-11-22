<%@page import="hello.ejb.HelloWorldRemote"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

javax.naming.InitialContext ic = new javax.naming.InitialContext();
HelloWorldRemote hello = (HelloWorldRemote) ic.lookup("ejb:/Hello-Web/HelloWorld!hello.ejb.HelloWorldRemote");
String sayIt = hello.sayHello("Seu Bosta");
out.println(sayIt);

%>
</body>
</html>