<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
	<h1 align="center">Authentification</h1>
	<form method="post">
		<fieldset>
			<h5 align="center">Connexion</h5>
		<label for="login">	login: </label> 
		<input type="text" name="login"  value="${ utilisateur.login }"><br>
		<label for="password">	Password: </label> 	
		 <input type="password" name="password" ><br>
			
			<input type="submit" value="Se connecter">
		</fieldset>
	</form>
</body>
</html>