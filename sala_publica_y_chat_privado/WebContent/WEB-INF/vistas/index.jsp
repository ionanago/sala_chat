<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<header class="container">
	<h1 class="col-9">Chat Público</h1>

</header>
<div class="container p-2 ">


	<div class=" row mx-auto">
		<div class="caja col-9">
			<ul>
				<c:forEach items="${chats}" var="chat">

					<li>${chat.nombreUsuario} : ${chat.texto}</li>

				</c:forEach>
			</ul>

		</div>
		<aside class=" lista col-3">
			<ul>
				<c:forEach items="${usuarios}" var="usuario2">
					<%-- <span>---- ${sessionScope.usuario.nombre}  :  ${usuario2.nombre} ----</span>--%>
					
					<c:if test="${sessionScope.usuario.nombre != usuario2.nombre}">
						<li><a href=""> ${usuario2.nombre}</a></li>
					</c:if>
				</c:forEach>
			</ul>

		</aside>
	</div>
	<div class="col-10 mx-auto containerform">
		<form class="form" action="/EviarChat1">
			<div class="form-group">
				<input type="text" class="form-control" id="mensaje" required="required"
					aria-describedby="mensaje" placeholder="Escriba su mensaje">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Enviar</button>
			</div>

		</form>

	</div>


</div>



<%@ include file="/WEB-INF/includes/pie.jsp"%>