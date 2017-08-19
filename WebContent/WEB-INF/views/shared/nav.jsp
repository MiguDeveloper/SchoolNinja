<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="index.html" class="site_title">IEP Ulima</a>
        </div>

        <div class="clearfix"></div>

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <ul class="nav side-menu">
                    <li><a><i class="fa fa-home"></i> Inicio <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="resumen.jsp" data-toggle="tooltip" data-placement="right" 
                                   title="Dashboard principal">Resumen</a></li>
                        </ul>
                    </li>
                    <li>
                        <a><i class="fa fa-edit"></i> Datos Colegio <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li>
                                <a href="<c:url value='/profesor/activos' />" data-toggle="tooltip" data-placement="right" 
                                   title="Profesores: agregar, listar, eliminar">Profesores</a>
                               	<a href="<c:url value='/grado/activos' />" data-toggle="tooltip" data-placement="right" 
                                   title="Grados: agregar, listar, eliminar">Grados</a>
                                <a href="<c:url value='/tipoDocumento/activos' />" data-toggle="tooltip" data-placement="right" 
                                   title="Tipo documento: agregar, listar, eliminar">Tipo documentos</a>
                                <a href="<c:url value='/alumno/activos' />" data-toggle="tooltip" data-placement="right" 
                                   title="Alumno: agregar, listar, eliminar">Alumnos</a>
                            </li>
                            
                        </ul>
                    </li>
                    <li>
                        <a><i class="fa fa-bar-chart-o"></i> Consultas <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="<c:url value='/docpago/activos' />">Boletas y recibos registrados</a></li>    
                        </ul>
                    </li>
                    <li>
                        <a><i class="fa fa-bar-chart-o"></i> Reportes <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li>
                                <a href="../rptes/rptePagoMensualTipoDoc.htm" data-toggle="tooltip" data-placement="right" 
                                   title="Reporte de pagos por tipo de doc. venta y rango de fechas">Lista mensual de pagos registrados</a>
                            </li>
                            <li>
                                <a href="../rptes/rptePagoAnual.htm" data-toggle="tooltip" data-placement="right" 
                                   title="Reporte de pagos mes a mes de pobladores">Estado de cuenta anual pobladores</a>
                            </li>
                            <li>
                                <a href="../rptes/rptePagoMensualCoveTipoDoc.htm" data-toggle="tooltip" data-placement="right" 
                                   title="Reporte de cobros por: cove, tipo de doc. venta y rango de fechas">Recaudación mensual por cove: boletas, recibos</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a><i class="fa fa-wrench"></i> Sistema <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="sis_usuarioLst.jsp">Usuarios sistema</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            

        </div>
        <!-- /sidebar menu -->

        <!-- /menu footer buttons -->
        <div class="sidebar-footer hidden-small">
            <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
            </a>
        </div>
        <!-- /menu footer buttons -->
    </div>
</div>



<!-- top navigation -->
<div class="top_nav">
    <div class="nav_menu">
        <nav>
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="">
                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <img src="<c:url value='/resources/production/images/img.jpg'/>" alt="">Miguel Ch
                        <span class=" fa fa-angle-down"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-usermenu pull-right">
                        <li><a href="javascript:;"> Profile</a></li>
                        <li>
                            <a href="javascript:;">
                                <span class="badge bg-red pull-right">50%</span>
                                <span>Settings</span>
                            </a>
                        </li>
                        <li><a href="javascript:;">Help</a></li>
                        <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                    </ul>
                </li>

                <li role="presentation" class="dropdown">
                    <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                        <i class="fa fa-envelope-o"></i>
                        <span class="badge bg-green">6</span>
                    </a>
                    <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                        <li>
                            <a>
                                <span class="image"><img src="../resources/production/images/img.jpg" alt="Profile Image" /></span>
                                <span>
                                    <span>John Smith</span>
                                    <span class="time">3 mins ago</span>
                                </span>
                                <span class="message">
                                    Film festivals used to be do-or-die moments for movie makers. They were where...
                                </span>
                            </a>
                        </li>
                        <li>
                            <a>
                                <span class="image"><img src="../resources/production/images/img.jpg" alt="Profile Image" /></span>
                                <span>
                                    <span>John Smith</span>
                                    <span class="time">3 mins ago</span>
                                </span>
                                <span class="message">
                                    Film festivals used to be do-or-die moments for movie makers. They were where...
                                </span>
                            </a>
                        </li>
                        <li>
                            <a>
                                <span class="image"><img src="../resources/production/images/img.jpg" alt="Profile Image" /></span>
                                <span>
                                    <span>John Smith</span>
                                    <span class="time">3 mins ago</span>
                                </span>
                                <span class="message">
                                    Film festivals used to be do-or-die moments for movie makers. They were where...
                                </span>
                            </a>
                        </li>
                        <li>
                            <a>
                                <span class="image"><img src="../resources/production/images/img.jpg" alt="Profile Image" /></span>
                                <span>
                                    <span>John Smith</span>
                                    <span class="time">3 mins ago</span>
                                </span>
                                <span class="message">
                                    Film festivals used to be do-or-die moments for movie makers. They were where...
                                </span>
                            </a>
                        </li>
                        <li>
                            <div class="text-center">
                                <a>
                                    <strong>See All Alerts</strong>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
</div>
<!-- /top navigation -->
