<%@ page import="entities.Utilisateur"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
<title>Liste des utilisateurs</title>
</head>
<body>
	<c:import url="inc/entete.jsp"/>
	<c:import url="inc/menu.jsp"/>
	<h1>Liste des utilisateurs</h1>
	<c:choose>
		<c:when test="${ empty requestScope.utilisateurs }">
			<p>La liste des utilisateurs est vide</p>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="0">
				<tr>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Login</th>
					<th>Password</th>
					<th colspan="2">Actions</th>
				</tr>
				<c:forEach var="utilisateur" items="${ requestScope.utilisateurs }">
					<tr>
						<td>${ utilisateur.nom }</td>
						<td>${ utilisateur.prenom }</td>
						<td>${ utilisateur.login }</td>
						<td>${ utilisateur.password }</td>
						<td><a href="update?id=${ utilisateur.id }">Modifier</a></td>
						<td><a href="delete?id=${ utilisateur.id }" onclick="return confirm('En êtes vous sûr ?')">Supprimer</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>