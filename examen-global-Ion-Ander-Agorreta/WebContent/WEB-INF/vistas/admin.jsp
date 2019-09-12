<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table">
	<thead>
		<tr>
			<th>Titulo</th>
			<th>Autor</th>
			<th>ISBN</th>
			<th>numero imagen</th>
			<th>opciones</th>

			<th><a class="btn btn-primary" href="#" data-toggle="modal"
				data-target="#añadir" id="sfa">Añadir</a></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${libros}" var="libros">
			<tr>
				<td>${libros.titulo}</td>
				<td>${libros.autor}</td>
				<td>${libros.id}</td>
				<td>${libros.img}</td>
				<td>
					<form action="javascript:void(0);">
						<button class="btn btn-primary " data-toggle="modal"
							data-target="#modificar" onclick="editar(this,event)">Editar</button>
							<input type="hidden" value="${libros.id}" name="cabramod" id="cabramod">
					</form>
					<form action="BorrarServlet" method="post">
						<input type="hidden" value="${libros.id}" name="cabra" id="cabra">
						<p>${libros.id}</p>
						<button class="btn btn-danger ">Borrar</button>
						<%--BorrarLibroSencillo --%>

					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<div class="row">
	<form action="inicio" method="post" class="form-signin">

		<button class="btn btn-lg btn-primary btn-block" type="submit">
			Atras</button>

	</form>
</div>

<!--  añadir libro -->
<div class="modal" id="añadir">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">Añadir Libro</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<form action="AñadirServlet" method="post" class="form-signin">
					<h1 class="h3 mb-3 font-weight-normal">Introduce los datos</h1>
					<label for="titulo" class="sr-only">titulo</label> <input
						type="text" id="titulo" name="titulo" class="form-control"
						placeholder="titulo" required autofocus> <label
						for="autor" class="sr-only">autor</label> <input type="text"
						id="autor" name="autor" class="form-control" placeholder="autor"
						required autofocus> <label for="isbn" class="sr-only">isbn</label>
					<input type="number" id="isbn" name="isbn" class="form-control"
						placeholder="isbn" required autofocus> <input
						type="number" id="img" name="img" class="form-control"
						placeholder="img" required autofocus>

					<button class="btn btn-lg btn-primary btn-block" type="submit">Añadir
						Libro</button>

				</form>
			</div>

			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
			</div>

		</div>
	</div>
</div>

<!-- modificar libro -->
<div class="modal" id="modificar">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">Modificar Libro</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<form action="ModificarServlet" method="post" class="form-signin"
					id="formMod">
					<h1 class="h3 mb-3 font-weight-normal">Modifique los datos</h1>

					<div>
						<input type="text" id="titulom" name="titulom"
							class="form-control" placeholder="" autofocus>
					</div>


					<div>
						<input type="text" id="autorm" name="autorm" class="form-control"
							placeholder="" autofocus>
					</div>


					<div>
						<input type="number" id="isbnm" name="isbnm" class="form-control"
							placeholder="" autofocus>
					</div>


					<button class="btn btn-lg btn-primary btn-block" type="submit">Modificar
						Libro</button>

				</form>
			</div>

			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
			</div>

		</div>
	</div>
</div>



</body>
</html>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>