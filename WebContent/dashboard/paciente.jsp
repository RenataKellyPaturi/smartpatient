<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="br.com.fafica.smartpacient.control.PacienteService" %>
    <%@ page import="br.com.fafica.smartpacient.entity.impl.Paciente" %>
    <%@ page import="java.util.ArrayList" %>
	<%@ page import="java.util.List" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Paciente SmartPacient</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">

<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="../assets/libs/bootstrap/css/bootstrap.min.css">
 	<link rel="stylesheet" href="../assets/estilo.css">

<link rel="stylesheet" href="../assets/libs/datatable/media/css/jquery.dataTables.min.css">

<link
    href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
    rel="stylesheet" type="text/css" />
    
   
</head>
<body class="interno">


	<%@ include file="topo.jsp"%>
	<div class="clearfix"></div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<%@ include file="menu.jsp"%>
				</ul>

			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				


<a class="btn btn-success pull-right" href="cadastro-paciente.jsp"><i class="fa fa-plus"></i> Inserir Paciente</a>
			 
				<div class="panel panel-primary">
				  <!-- Default panel contents -->
				  <div class="panel-heading">Lista de Pacientes</div>
				  <div class="panel-body">
				   
				 
				
					  <!-- Table -->
					   
						<table class="table table-striped listaMed">
							<thead>
								<tr>
									<th class="col-md-1">#</th>
									
									<th>Nome</th>
									<th class="col-md-2">Ação</th>
								</tr>
							</thead>
							<tbody>
							<%
						
						PacienteService pa = new PacienteService();
						List<Paciente> pacientes = pa.listAllActive();
						
						if (pacientes.size() != 0) {
							for (Paciente p : pacientes) {
							%>
								<tr>
									<td><%=p.getId() %></td>	
									<td><%=p.getNome() %></td>
									<td>
										<a href="editar-paciente.jsp?id=<%=p.getId() %>" class="btn btn-success "> 
											<i class="fa fa-edit"></i> 
										</a>
										
										<a href="../paciente?action=inativar&id=<%=p.getId() %>" onclick="return confirm('Deseja realmente excluir?')" class="btn btn-danger "> 
											<i class="fa fa-trash"></i> 
										</a>
									</td>
								</tr>
								<%
							} 
						} else {
							%>
							<tr>
								<td></td>
								<td>Nenhum Registro cadastrado</td>
								<td></td>
								<td></td>
							</tr>
						<%							
						}
						%>
							</tbody>
						</table>
					 
					
					 </div>
				</div>
				
			</div>
		</div>
	</div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- jQuery 2.2.1 -->
	<script type="text/javascript" src="../assets/js/jquery-2.2.1.min.js"></script>
	<script type="text/javascript"
		src="../assets/libs/bootstrap/js/bootstrap.min.js"></script>
 <script
    src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
    type="text/javascript"></script>
	<script type="text/javascript"
		src="../assets/libs/datatable/media/js/jquery.dataTables.js"></script>

	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script type="text/javascript"
		src="../assets/libs/bootstrap/js/holder.min.js"></script>
	<script type="text/javascript" src="../assets/js/labelAlert.js"></script>
	<script  type="text/javascript" src="../assets/dashboard/funcaobuscalista.js"></script>
 	
</body>
</html>