<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Tipo documento mantenimiento</title>
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
								<h2>${op == '../edit' ||  op == 'edit' ? 'ACTUALIZAR' :'CREAR'} GRADO</h2>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<form:form method="post" action="${op}" modelAttribute="frmTipoDoc">
									
									<c:if test="${mensaje != null}">
										<div class="alert alert-danger" role="alert">
											${mensaje}
					                    </div>
									</c:if>
                        
									<form:errors path="*" element="div" cssClass="alert alert-danger" />
	
									<form:hidden path="id"/>
									
									<form:label path="descripcion">Tipo Documento</form:label>
									<form:input path="descripcion" cssClass="form-control" />
									<form:errors path="descripcion" cssClass="text-danger"></form:errors>
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
			$("#frmTipoDccoc").validate({
				rules:{
					descripcion: {
						required: true,
						minlength: 2, 
						maxlength: 84
					},
					
				},
				messages:{
					descripcion: {
						required: 'Ingrese un nombre al grado',
						minlength: 'Nombre debe tener mínimo 2 caracteres',
						maxlength: 'Nombre debe tener máximo 84 digitos'
					}
				}
			})
		});
	</script>    
</body>
</html>