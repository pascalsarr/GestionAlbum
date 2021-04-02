<%@page import="entities.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">

</head>
<body>
	<%@include file="inc/entete.jsp" %>
	<%@include file="inc/menu.jsp" %>
	<h1 align="center">Modification d'un utilisateur</h1>
	<%
		Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
		if(utilisateur == null)
		{
			out.print("L'utilisateur que vous souhaitez modifier n'existe pas !");
		}
		else
		{%>
			<form method="post">
				<fieldset>
					<legend>Modification d'un utilisateur</legend>
					<label>Nom</label>
					<input type="text" name="nom" value="<%= utilisateur.getNom() %>"><br>
					<label>Prénom</label>
					<input type="text" name="prenom" value="<%= utilisateur.getPrenom() %>"><br>
					<label>Login</label>
					<input type="text" name="login" value="<%= utilisateur.getLogin() %>"><br>
					<label>Password</label>
					<input type="password" name="password"  value="<%= utilisateur.getPassword() %>"><br>
					<input type="submit" value="Modifier">
				</fieldset>
			</form><%
		}
	%>
</body>
</html>