<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<header class=" col-12">
	<h1 class="">Libroteka</h1>

</header>

<div class="container">
	<ul class="list-group list-group-horizontal row" style="list-style:none">
		<c:forEach items="${libros}" var="item">
			<li class=" list-group-item  col-4" >
				<%-- <div class="col-3">
					<img class=" center imagen" src="img/${item.img}.jpg"
						style="height: 10rem !important;">
					<h5 class=" col-12">${item.titulo}</h5>
					<p class=" col-12">${item.autor}
					<p />
					<p class=" col-4">${item.precio}€</p>
					<p class=" col-4">${item.precioAntes}€</p>
					<p class=" col-4">-${item.descuento}%</p> 
				</div>--%>
				<div class="card" >
					<img class=" center " src="img/${item.img}.jpg"
						style="height: 25rem !important;">
					<div class="card-body">
						<h5 class="card-title">${item.titulo}</h5>
						<p class="card-text">${item.autor}</p>
						<p class=" precio card-text">${item.precio}€</p>
						<p class=" antes card-text">${item.precioAntes}€</p>
						<p class=" descuento card-text">${item.descuento}€</p>
					</div>
				</div>
			<li>
		</c:forEach>
	</ul>

</div>


<div class="container">
	<form action="adminServlet" method="post" class="form-signin">

		<button class="btn btn-lg btn-primary btn-block" type="submit">
			Administración</button>

	</form>



</div>





</body>
</html>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>