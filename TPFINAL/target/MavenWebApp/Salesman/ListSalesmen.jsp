<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LISTA VENDEDORES</title>
</head>
<body>
	<table>
		<thead>
			<tr>ID</tr>
			<tr>NOME</tr>
			<tr>cidade</tr>
			<tr>COMISSÃO</tr>
		</thead>
		<c:forEach items="${salesmen}" var="salesman">
			<tr>
				<td>${salesman.salesmanId}</td>
				<td>${salesman.name}</td>
				<td>${salesman.city}</td>
				<td>${salesman.commission}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>