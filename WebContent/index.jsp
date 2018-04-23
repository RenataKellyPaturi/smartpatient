<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SmartPacient</title>

<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Libs -->
  <link href="assets/libs/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
  <link href="assets/libs/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
  <link href="assets/libs/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
  <link href="assets/libs/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
  <link href="assets/libs/bootstrap-datepicker/dist/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css"/>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  
<!-- Style -->
<link rel="stylesheet" href="assets/css/style.css" type="text/css" />
<link rel="stylesheet" href="assets/css/estilo.css" type="text/css" />

</head>
<body>
<div class="compensar"></div>
<header id="topo">
<nav class="navbar navbar-fixed-top navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header page-scroll">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse" >
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand " href="#topo"><img src="assets/logo/logo_smartpatient_120px.png" alt="Marca da empresa" style="height: 50px;" /></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id=".navbar-collapse">
       
       
      <ul  class="nav navbar-nav" style="margin-left: 40px;">
          <li class="page-scroll"><a href="#topo" title="">Inicio</a></li>
          <li class="page-scroll"><a href="#sobre" title="">Sobre</a></li>
          <li class="page-scroll"><a href="#assinatura" title="">Assinatura</a></li>
          <li class="page-scroll"><a href="#contato" title="">Contato</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <b>Logar no sistema</b> 
              <span class="caret"></span>
            </a>
				<!--login-->
				<ul id="login-dp" class="dropdown-menu">
              <li>
              <div class="row">
	                <div class="col-md-12">
	              
	                  <form class="form" role="form" method="post" action="loginprof" accept-charset="UTF-8" id="login-nav">
	                    <div class="form-group">
	                       <label class="sr-only" for="exampleInputEmail2">CPF</label>
	                       <input type="text" name="cpf" class="form-control" id="cpf" placeholder="Digite seu cpf" required="">
	                    </div>
	                    <div class="form-group">
	                       <label class="sr-only" for="exampleInputEmail2">Email</label>
	                       <input type="text" class="form-control" id="email" name="email" placeholder="Endereço de Email" required="">
	                    </div>
	                    <div class="form-group">
	                       <label class="sr-only" for="exampleInputPassword2">Senha</label>
	                       <input type="password" class="form-control" id="senha" name="senha" placeholder="Digite sua senha" required="">
	                          <div class="help-block text-right">
	                            <a href="">Esqueceu a senha ?</a>
	                          </div>
	                    </div>
	                    <div class="form-group">
	                       <button type="submit" class="btn btn-primary btn-block">Entrar</button>
	                    </div>
	                    <!-- <div class="checkbox">
	                       <label>
	                          <input type="checkbox"> Permanecer na sessão
	                       </label>
	                    </div> -->
	                 </form>
	              </div>
	              <div class="bottom text-center page-scroll">
	                É Novo ? <a href="#assinatura"><b>Clique aqui!</b></a>
	              </div>
              </div>
              </li>
            </ul>
          </li>
        </ul><!--fim do ul container-->
        
         <!-- <form action="" class="navbar-form navbar-right" >  
            
        	<dir class="form-group">           	
        		<input type="text" class="form-control" placeholder="Buscar"/>
        		
        		<button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>	
        	</dir>   
              		
        </form> -->
        
       
        
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
	 	
</header>

<main>
<!-- carrossel -->
    <div class="carousel slide" data-ride="carousel">

      <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
      </ol>

      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img src="assets/img/img1.png" alt="medica aplicativo" class="fullscreen">
        </div>
        <div class="item">
          <img src="assets/img/img2.png" alt="medica prescrevendo medicamento" class="fullscreen">
        </div>
        <div class="item">
          <img src="assets/img/img3.png" alt="medica" class="fullscreen">
        </div>
      </div>

          <!-- Controls -->
      <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>

    </div>    

<!-- assinatura -->
<section id="assinatura" class="form">
<div class="container">	
	 <div class="row">	
	 <div class="alert hide alert-dismissible" role="alert">
  					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					  <div class="textoalert">
					  </div>
	        </div>
		        <div class="col-lg-8">
		          <h2><i class="icon-info-sign"></i> Assinatura</h2>
		          <form id="assinaturaPre" action="Profissional" method="post">  
		              <div class="form-group">
		                <label for="nomeusuario">CPF</label>
		                <input type="text" class="form-control" id="cpfusuario" placeholder="CPF" name="cpf" maxlength="11" required>
		              </div>    
		              <div class="form-group">
		                <label for="nomeusuario">Nome</label>
		                <input type="text" class="form-control" id="nomeusuario" placeholder="Nome" name="nome" required>
		              </div>
		              <div class="form-group">
		                <label for="emailusuario">Email</label>
		                <input type="email" class="form-control" id="emailusuario" placeholder="Email" name="email" maxlength="90"  required>
		              </div>
		              <input type="hidden" name="action" value="verificaRegistro" />
		              <button class="btn btn-default enviarReg" type="submit"><i class="icon-ok"></i> Cadastrar</button><br><br><br>
		          </form>
		        </div>
		        <div class="col-lg-4"><br><br><br><br>
		        
		            <!--  <h3><i class="icon-info-sign"></i> Falando sobre a assinatura</h3> -->
		            <p>Assine o sistema e tenha acesso a todas as funções que o auxiliará no atendimento ao seu paciente</p>
		        </div>
		     </div>
		</div>
</section>


<!-- Sobre -->  

<section id="sobre" class="sobre">
  <div class="col-sm-12">

      <div class="row m-b-lg">
        <div class="col-sm-8 col-sm-offset-2 text-center">
          <h3><strong>Sobre nós</strong></h3>
          <p>Somos uma equipe de desenvolvedores que se conheceram ainda na graduação e em conversas paralelas vieram a tona que seus pensamentos eram singulares e sincronizados. Tendo em vista o bem estar dos usuários decidiram se unir e colocar suas diferentes e também iguais habilidades para formar esta Factory.</p>
        </div>
      </div><br><br><br><br>

<div class="center" style="text-align: center">
<div class="row">
  <div class="col-md-2" style="margin-left: 60px;">
    <div class="thumbnail">
      <img class="img-circle" src="assets/img/equipe01.png" alt="...">
      <div class="caption">
        <h3>Eduarda Bastos</h3>
        <p>Desenvolvedora por profissão e Designer por paixão </p>
      </div>
    </div>
  </div>

   <div class="col-md-2">
    <div class="thumbnail">
      <img class="img-circle" src="assets/img/equipe02.png" alt="...">
      <div class="caption">
        <h3>Renata Paturi</h3>
        <p>Analista de sistemas, pensa sempre na usabilidade do sistema junto ao usuário</p>
      </div>
    </div>
  </div>

   <div class="col-md-2">
    <div class="thumbnail">
      <img class="img-circle" src="assets/img/equipe03.png" alt="...">
      <div class="caption">
        <h3>Dieggo Carrilho</h3>
        <p>Desenvolvedor e projetista de sistemas</p>
      </div>
    </div>
  </div>

   <div class="col-md-2">
    <div class="thumbnail">
      <img class="img-circle" src="assets/img/equipe04.png" alt="...">
      <div class="caption">
        <h3>Maicon Silva</h3>
        <p>Desenvolvedor que desenvolveu uma paixão com sistemas de gerenciamento de base de dados </p>
      </div>
    </div>
  </div>

   <div class="col-md-2">
    <div class="thumbnail">
      <img class="img-circle" src="assets/img/equipe05.png" alt="...">
      <div class="caption">
        <h3>Cleidson Santos</h3>
        <p>Desenvolvedor e testador, pensando sempre no que o sistema auxiliará o usuário</p>
      </div>
    </div>
  </div>
</div>
</div>
  </div>
</section>

<div class="clearfix"></div>
<!-- dicas -->  

<!-- contato -->
<section id="contato" class="form">
		<div class="container">	
			 <div class="row">	
		        <div class="col-lg-12">
		          <h2><i class="icon-info-sign"></i> Contato</h2>
		          <form>  
		              <div class="form-group">
		                <label for="nomeusuario">Nome</label>
		                <input type="text" class="form-control" id="nomeusuario" placeholder="Nome" name="nome">
		              </div>
		              <div class="form-group">
		                <label for="emailusuario">Email</label>
		                <input type="email" class="form-control" id="emailusuario" placeholder="Email" name="email">
		              </div>
		              <div class="form-group">
		                <label>Mensagem</label>
		                <textarea name="mensagem" class="form-control" rows="3" placeholder="Digite sua mensagem aqui" id="mensagem"></textarea>
		              </div>
		              <button class="btn btn-default" type="button" onclick="submitContato();"><i class="icon-ok"></i> Enviar</button><br><br><br>
		          </form>
		        </div>
		    </div>
		</div>
</section>

<!-- comentarios -->
<!-- <section class="form">
		<div class="content">
			<div class="col-md-12 ">
			<h3><i class="icon-info-sign"></i> Comentarios</h3><br><br><br>
			
			  <div class="col-md-6">
			      <div class="media">
			        <div class="media-left">
			          <a href="#">
			            <img class="img-circle" src="assets/img/coment1.png" alt="...">
			          </a>
			        </div>
			      <div class="media-body">
			        <h4 class="media-heading">Media heading</h4>
			        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Incidunt rem, sed nobis praesentium fugit, quisquam aliquam, deserunt voluptas hic, rerum et quaerat numquam labore suscipit. Obcaecati saepe facilis, esse harum.</p>
			      </div>
			      </div>
			  </div>
			
			  <div class="col-md-6"></div>
			   <div class="media">
			        <div class="media-left">
			          <a href="#">
			            <img class="img-circle" src="assets/img/coment2.png" alt="...">
			          </a>
			        </div>
			      <div class="media-body">
			        <h4 class="media-heading">Media heading</h4>
			        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Incidunt rem, sed nobis praesentium fugit, quisquam aliquam, deserunt voluptas hic, rerum et quaerat numquam labore suscipit. Obcaecati saepe facilis, esse harum.</p>
			      </div>
			      </div><br><br><br><br>
			</div>
		</div>
</section> -->

</main>
<div class="clearfix"></div>
<footer>
<!-- footer -->
<div class="footer">
<div class="container">
	<div class="row">
		<div class="copyright text-center">
			2016 © Ailuros Factory.</br>
			<img class="logo-footer" src="assets/img/logofooter.png" alt="Logo Ailuros" >
		</div>
  	</div>
	</div>
</div>	
</footer>


<div class="modal fade" id="moralForm" tabindex="-1" role="dialog" aria-labelledby="moralForm">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <form id="concluindoCadastroForm" action="return false;" class="formcadastro"> 
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">Titulo</h4>
        <small>Os campos marcados com <kbd>(*)</kbd> são obrigatórios</small>
      </div>
      <div class="modal-body">
      
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary enviarcadastro">Enviar</button>
      </div>
      </form>
    </div>
  </div>
</div>

   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
   
    
  <script src="assets/libs/bootstrap/js/bootstrap.min.js" ></script>
  
  <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
  <script src="assets/libs/bootstrap-datepicker/dist/js/bootstrap-datepicker.js" ></script>
  <script src="assets/js/excessoes.js"></script>
  <script src="assets/js/especialidadeprofissionallista.js"></script>
  <script src="assets/js/scripts.js"></script>
  <script src="assets/js/correr.js"></script>
  
</body>
</html>