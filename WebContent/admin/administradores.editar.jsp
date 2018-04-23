<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.fafica.smartpacient.control.AdministradorService" %>
<%@ page import="br.com.fafica.smartpacient.entity.impl.Administrador" %>
<%
	if(session.getAttribute("adm") == null){
	    response.sendRedirect("login.jsp");
	}
%>
<%
	int id = Integer.parseInt(request.getParameter("id"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administrador SmartPacient</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">

<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="../assets/libs/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../assets/admin/estilo.css">

<link rel="stylesheet" href="../assets/libs/datatable/media/css/jquery.dataTables.min.css">


</head>
<body class="interno">


	<nav class="navbar navbar-fixed-top "> 
		<%@ include file="topo.jsp"%>
	</nav>
	<div class="clearfix"></div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<%@ include file="menu.jsp"%>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<a class="btn btn-success pull-right" href="administradores.jsp"><i class="fa fa-arrow-left"></i> Voltar</a>
					<div class="panel panel-primary">
						  <!-- Default panel contents -->
						  <div class="panel-heading">Modificando dados do Administrador</div>
								  <div class="panel-body">
									    <form class="form-horizontal" href="../administradorServ" method="post" id="editarAdministrador">
											<div class="form-group">
												<label for="email" class="col-sm-2 control-label">Email</label> 
												<div class="col-sm-10">
											      <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="">
											    </div>
											</div>
											<div class="form-group">
												<label for="nome" class="col-sm-2 control-label">Nome</label> 
												<div class="col-sm-10">
											      <input type="text" class="form-control" id="nome" name="nome" placeholder="Digite o nome do administrador" value="">
											    </div>
											</div>
											<div class="form-group">
												<label for="senha" class="col-sm-2 control-label">Senha</label> 
												<div class="col-sm-10">
											      <input type="password" class="form-control" id="senha" name="senha" placeholder="Digite a senha do administrador" value="">
											    </div>
											</div>
											
											<div class="form-group">
											<label for="senha" class="col-sm-2 control-label">Nível de acesso?</label> 
											    <div class="col-sm-10">
											      <select name="tipoAcesso" class="form-control">
											      <option value="restrito"  >Restrito</option>
											      <option value="completo"  >Completo</option>
											      
											      </select>
											    </div>
											  </div>
										  <div class="form-group">
										    <div class="col-sm-offset-2 col-sm-10">
										    <input type="hidden" name="action" value="atualizar">
										    <input type="hidden" name="id" value="<%=id%>">
										      <button type="submit" class="btn btn-success">Registrar</button>
										    </div>
										  </div>
											
										</form>
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

	<script type="text/javascript"
		src="../assets/libs/datatable/media/js/jquery.dataTables.js"></script>

	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script type="text/javascript"
		src="../assets/libs/bootstrap/js/holder.min.js"></script>
	<script type="text/javascript" src="../assets/js/labelAlert.js"></script>
	<script type="text/javascript" src="../assets/admin/admin.js"></script>

	<script>
	buscarPorId(<%=id%>);
	</script>
</body>
</html>