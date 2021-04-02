<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
	<h1 align="center">Gestion des Utilisateurs</h1><hr>
	<form method="post">
		<fieldset>
			<legend>Ajout d'un Utilisateur</legend>
			<label>Nom</label>
			<input type="text" name="nom">
			<label>Prénom</label>
			<input type="text" name="prenom">
			<label>Login</label>
			<input type="text" name="login">
			<label>Password</label>
			<input type="password" name="password">
			<input type="submit" value="Ajouter">
		</fieldset>
	  </form>
</body>
</html>