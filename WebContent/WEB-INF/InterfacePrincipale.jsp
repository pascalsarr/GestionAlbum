<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.Album"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
   
    <meta charset="UTF-8">
   
  </head>
  <body>
  
    <div class="container">
      <h1>APPLICATION</h1> 
      <h1>GESTION DES ALBUMS ET UTILISATEURS</h1>
      <nav> MENU :
        <ul class="nav nav-tabs">
          <li class="nav-item"><a class="nav-link active"  href="<c:url value='/login'/>"> ADMIN Authentification</a></li>
          <li class="nav-item"><a class="nav-link"  href="<c:url value='/UserConnect'/>"> USER Authentification </a></li>
        </ul>
      </nav>
<hr>
<ul>
	
	<li><a href="<c:url value='/album/view'/>">Voir les ALBUMS </a></li>
</ul>
<hr>
<hr>
</div>
  </body>
  </html>