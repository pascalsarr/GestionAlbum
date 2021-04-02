<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
	<h1>GESTION DES UTILISATEURS</h1>
	
	<p>Bienvenue dans l'application de gestion des utilisateurs</p>
	<p>Vous pouvez ajouter un utilisateur en cliquant <a href="<c:url value='/users/add'/>">ici</a></p>
	<p>Vous pouvez également consulter la liste des utilisateurs en cliquant <a href="<c:url value='/users/list'/>">ici</a></p>
	<center><h1> Bienvenue .. <span style="color:blue"><%=session.getAttribute("name")%>.</span></h1></center>
</body>
</html>