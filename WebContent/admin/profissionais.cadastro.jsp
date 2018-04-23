<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("adm") == null){
	    response.sendRedirect("login.jsp");
	}
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">

<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet"
	href="../assets/libs/bootstrap/css/bootstrap.min.css">
  <link href="../assets/libs/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>

<link rel="stylesheet" href="../assets/admin/estilo.css">

<link rel="stylesheet"
	href="../assets/libs/datatable/media/css/jquery.dataTables.min.css">


  <link href="../assets/libs/bootstrap-datepicker/dist/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css"/>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  
</head>
<body class="interno">


	<nav class="navbar navbar-fixed-top "> <%@ include
		file="topo.jsp"%> </nav>
	<div class="clearfix"></div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<%@ include file="menu.jsp"%>
				</ul>

			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">



				<a href="profissionais.jsp"
					class="pull-right btn btn-success clearFix"><i
					class="fa fa-arrow-left"></i> voltar</a>
				<div class="panel panel-primary">
					<div class="panel-heading">Inserir profissional</div>
					<div class="panel-body">
						<div class="container-fluid">
							<p class="row"></p>
						



						 <form id="concluindoCadastroForm" action="return false;" class="formcadastro">
								<div class="alert hide alert-dismissible" role="alert">
			 							<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								  <div class="textoalert">
								  </div>
						        </div> 
							<div class="form-group">
								<label>Data de Nascimento</label> <input type="text"
									class="form-control datanascimentoprofissional"
									id="datanascimentoprofissional"
									name="datanascimentoprofissional"
									placeholder="Data de Nascimento" value="" maxlength="30">
							</div>
							<div class="form-group">
								<label>Nome</label> <input type="text" class="form-control"
									id="nomeprofissional" name="nomeprofissional"
									placeholder="Nome" value="">
							</div>
							<div class="form-group">
								<label>Especialidade</label> <select class="form-control"
									id="especialidadeprofissional" name="especialidadeprofissional">
								</select>
							</div>
							<div class="form-group">
								<label>CPF</label> <input type="text" class="form-control"
									id="cpfprofissional" name="cpfprofissional" placeholder="CPF"
									maxlength="11" value="">
							</div>
							<div class="form-group">
								<label>RG</label> <input type="text" class="form-control"
									id="rgprofissional" name="rgprofissional" placeholder="RG"
									maxlength="15" value="">
							</div>
							<div class="form-group">
								<label>CEP</label> <input type="text" class="form-control"
									id="cepprofissional" name="cepprofissional" placeholder="CEP"
									name="cepprofissional">
							</div>
							<div class="form-group">
								<label>Endereço</label> <input type="text" class="form-control"
									id="enderecoprofissional" name="enderecoprofissional"
									placeholder="Endereço" name="enderecoprofissional" value="">
							</div>
							<div class="form-group">
								<label>Número</label> <input type="text" class="form-control"
									id="numeroprofissional" name="numeroprofissional"
									placeholder="Número" value="">
							</div>
							<div class="form-group">
								<label>Bairro</label> <input type="text" class="form-control"
									id="bairroprofissional" name="bairroprofissional"
									placeholder="Bairro" name="bairroprofissional">
							</div>
							<div class="form-group">
								<label>Cidade</label> <input type="text" class="form-control"
									id="cidadeprofissional" name="cidadeprofissional"
									placeholder="Cidade" name="cidadeprofissional">
							</div>
							<div class="form-group">
								<label>Estado</label> <input type="text" class="form-control"
									id="estadoprofissional" name="estadoprofissional"
									placeholder="Estado" name="estadoprofissional">
							</div>
							<div class="form-group">
								<label>Complemento</label> <input type="text"
									class="form-control" id="complementoprofissional"
									name="complementoprofissional" placeholder="Complemento">
							</div>
							<div class="form-group">
								<label>Telefones</label> <input type="text" class="form-control"
									id="telefoneprofissional" placeholder="Telefone"
									name="telefoneprofissional">
							</div>
							<div class="form-group">
								<label>Email</label> <input type="email" class="form-control"
									id="emailprofissional" placeholder="Email"
									name="emailprofissional" value="">
							</div>
							<input type="hidden" name="action" value="cadastroProfissional">
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-success">Registrar</button>
								</div>
							</div>

						</form>

</div>
						<!-- Fim body painel -->
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
<script src="../assets/libs/bootstrap-datepicker/dist/js/bootstrap-datepicker.js" ></script>
  <script src="../assets/js/excessoes.js"></script>
  
	<script type="text/javascript" src="../assets/js/labelAlert.js"></script>
	<script type="text/javascript" src="../assets/admin/profissionais.js"></script>

	<script>
		inserirProf();
	</script>
</body>
</html>