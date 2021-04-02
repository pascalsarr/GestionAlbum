<%@page import="entities.Album"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">

</head>
<body>
	<h1 align="center">Modification d'un Album</h1>
	<%
		Album album = (Album) request.getAttribute("album");
		if(album == null)
		{
			out.print("L'album que vous souhaitez modifier n'existe pas !");
		}
		else
		{%>
			<form method="post">
				<fieldset>
					<legend>Modification d'un Album</legend>
					<label>Titre</label>
					<input type="text" name="titre" value="<%= album.getTitre() %>"><br>
					<label>Description</label>
					<input type="text" name="description" value="<%= album.getDescription() %>"><br>
					<label>Fichier</label>
			        <input type="file" name="file" />
					<input type="submit" value="Modifier">
				</fieldset>
			</form><%
		}
	%>
</body>
</html>