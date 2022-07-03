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
		<c:forEach items="${salesmen}" var="salesman">
			<tr>
				<td>${salesmen.salesmanId}</td>
				<td>${salesmen.name}</td>
				<td>${salesmen.city}</td>
				<td>${salesmen.commission}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>