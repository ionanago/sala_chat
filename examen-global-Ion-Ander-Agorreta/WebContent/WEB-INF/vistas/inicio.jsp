<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<header class="row">
	<h1 class="col-12">Libroteka</h1>

</header>
<div class="container ">

	<div class="row">
		<div class="container-fluid">
			<ul class="list-group " style="list-style: none;   ">
				<c:forEach items="${libros}" var="item">
					<li class=" list-group-item list-inline-item col-4"
						style="">
						<div class="col-3">
							<img class=" center imagen"
								src="img/${item.img}.jpg" style="height: 10rem !important;">
							<h5 class=" col-12">${item.titulo}</h5>
							<p class=" col-12">${item.autor}<p/>
							<p class=" col-4">${item.precio}€</p>
							<del><p class=" col-4">${item.precioAntes}€</p></del>
							<p class=" col-4">-${item.descuento}%</p>
						</div>

					<li>
				</c:forEach>
			</ul>
		</div >
	</div>

	<div class="container">
		<form action="adminServlet" method="post" class="form-signin">

			<button class="btn btn-lg btn-primary btn-block" type="submit">
				Administración</button>

		</form>



	</div>

</div>




</body>
</html>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>