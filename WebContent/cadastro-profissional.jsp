<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SmartPacient</title>

<title>Cadastro de Profissional</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Estilos distribuição á -->
<link href="assets/libs/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets/libs/simple-line-icons/simple-line-icons.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets/libs/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets/libs/bootstrap/css/bootstrap-theme.min.css"
	rel="stylesheet" type="text/css" />

<!-- Estilo próprio -->
<link rel="stylesheet" href="assets/css/style.css">


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->


</head>
<body>

	<header>

		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"><img
						src="assets/logo/logo_smartpatient_120px.png" alt="Marca da empresa" style="height: 50px;" /></a>
				</div>
			</div>
			<!-- /.container-fluid -->
		</nav>
	</header>

	<main>


	<section id="assinatura" class="form">
		<div class="container">
			<div class="row">
				<div class="col-lg-10">

					<div class="page-content">
						<h3 class="page-title">Assinatura</h3>
						<div class="page-bar">
							<ul class="page-breadcrumb">
								<li><i class="fa fa-home"></i> <a href="">Iní­cio</a> <i
									class="fa fa-angle-right"></i></li>
								<li><a>Cadastro</a></li>
							</ul>
						</div>
					</div>
					<br>
					<br>
					<br>

					<form id="concluindoCadastroForm"
						action="Profissional" method="post"  accept-charset="UTF-8">
						<div class="form-group">
							<label>Nome</label> <input type="text" class="form-control"
								id="nomeprofissional" name="nomeprofissional" placeholder="Nome"
								value="<%= request.getParameter("nome")%>" maxlength="30">
						</div>
						<div class="form-group">
							<label>Especialidade</label> <input type="text"
								class="form-control" id="especialidadeprofissional"
								name="especialidadeprofissional"
								placeholder="especialidade profissional" value="">
						</div>
						<div class="form-group">
							<label>CPF</label> <input type="text" class="form-control"
								id="cpfprofissional" name="cpfprofissional" placeholder="CPF"
								name="cpfprofissional" maxlength="11"
								value=" <%= request.getParameter("cpf")%>">
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
								name="emailprofissional"
								value="<%= request.getParameter("email")%>">
						</div>
						<input type="hidden" name="action" value="cadastro">
						<button class="btn btn-default" type="submit" onclick="return location.href='escolha-funcionalidades.jsp'">
							<i class="fa icon-ok"></i> Continuar
						</button>
						<button class="btn btn-default" type="reset"
							onclick="return location.href='index.html'">
							<i class="icon-ok"></i> Cancelar
						</button>
						<br>
						<br>
						<br>
					</form>
				</div>
				<div class="col-lg-2">
					<br>
					<br>
					<br>
					<br>

				</div>
			</div>
		</div>
	</section>



	</main>

	<footer> </footer>

	<!-- Scripts JS -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

	<script src="assets/libs/bootstrap/js/bootstrap.min.js"
		integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
		crossorigin="anonymous"></script>
	<script src="assets/js/scripts.js"></script>

</body>
</html>