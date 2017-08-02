<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Formulario Profesor</title>
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
							<div class="x_title">
								<h2>${op == '../edit' ||  op == 'edit' ? 'ACTUALIZAR' :'CREAR'} PROFESOR</h2>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<form:form method="post" action="${op}" modelAttribute="profesorForm">
									
									<c:if test="${existe != null}">
										<div class="alert alert-danger" role="alert">
											${existe}
					                    </div>
									</c:if>
									
									<c:if test="${mensaje != null}">
										<div class="alert alert-danger" role="alert">
											${mensaje}
					                    </div>
									</c:if>
                        
									<form:errors path="*" element="div" cssClass="alert alert-danger" />
	
									<form:hidden path="id"/>
									
									<form:label path="nombres">Nombres</form:label>
									<form:input path="nombres" cssClass="form-control" />
									<form:errors path="nombres" cssClass="text-danger"></form:errors>
									
									<br>

									<form:label path="ape_paterno">Apellido Paterno</form:label>
									<form:input path="ape_paterno" cssClass="form-control" />
									<form:errors path="ape_paterno" cssClass="text-danger"></form:errors>
									<br>
									
									<form:label path="ape_materno">Apellido Materno</form:label>
									<form:input path="ape_materno" cssClass="form-control" />
									<form:errors path="ape_materno" cssClass="text-danger"></form:errors>
									<br>
									
									<form:label path="dni">DNI</form:label>
									<form:input path="dni" cssClass="form-control" />
									<form:errors path="dni" cssClass="text-danger"></form:errors>
									<br>
									
									<form:label path="nro_telefono">Teléfono</form:label>
									<form:input path="nro_telefono" cssClass="form-control" />
									<form:errors path="nro_telefono" cssClass="text-danger"></form:errors>
									<br>
				
									<input type="submit" value="${op == '../edit' ||  op == 'edit' ? 'ACTUALIZAR' :'CREAR'}" class="btn btn-success">
									<a href="#" class="btn btn-link">Cancelar</a>
								</form:form>

							</div>
						</div>
					</div>

				</div>

			</div>
			<!-- /page content -->
		</div>
	</div>

	<%@include file="../shared/js-pie.jsp"%>
	
	<script type="text/javascript">
		$(document).ready(function(){
			console.log("Estamos cargando jquery");
			$("#profesorForm").validate({
				
				rules:{
					nombres: {required: true},
					ape_paterno: {required: true},
					ape_materno: {required: true},
					dni: {required: true, number: true, maxlength: 8, minlength: 8}
				},
				messages:{
					nombres: {required:'Ingrese el nombre del profe'},
					ape_paterno: {required: 'Ingrese el apellido paterno'},
					ape_materno: {required: 'Ingrese el apellido materno'},
					dni: {
						required: 'ingrese el número de DNI',
						number: 'Ingrese números',
						minlength: 'DNI debe tener 8 digitos',
						maxlength: 'DNI máximo 8 digitos'
					}
				}
			})
		});
	</script>
	
</body>
</html>