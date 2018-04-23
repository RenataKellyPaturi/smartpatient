<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dashboard - Nome Profissional</title>
		
		<meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- Estilos distribui��o -->
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
	 	<link rel="stylesheet" href="../assets/estilo.css">
	
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	    <!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
    
    
	</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#"><img src="assets/logo/logo_smartpatient_120px.png" alt="Marca da empresa" style="height: 50px;" /></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
       
       
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <b>Meus Dados sistema</b> <span class="caret"></span></a>

										<ul class="dropdown-menu">
											<li>
												<div class="row">
														<div class="col-md-12">
															<div class="card">
												                <canvas class="header-bg" width="250" height="70" id="header-blur"></canvas>
												                <div class="avatar">
												                    
												                </div>
												                <div class="content">
												                    <p>Nome do Profissional <br>
												                       <b>Profissão</b>
												                       
												                    </p>
												                    
												                </div>
												            </div>
															<table class="table table-user-information">
											                    <tbody>
											                      <tr>
											                        <td>Data de assinatura:</td>
											                        <td>06/23/2015</td>
											                      </tr>
											                      <tr>
											                        <td>Meu Plano Atual</td>
											                        <td>01/24/1988</td>
											                      </tr>
									                             <tr>
											                        <td>Qtd Pacientes</td>
											                        <td>123</td>
											                      </tr>
										                        <tr>
											                        <td>Meu endere�o</td>
											                        <td>avenida agamenon magalh�es, caruaru, pe</td>
											                      </tr>
											                      <tr>
											                        <td>Email</td>
											                        <td><a href="#">info@dados.com</a></td>
											                      </tr>
											                      <tr>
											                        <td>Telefone</td>
											                        <td>123-4567-890</td>
											                      </tr>
											                    </tbody>
										                  </table>
														
														</div>
		

													<div class="bottom text-center col-md-12">
														<a href="#" class="btn btn-danger col-md-12"><i class="fa fa-sign-out"></i> Sair</a>
													</div>
												</div>
											</li>
										</ul>
							</li>
							
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-level-up"></i> <b>Upgrade de plano</b> <span class="caret"></span></a>
									<ul id="login-dp" class="dropdown-menu">
										<li>
											<div class="col-md-12 ">
												<a href="#" class=" btn btn-success  col-md-12   ">Atualizar plano</a>
											</div>
										</li>
										<li>
											<div class=" col-md-12 ">
												 
												
												 
											</div>
										</li>
									</ul>
							</li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
	 


		<div class="container-fluid">
		
			<div class="col-md-12  ">
		          
		          <div class="row placeholders funcionalidadeslista">
		          
			          	<div class="col-xs-6 col-sm-3 placeholder">
			              <a class="btn btn-primary redondo" href="paciente.html" ><i class="fa fa-plus-square fa-5x "></i></a>
			              <h4>Pacientes</h4>
			              <span class="info list-group-item list-group-item-danger col-md-6">Faça o controle dos seus pacientes</span>
			            </div>
			            
			            <div class="col-xs-6 col-sm-3 placeholder">
			              <a class="btn btn-primary redondo " href="mensagem.jsp"><i class="fa fa-comments fa-5x "></i></a>
			              <h4>Mensagem Diretas</h4>
			              <span class="info list-group-item list-group-item-danger col-md-6">Enviar/receber pacientes</span>
			            </div>
			            
			            <div class="col-xs-6 col-sm-3 placeholder">
			              <a class="btn btn-primary redondo linkadoModal" data-titulo="Retorno"><i class="fa fa-calendar fa-5x "></i></a>
			              <h4>Retorno</h4>
			               <span class="info list-group-item list-group-item-danger col-md-6">Marque data de retorno para pacientes</span>
			            </div>
			     
			            <div class="col-xs-6 col-sm-3 placeholder">

			              <a class="btn btn-primary redondo linkadoModal" href="exercicio/exercicio.jsp"><i class="fa fa-bicycle fa-5x "></i></a>
			              	<h4>Exercícios</h4>
			               <span class="info list-group-item list-group-item-danger col-md-6">Defina hor�rio de exerc�cios para pacientes</span>
			            </div>
			            
			            <div class="col-xs-6 col-sm-3 placeholder">
			              <a class="btn btn-primary redondo linkadoModal" href="alimentacao/alimentacao.jsp" ><i class="fa fa-cutlery fa-5x "></i></a>
			              	<h4>Alimentação</h4>
			               <span class="info list-group-item list-group-item-danger col-md-6">Defina horário e tipo de alimentação</span>

			            </div>
			            
			            <div class="col-xs-6 col-sm-3 placeholder">
			              <a class="btn btn-primary redondo " href="medicamento/medicamento.jsp"><i class="fa fa-eyedropper fa-5x "></i></a>
			              <h4>Medicamentos</h4>
			               <span class="info list-group-item list-group-item-danger col-md-6">Marque horários para medicamentos</span>
			            </div>
			            
			            <div class="col-xs-6 col-sm-3 placeholder">
			              <a class="btn btn-primary redondo" href="enviardica/enviardica.jsp"><i class="fa fa-star-o  fa-5x "></i></a>
			              <h4>Enviar Dicas</h4>
			               <span class="info list-group-item list-group-item-danger col-md-6">Envie dicas de sa�des aos seus pacientes</span>
			            </div>
			            
			            <div class="col-xs-6 col-sm-3 placeholder">
			              <button class="btn btn-primary redondo linkadoModal" data-titulo="Estatísticas do sistema"><i class="fa fa-bar-chart fa-5x "></i></button>
			              <h4>Estatísticas do sistema</h4>
			                <span class="info list-group-item list-group-item-danger col-md-6">Obtenha estatisticas referente a tudo no sistema</span>
			            </div>
			            
		          </div>
			</div>
			
		</div>

		
		<footer class="col-md-12 clearfix row info">
			<div class="row">
				<div class="pull-right col-md-4 text-right bottom">
					Todos os direitos reservados
				</div>
			</div>
		</footer>
		
	
		<div class="modal fade" id="funcionalidadesModalMedicamento" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="exampleModalLabel">Título</h4>
		      </div>
		      <div class="modal-body">
		      <p align="center"><label>Cadastro de Medicamentos</label></p>
		        <form>
		        
		        
		          <div class="form-group">
		          <div class="modal-body">
		        
							<label>Nome</label> <input type="text" class="form-control"
								id="nomemedicamento" name="nomemedicamento" placeholder="Nome">
						</div>
		          <div class="modal-body">
                <label>Descri��o</label>
                <textarea name="mensagem" class="form-control" rows="3" placeholder="Digite aqui a descri��o" id="descricao"></textarea>
              </div>
		            
		            <div class="retorno"></div>
		          </div>
		           
		        </form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
		        <button type="button" class="btn btn-primary">Incluir</button>
		        <button type="button" class="btn btn-primary">Excluir</button>
		        <button type="button" class="btn btn-primary">Alterar</button>
		        <button type="button" class="btn btn-primary">Salvar</button>
		      </div>
		    </div>
		  </div>
		</div>
			


		<div class="modal fade" id="funcionalidadesModalDicas" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="exampleModalLabel">Título</h4>
		      </div>
		      <div class="modal-body">
		     <p align="center"><label>Enviar Dicas</label></p>
		        <form>
		          <div class="form-group">
		          
		          <div class="modal-body">
		        
							<label>Dica</label> <input type="text" class="form-control"
								id="nomedica" name="nomedica" placeholder="Dica">
						</div>
		          <div class="modal-body">
                <label>Descri��o</label>
                <textarea name="mensagem" class="form-control" rows="3" placeholder="Digite aqui a descri��o" id="descricao"></textarea>
              </div>
		            
		            <div class="retorno"></div>
		          </div>
		           
		        </form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
		        <button type="button" class="btn btn-primary">Enviar</button>
		      </div>
		    </div>
		  </div>
		</div>

	
		
		<div class="modal fade" id="funcionalidadesModalPaciente" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="exampleModalLabel">Título</h4>
		      </div>
		      <div class="modal-body">
		        <form>
		          <div class="form-group">
		            <label for="recipient-name" class="control-label">Retorno:</label>
		            <div class="retorno"></div>
		          </div>
		           
		        </form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary">Enviar</button>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="funcionalidadesModalAlimentacao" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="exampleModalLabel">Título</h4>
		      </div>
		      <div class="modal-body">
		        <form>
		          <div class="form-group">
		            <label for="recipient-name" class="control-label">Retorno:</label>
		            <div class="retorno"></div>
		          </div>
		           
		        </form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary">Enviar</button>
		      </div>
		    </div>
		  </div>
		</div>

	</div>
</footer>

<div class="modal fade" id="funcionalidadesModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">T�tulo</h4>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="control-label">Retorno:</label>
            <div class="retorno"></div>
          </div>
           
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Enviar</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="funcionalidadesModalPaciente" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">T�tulo</h4>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="control-label">Retorno:</label>
            <div class="retorno"></div>
          </div>
           
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Enviar</button>
      </div>
    </div>
  </div>
</div>



	<!-- Scripts JS -->
	<!-- <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->
		
	<script src="assets/libs/bootstrap/js/bootstrap.min.js"></script>
		<script src="assets/dashboard.js"></script>


</body>
</html>