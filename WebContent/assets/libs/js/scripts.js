
$(function() {
	/* Verifica se ja existe o cpf na base de dados, no momento do envio do formulário
	da index, caso esteja liberado para fazer o cadastro, é enviado para o formulário mais completo
	caso não, ele da uma mensagem ao usuário
	*/
	
	$("#assinaturaPre").submit(function() {
	
		console.log("Envio do form");

		$(".enviarReg").addClass("active").append(' <i class="fa fa-spinner fa-spin" aria-hidden="true"></i>');
		var cpf, nome, email;
		
		nome = $("#nomeusuario").val();
		cpf = $("#cpfusuario").val();
		email = $("#emailusuario").val();
		
		console.log("Vai verificar o cpf " + cpf);
		console.log("Vai verificar o nome " + nome);
		console.log("Vai verificar o email " + email);
		
		$(".textoalert").removeClass("alert-danger").removeClass("active").removeClass("alert-warning").html("Registro sendo enviado... aguarde!!!");
		
		$(".alert").addClass("alert-warning").removeClass("hide");
		
		$.get('Profissional',{action:"verificarcpf", cpf: cpf, email:email},function(responseJson) {
			
				 
				$(".enviarReg").children("i").remove().removeClass("active");
				
				
				console.log("chama modal"); 
				if (responseJson[0] == "true") {
					chamaFormAssinatura();	
				
				} else {
				
					$(".textoalert").html("Cpf Inválido");
					$(".alert").addClass("alert-danger").removeClass("hide").removeClass("alert-warning");
					
				}
				
			
			return false;


        }).done(function(){
	
				console.log("done");
				return false;
				
		}).fail(function(data,status,xhr){
			
			
			console.log(data.status);
			
			console.log(excessaoRetorno(data.status));
			
			$(".textoalert").html(excessaoRetorno(data.status));
			$(".alert").addClass("alert-danger").removeClass("hide").removeClass("alert-warning");
			$(".enviarReg").children("i").remove();
			$(".enviarReg").removeClass("active")
			
			return false;
			
		});
		
		
		
		var chamaFormAssinatura = function() {
			 $('#moralForm').modal('show') ;
			 
			  var modal = $('#moralForm');
			  modal.find('.modal-title').text('Assinar Sistema');
			  
			  modal.find('.modal-body ').html('<div class="form-group">	<label>Data de Nascimento</label> <input type="text" class="form-control datanascimentoprofissional"	id="datanascimentoprofissional" name="datanascimentoprofissional" placeholder="Data de Nascimento"		value="" maxlength="30"></div><div class="form-group">	<label>Nome</label> <input type="text" class="form-control"		id="nomeprofissional" name="nomeprofissional" placeholder="Nome"		value="" maxlength="30"></div><div class="form-group">	<label>Especialidade</label> <input type="text"		class="form-control" id="especialidadeprofissional"		name="especialidadeprofissional"		placeholder="especialidade profissional" value=""></div><div class="form-group">	<label>CPF</label> <input type="text" class="form-control"		id="cpfprofissional" name="cpfprofissional" placeholder="CPF" maxlength="11"		value=""></div><div class="form-group">	<label>RG</label> <input type="text" class="form-control"		id="rgprofissional" name="rgprofissional" placeholder="RG"	maxlength="15"		value=""></div><div class="form-group">	<label>CEP</label> <input type="text" class="form-control"		id="cepprofissional" name="cepprofissional" placeholder="CEP"		name="cepprofissional"></div><div class="form-group">	<label>Endereço</label> <input type="text" class="form-control"		id="enderecoprofissional" name="enderecoprofissional"		placeholder="Endereço" name="enderecoprofissional" value=""></div><div class="form-group">	<label>Número</label> <input type="text" class="form-control"		id="numeroprofissional" name="numeroprofissional"		placeholder="Número"  value=""></div><div class="form-group">	<label>Bairro</label> <input type="text" class="form-control"		id="bairroprofissional" name="bairroprofissional"		placeholder="Bairro" name="bairroprofissional"></div><div class="form-group">	<label>Cidade</label> <input type="text" class="form-control"		id="cidadeprofissional" name="cidadeprofissional"		placeholder="Cidade" name="cidadeprofissional"></div><div class="form-group">	<label>Estado</label> <input type="text" class="form-control"		id="estadoprofissional" name="estadoprofissional"		placeholder="Estado" name="estadoprofissional"></div><div class="form-group">	<label>Complemento</label> <input type="text"		class="form-control" id="complementoprofissional"		name="complementoprofissional" placeholder="Complemento"></div><div class="form-group">	<label>Telefones</label> <input type="text" class="form-control"		id="telefoneprofissional" placeholder="Telefone"		name="telefoneprofissional"></div><div class="form-group">	<label>Email</label> <input type="email" class="form-control"		id="emailprofissional" placeholder="Email" name="emailprofissional" value=""></div><input type="hidden" name="action" value="cadastroProfissional">');
			  modal.find('#nomeprofissional').val(nome);
			  modal.find('#cpfprofissional').val(cpf);
			  modal.find('#emailprofissional').val(email);
			  
			  
				   
				    $('.datanascimentoprofissional').datepicker({
				        format: 'dd-mm-yyyy',
				        maxDate: "-19Y"
				    });
		
		}
		
		
		
		
		
		return false;
	});
	
	
	$("#concluindoCadastroForm").submit(function() {
		
		console.log("Finalizar cadastro")
		console.log($( "#concluindoCadastroForm" ).serialize());
		
		  $('.modal-title').append(' <i class="fa fa-spinner fa-spin" aria-hidden="true"></i>');
		
		$.post('Profissional',$( "#concluindoCadastroForm" ).serialize() ,function(responseJson) {
			
			console.log(responseJson)
			console.log(responseJson.id);
			console.log(responseJson.nome);
			
			console.log('Pronto!');
			

			$('#moralForm').modal('hide') ;
			$(".textoalert").html("Seu cadastro foi efetuado com sucesso!!!");
			 
			$(".alert").removeClass('alert-warning').removeClass('alert-danger').addClass("alert-success").removeClass("hide");
			$("#assinaturaPre").addClass("hide");
			 
			$('.modal-title').children('i').remove();
				
			 
			setTimeout(function(){ 
				location.href='escolha-funcionalidades.jsp?id='+responseJson.id+"&nome="+responseJson.nome; 
			}, 3000);
			
			 
		return false;


        }).done(function(){

			console.log("done");
			return false;
	}).fail(function(data,status,xhr){
		
		
		console.log('Deu erro!');
		
		console.log(data);
		
		console.log(excessaoRetorno(data.status));
		
		$(".textoalert").html(excessaoRetorno(data.status));
		$(".alert").addClass("alert-danger").removeClass("hide").removeClass("alert-warning");
		$(".enviarReg").children("i").remove();
		$(".enviarReg").removeClass("active")
		
			$('#moralForm').modal('hide') ;
		
		return false;
		
	});
		
		return false;
	});
	
});