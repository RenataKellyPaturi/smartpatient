<%
if(session.getAttribute("prof") == null){
	    response.sendRedirect("../index.jsp");
	}
%>
<nav class="navbar navbar-fixed-top  navbar-default "> 
	<div class="container-fluid clearfix">
			<a class="navbar-brand clearfix" href="./"><img src="../assets/logo/logo_smartpatient_120px.png" class="imglogo"></a>
      
			<div id="navbar" class="navbar-form navbar-right">
	          
	          <div class="espacoclienteseleciona">
	           <div class="navbar-form form-group-lg">
                    
                     <div class="input-group">
				      <div class="input-group-addon destaquelabelselecionapaciente">Selecionar Paciente</div>
				    <input type="text" name="pacientebusca" class="form-control input-lg" id="pacientebusca" placeholder="busque o paciente a ser atendido...">
				      
				    </div>
                </div> 
				    
	          </div>

	        </div>         
      </div>
</nav>