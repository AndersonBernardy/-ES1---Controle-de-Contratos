<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Resultado</title>
    <link href="js/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">

  </head>
<body>
    <c:forEach var="contato" items="${dao.lista}">
        ${contato.nome}, ${contato.email},
        ${contato.endereco}, ${contato.dataNascimento} 
    </c:forEach>
</body>
</html>