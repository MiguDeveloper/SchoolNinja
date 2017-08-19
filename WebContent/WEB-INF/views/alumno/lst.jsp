<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Lista de Alumnos</title>
    <%@include file="../shared/css-cabecera.jsp"%>
</head>
<body class="nav-md">
    <div class="container body">
		<div class="main_container">
			<%@include file="../shared/nav.jsp"%>

			<!-- page content -->
			<div class="right_col" role="main">
		
				<!-- row -->
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							
							<c:if test="${add_exito != null}">
								<div class="alert alert-success alert-dismissible" role="alert">
									<button type="button" class="close" data-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									${add_exito}
					             </div>
							</c:if>
									
							<div class="x_title">
								<h2>Lista de Alumnos</h2>
								<div class="clearfix"></div>
							</div>
							
							<div class="x_content">
                                
                                <div class="btn-group" role="group" aria-label="...">
									<a href="./nuevo" type="button" class="btn btn-success"> <span
										class="glyphicon glyphicon-plus" aria-hidden="true"></span>
										Agregar nuevo alumno
									</a>
								</div>

								<table class="table table-hover table-striped">
									<thead>
										<th>Nombres</th>
										<th>Apellido paterno</th>
										<th>Apellido materno</th>
										<th>ID Tipo documento</th>
										<th>Tipo documento</th>
										<th>Nro de documento</th>
										<th>Fecha de nacimiento</th>
									</thead>
									<tbody>
										<c:forEach items="${lstAlumnos}" var="alumno">
											<tr>
												<td><c:out value="${alumno.nombres}" /></td>
												<td><c:out value="${alumno.ape_paterno}" /></td>
												<td><c:out value="${alumno.ape_materno}" /></td>
												<td><c:out value="${alumno.tipo_documentos_id}" /></td>
												<td><c:out value="${alumno.tipo_documento}" /></td>
												<td><c:out value="${alumno.nro_documento}" /></td>
												<td><c:out value="${alumno.fecha_nacimiento}" /></td>
												<td><a href="./edit/${alumno.id}" title="Editar">
														<span class="glyphicon glyphicon-pencil"
														aria-hidden="true"></span>
												</a> <a href="#"
													data-href="<c:url value='delete/${alumno.id}'/>"
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
				<!--  /row -->
				
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
							<a class="btn btn-danger btn-ok" title="Alumno">Eliminar</a>
						</div>
					</div>
				</div>
			</div>
			<!-- / Ventana Modal de eliminar -->

        </div>
        <!-- end main_container -->

    </div>
    <!-- end container -->

	<%@include file="../shared/js-pie.jsp"%>
</body>
</html>