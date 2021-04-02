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
	<h1>GESTION ALBUM</h1>
	
	<p>Bienvenue dans la partie Gestion des Albums</p>
	<p>Vous pouvez ajouter un ALBUM en cliquant <a href="<c:url value='/album/add'/>">ici</a></p>
	<p>Vous pouvez également consulter la liste des ALBUMS en cliquant <a href="<c:url value='/album/list'/>">ici</a></p>
</body>
</html>