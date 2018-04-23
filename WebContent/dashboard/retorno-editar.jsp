<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="br.com.fafica.smartpacient.control.PacienteService" %>
    <%@ page import="br.com.fafica.smartpacient.entity.impl.Paciente" %>
    <%@ page import="java.util.ArrayList" %>
	<%@ page import="java.util.List" %>
    
    <%@ page import="br.com.fafica.smartpacient.control.RetornoService" %>
    <%@ page import="br.com.fafica.smartpacient.entity.impl.Retorno" %>
    
    <%@ page import="java.util.ArrayList" %>
	<%@ page import="java.util.List" %>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	
	RetornoService controladorRetorno = new RetornoService();
	Retorno retorno = null;
	retorno = controladorRetorno.listForId(request.getParameter("id"));
	
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Retorno do Paciente- SmartPacient</title>
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
				


<a class="btn btn-success pull-right" href="retorno-cadastro.jsp"><i class="fa fa-plus"></i> Cadastrar nova data</a>
			 
				<div class="panel panel-primary">
				  <!-- Default panel contents -->
				  <div class="panel-heading">Data de Retorno do Paciente</div>
				  <div class="panel-body">
				   
				 <form class="form-horizontal" action="../RetornoServlet" method="post" id="inserirMensagem">
					<%
												 
					 String[] datamontada = retorno.getData().toString().split("-");
					 
					%>
				
					<div class="form-group">
						<label for="nome" class="col-sm-2 control-label">Data</label> 
						<div class="col-sm-10">
					      <input type="text" class="form-control data" value="<%=datamontada[2]%>-<%=datamontada[1]%>-<%=datamontada[0]%>" id="data" name="data" placeholder="Escolha a data de retorno">
					    </div>
					</div>
					<div class="form-group">
						<label for="mensagem" class="col-sm-2 control-label">Horário</label> 
						<div class="col-sm-10">
					      <input type="text" class="form-control " value="<%=retorno.getHorario() %>" name="horario" id="horario" placeholder="Digite o horário no formato: hh:mm">
					    </div>
					</div>
					
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				    <input type="hidden" name="id" value="<%=retorno.getId() %>">
				    <input type="hidden" name="paciente" value="<%=request.getSession().getAttribute("pacienteId").toString()%>">
				    <input type="hidden" name="action" value="atualizar">
				      <button type="submit" class="btn btn-success">Salvar</button>
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
		<script src="../assets/libs/bootstrap-datepicker/dist/js/bootstrap-datepicker.js" ></script>
		
	<script type="text/javascript" src="../assets/js/labelAlert.js"></script>
	<script  type="text/javascript" src="../assets/dashboard/funcaobuscalista.js"></script>
 	
	<script>

	    $('.data').datepicker({
	        format: 'dd-mm-yyyy',
	        maxDate: "-19Y"
	    });
    
	</script>
</body>
</html>