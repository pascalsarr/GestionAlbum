<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
	<h1 align="center">Gestion des Albums</h1><hr>
	<form method="post"  enctype="multipart/form-data">
		<fieldset>
		    <label>Titre</label>
			<input type="text" name="titre" />
			<label>Description</label>
			<input type="text" name="description" />
			<label>Fichier</label>
			<input type="file" name="file" />
			<input type="submit" value="Ajouter">
		</fieldset>
	  </form>
</body>
</html>