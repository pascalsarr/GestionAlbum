<%@ page import="entities.Album"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
<title>Liste des ALBUMS</title>
</head>
<body>
	<h1>Liste des ALBUMS</h1>
	<c:choose>
		<c:when test="${ empty requestScope.album }">
			<p>La liste des ALBUMS est vide</p>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="0">
				<tr>
					<th>Titre</th>
					<th>Description</th>
					<th>DateCréation</th>
					<th>Image</th>
				</tr>
				<c:forEach var="album" items="${ requestScope.album }">
					<tr>
						<td>${ album.titre }</td>
						<td>${ album.description }</td>
						<td>${ album.datecreation }</td>
						<td><img src= "${ album.path }" width='60' height='60'/></td>
					</tr>
            	</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>