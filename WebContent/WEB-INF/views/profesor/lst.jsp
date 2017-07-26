<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Lista de profesores</title>

<%@include file="../shared/css-cabecera.jsp"%>
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<%@include file="../shared/nav.jsp"%>

			<!-- page content -->
			<div class="right_col" role="main">

				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<c:if test="${add_exito != null}">
								<div class="alert alert-danger" role="alert">
									${add_exito} jbjwbdjw
					             </div>
							</c:if>
									
							<div class="x_title">
								<h2>Lista de Profesores</h2>

								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<c:if test="${not empty correcto}">
									<div class="alert alert-success alert-dismissible" role="alert">
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<c:out value="${correcto}" />
									</div>
								</c:if>
								<div class="btn-group" role="group" aria-label="...">
									<a href="./nuevo" type="button" class="btn btn-success"> <span
										class="glyphicon glyphicon-plus" aria-hidden="true"></span>
										Nuevo profesor
									</a>
								</div>

								<table class="table table-hover table-striped">
									<thead>
										<th>Nombre</th>
										<th>Ape. Paterno</th>
										<th>Ape. Materno</th>
										<th>Nro. Teléfono</th>
										<th>DNI</th>
										<th>Acciones</th>
									</thead>
									<tbody>
										<c:forEach items="${lstProfesores}" var="profesor">
											<tr>
												<td><c:out value="${profesor.nombres}" /></td>
												<td><c:out value="${profesor.ape_paterno}" /></td>
												<td><c:out value="${profesor.ape_materno}" /></td>
												<td><c:out value="${profesor.dni}"></c:out></td>
												<td><c:out value="${profesor.nro_telefono }" /></td>
												<td><a href="./edit/${profesor.id}" title="Editar">
														<span class="glyphicon glyphicon-pencil"
														aria-hidden="true"></span>
												</a> <a href="#"
													data-href="<c:url value='delete/${profesor.id}'/>"
													data-toggle="modal" data-target="#confirm-delete"
													title="eliminar"> <span
														class="glyphicon glyphicon-trash" aria-hidden="true"></span>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

							</div>
						</div>
					</div>

				</div>

			</div>
			<!-- /page content -->

			<!-- Ventana Modal de eliminar -->
			<div class="modal fade" id="confirm-delete" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Confirmar eliminar</h4>
						</div>
						<div class="modal-body">
							<p>Estás a punto de eliminar un registro, este procedimiento
								es irreversible.</p>
							<p>Quieres proceder?</p>
							<p class="debug-url"></p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Cancelar</button>
							<a class="btn btn-danger btn-ok" title="Profesor">Eliminar</a>
						</div>
					</div>
				</div>
			</div>
			<!-- / Ventana Modal de eliminar -->

		</div>
	</div>

	<%@include file="../shared/js-pie.jsp"%>
</body>
</html>