<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container">
<section id="login" class="row p-3">
	<div class="container"><h1>Chat Login</h1></div>
	<form action="" method="post" class="col-6">
		<div class="form-group row">
			<div class="col-sm-10">
				<input type="text" class="form-control" id="nombre" name="nombre"
					placeholder="nombre" value="${usuarios.nombre}">
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-10">
				<input type="password" class="form-control" id="password"
					name="password" placeholder="Password">
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary">Entrar</button>
				
			</div>
		</div>
	</form>
</section>


</div>

<%@ include file="/WEB-INF/includes/pie.jsp"%>