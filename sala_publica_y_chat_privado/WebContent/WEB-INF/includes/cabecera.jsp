<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="css/fontawesome-all.min.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />



<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>


<link rel="stylesheet" href="css/index.css" />
<base href="${pageContext.request.contextPath}/" />

<title>Chatting &amp; Gnittahc</title>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<p class="navbar-brand" >CHATTING &amp; GNITTAHC </p>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
			<c:if test="${sessionScope.usuario.nombre == 'pepe'}">
				<li class="nav-item"><a class="nav-link" href="admin/listado">Admin</a></li>
				</c:if>
			</ul>
			<ul class="navbar-nav">
				<c:if test="${sessionScope.usuario != null}">
						<li class="nav-item"><span class="navbar-text"> Hola, ${usuario.nombre}  </span> 
						</li>
						<li class="nav-item"><a class="nav-link" href="logout">SALIR</a>
						</li>
				</c:if>
			</ul>
		</div>
	</nav>

