<li><a class='list-group-item list-group-item-warning' href="./">Início</a></li>
<li ><a class='list-group-item ' href="paciente.jsp"  data-toggle="tooltip" data-placement="left" title="Tooltip on left">Paciente</a></li>
 
<li><a class='list-group-item <% if (request.getSession().getAttribute("pacienteId") == null) { out.print("disabled "); }%> ' <% if (request.getSession().getAttribute("pacienteId") != null) { %>href="retorno.jsp" <% }%>>Retorno do Paciente</a></li>
<li><a class='list-group-item <% if (request.getSession().getAttribute("pacienteId") == null) { out.print("disabled "); }%> ' <% if (request.getSession().getAttribute("pacienteId") != null) { %>href="mensagem.jsp" <% }%>>Mensagens</a></li>
<li><a class='list-group-item <% if (request.getSession().getAttribute("pacienteId") == null) { out.print("disabled "); }%> ' <% if (request.getSession().getAttribute("pacienteId") != null) { %>href="exercicio.jsp" <% }%>>Exercício</a></li>
<li><a class='list-group-item <% if (request.getSession().getAttribute("pacienteId") == null) { out.print("disabled "); }%> ' <% if (request.getSession().getAttribute("pacienteId") != null) { %>href="dica.jsp" <% }%>>Dicas</a></li>
<li><a class='list-group-item <% if (request.getSession().getAttribute("pacienteId") == null) { out.print("disabled "); }%> ' <% if (request.getSession().getAttribute("pacienteId") != null) { %>href="alimentacao.jsp" <% }%>>Alimentação</a></li>
<li><a class='list-group-item <% if (request.getSession().getAttribute("pacienteId") == null) { out.print("disabled "); }%> ' <% if (request.getSession().getAttribute("pacienteId") != null) { %>href="medicamento.jsp" <% }%>>Medicamento</a></li>
<li><a class='list-group-item <% if (request.getSession().getAttribute("pacienteId") == null) { out.print("disabled "); }%> ' <% if (request.getSession().getAttribute("pacienteId") != null) { %>href="ficha.jsp" <% }%>>Ficha Acompanhamento</a></li>
 <li class="divider"><hr></li>
 <li><a href="../logoutprof" class='list-group-item' ><i class="fa fa-sign-out"></i> Sair</a></li>