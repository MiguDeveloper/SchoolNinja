<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Mamtenimiento alumno</title>
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
							<div class="x_title">
								<h2>${op == '../edit' ||  op == 'edit' ? 'ACTUALIZAR' :'CREAR'} ALUMNO</h2>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<form:form method="post" action="${op}" modelAttribute="frmAlumno">
									
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
									
									<form:label path="ape_paterno">Ape. Paterno</form:label>
									<form:input path="ape_paterno" cssClass="form-control" />
									<form:errors path="ape_paterno" cssClass="text-danger"></form:errors>
									<br>
									
									<form:label path="ape_materno">Ape. Materno</form:label>
									<form:input path="ape_materno" cssClass="form-control" />
									<form:errors path="ape_materno" cssClass="text-danger"></form:errors>
									<br>
									
									<form:label path="tipo_documentos_id">Seleccione tipo</form:label>
									<form:select path="tipo_documentos_id" cssClass="form-control">
										<form:option value="0">Seleccione</form:option>
										<form:options items="${lstTipoDocumento}" />
									</form:select>
									<form:errors path="tipo_documentos_id" cssClass="text-danger"></form:errors>
									<br>
									
									<form:label path="nro_documento">Nro. Documento</form:label>
									<form:input path="nro_documento" cssClass="form-control" />
									<form:errors path="nro_documento" cssClass="text-danger"></form:errors>
									<br>
									
									<form:label path="fecha_nacimiento">Fecha Nacimiento</form:label>
									<form:input path="fecha_nacimiento" cssClass="form-control"  onMouseOver="calendario(this)"  readonly="true"/>
									<form:errors path="fecha_nacimiento" cssClass="text-danger"></form:errors>
									<br>
									
									<input type="submit" value="${op == '../edit' ||  op == 'edit' ? 'ACTUALIZAR' :'CREAR'}" class="btn btn-success">
									<a href="#" class="btn btn-link">Cancelar</a>
								</form:form>

							</div>
						</div>
					</div>

				</div>
				<!-- /row -->
				
			</div>
			<!-- /page content -->
			
		</div>
	</div>

	<%@include file="../shared/js-pie.jsp"%>
	
	<script type="text/javascript">
		$(document).ready(function(){
			
			console.log("Estamos cargando jquery");
			 
			// Validaciones extras
	         $.validator.addMethod("valueNotEquals", function(value, element, arg){
			  return arg != value;
			 }, "Value must not equal arg.");

			 
			$("#frmAlumno").validate({
				
				rules:{
					nombres : {
						required: true,
						minlength: 2,
						maxlength: 59
					},
					ape_paterno : {
						required: true,
						minlength: 2,
						maxlength: 99,
					},
					ape_materno : {
						required: true,
						minlength: 2,
						maxlength: 99
					},
					tipo_documentos_id : {
						 valueNotEquals: "0"
					},
					fecha_nacimiento : {
						required: true
					},
					
				},
				messages:{
					nombres : {
						required: 'Ingrese el nombre del alumno',
						minlength: 'Nombre debe tener mínimo 2 caracteres',
						maxlength: 'Nombre debe tener máximo 59 digitos'
					},
					ape_paterno : {
						required: 'Ingrese el apellido paterno',
						minlength: 'Nombre debe tener mínimo 2 caracteres',
						maxlength: 'Nombre debe tener máximo 99 digitos'
					},
					ape_materno : {
						required: 'Ingrese el apellido materno',
						minlength: 'Nombre debe tener mínimo 2 caracteres',
						maxlength: 'Nombre debe tener máximo 99 digitos'
					},
					tipo_documentos_id : {
						valueNotEquals: 'Seleccione el tipo de documento'
					},
					fecha_nacimiento : {
						required: 'Seleccione la fecha de nacimiento'
					},
				
				}
			})
		});
	</script>    
</body>
</html>