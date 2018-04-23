<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="br.com.fafica.smartpacient.control.PacienteService"%>
<%@ page import="br.com.fafica.smartpacient.entity.impl.Paciente"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>

<%	int id = Integer.parseInt(request.getParameter("id"));

	PacienteService control = new PacienteService();
	Paciente p = control.listForId(String.valueOf(id));
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Editar Paciente- SmartPacient</title>

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


  <link href="../assets/libs/bootstrap-datepicker/dist/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css"/>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  
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
				


<a class="btn btn-success pull-right" href="paciente.jsp"><i class="fa fa-arrow-left"></i> voltar</a>
			 
				<div class="panel panel-primary">
				  <!-- Default panel contents -->
				  <div class="panel-heading">Paciente</div>
						  <div class="panel-body">
						   
							 <form id="editarPaciente"
									action="../paciente" method="POST"  accept-charset="UTF-8">
										<div class="form-group">
											<label>Nome</label> <input type="text" class="form-control"
												id="nomepaciente" name="nomepaciente" placeholder="Nome"
												value="<%=p.getNome() %>" maxlength="50">
										</div>
										
										<div class="form-group">
											<label>RG</label> <input type="text" class="form-control"
												id="rgpaciente" name="rgpaciente" placeholder="RG"
												value=" <%=p.getRg()%>">
										</div>
										<div class="form-group">
											<label>CPF</label> <input type="text" class="form-control"
												id="cpfpaciente" name="cpfpaciente" placeholder="CPF"
												 maxlength="14"
												value="<%= p.getCpf()%>">
										</div>
										<div class="form-group">
										 <%
										 
										 String[] datamontada = p.getDataNascimento().toString().split("-");
										 
										 %>
											<label>Data Nascimento</label> <input type="text" class="form-control data"
												id="datanascimento" name="datanascimento" placeholder="Data Nascimento"
												value="<%=datamontada[2]%>-<%=datamontada[1]%>-<%=datamontada[0]%>">
										</div>
										<div class="form-group">
											<label>CEP</label> <input type="text" class="form-control"
												id="ceppaciente" name="ceppaciente" placeholder="CEP"
												value="<%=p.getEndereco().getCep() %>"
												>
										</div>
										<div class="form-group">
											<label>Rua</label> <input type="text" class="form-control"
												id="ruapaciente" name="ruapaciente"
												placeholder="Rua" value="<%=p.getEndereco().getRua() %>">
										</div>
										<div class="form-group">
											<label>Bairro</label> <input type="text" class="form-control"
												id="bairropaciente" name="bairropaciente"
												placeholder="Bairro" 
												value="<%=p.getEndereco().getBairro() %>">
										</div>
				
										<div class="form-group">
											<label>Cidade</label> <input type="text" class="form-control"
												id="cidadepaciente" name="cidadepaciente"
												placeholder="Cidade"
												value="<%=p.getEndereco().getCidade() %>" >
										</div>
										<div class="form-group">
											<label>Estado</label> <input type="text" class="form-control"
												id="estadopaciente" name="estadopaciente"
												placeholder="Estado" value="<%=p.getEndereco().getEstado()%>" >
										</div>
										<div class="form-group">
											<label>Nº</label> <input type="text" class="form-control"
												id="numeropaciente" name="numeropaciente"
												placeholder="Numero" value="<%=p.getEndereco().getNumero() %>" >
										</div>
										<div class="form-group">
											<label>Complemento</label> <input type="text"
												class="form-control" id="complementopaciente"
												name="complementopaciente" placeholder="Complemento"
												value="<%=p.getEndereco().getComplemento()%>">
										</div>
										<div class="form-group">
											<label>Contatos</label> <input type="text" class="form-control"
												id="contatopaciente" placeholder="Digite os contatos do paciente"
												name="contatopaciente"  value="<%= p.getContatos()%>">
										</div>
										<div class="form-group">
											<label>Email</label> <input type="email" class="form-control"
												id="emailpaciente" placeholder="Email"
												name="emailpaciente"
												value="<%= p.getEmail()%>">
										</div>
										<div class="form-group">
												<div class="col-md-4">
												  
												    <label>
												    <strong>Deseja alterar sua senha? </strong>
												      <input id="alterarsenha" type="checkbox"  name="alterarsenha" onchange="document.getElementById('senhapaciente').disabled = !this.checked; document.getElementById('senhapaciente').value=''">
												      <span class="lever"></span>
												      Sim
												    </label>
												</div>
												<div class="col-md-8">
												
														<label>Senha</label> <input type="password" class="form-control"
															id="senhapaciente" placeholder="Senha"
															name="senhapaciente" value="<%=p.getSenha()%>" disabled>
												</div>
										</div>
										<div class="form-group">
										
										</div>
										<input type="hidden" name="action" value="atualizar">
										<div class="form-group">
								    <div class="col-sm-offset-2 col-sm-10">
								    <input type="hidden" name="id" value="<%=id%>">
								      <button type="submit" class="btn btn-success">Salvar</button>
								    </div>
								  </div>
										<br>
										<br>
										<br>
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
		<script src="../assets/libs/bootstrap-datepicker/dist/js/bootstrap-datepicker.js" ></script>
		<script  type="text/javascript" src="../assets/dashboard/funcaobuscalista.js"></script>
 	
	<script type="text/javascript" src="../assets/js/labelAlert.js"></script>
	<script>

	    $('.data').datepicker({
	        format: 'dd-mm-yyyy',
	        maxDate: "-19Y"
	        
	    });
    
	</script>
</body>
</html>