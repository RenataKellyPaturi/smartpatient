<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Medicamento SmartPacient</title>
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
 	<link rel="stylesheet" href="../assets/estilo.css">

<link rel="stylesheet"
	href="../assets/libs/datatable/media/css/jquery.dataTables.min.css">
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



				<a class="btn btn-success pull-right" href="medicamento.jsp"><i
					class="fa fa-arrow-left"></i> Voltar</a>

				<div class="panel panel-primary">
					<!-- Default panel contents -->
					<div class="panel-heading">Inserindo Medicamentos</div>
					<div class="panel-body">
						<form class="form-horizontal" href="../medicamentoServ"method="get" id="inserirMedicamento">
							<div class="form-group">
								<label for="nome" class="col-sm-2 control-label">Nome</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="nome" name="nome"
										placeholder="Digite o nome do Medicamento" requerid>
								</div>
							</div>
							<div class="form-group">
								<label for="descricao" class="col-sm-2 control-label">Descrição</label>
								<div class="col-sm-10">
									<textarea class="form-control" id="descricao"
										name="descricao" rows="" cols="" placeholder="Digite aqui a descrição..." required></textarea>
								</div>
							</div>
					

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="hidden" name="action" value="cadastrar">
							<button type="submit" class="btn btn-success">Salvar</button>
						</div>
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
 <script
    src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
    type="text/javascript"></script>
	<script type="text/javascript"
		src="../assets/libs/datatable/media/js/jquery.dataTables.js"></script>

	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script type="text/javascript"
		src="../assets/libs/bootstrap/js/holder.min.js"></script>
	<script type="text/javascript" src="../assets/js/labelAlert.js"></script>
	<script type="text/javascript" src="../assets/medic/medic.js"></script>
<script  type="text/javascript" src="../assets/dashboard/funcaobuscalista.js"></script>
 	
	<script>
		inserirMed();
	</script>
</body>
</html>