
$(function() {
	
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
		
		$(".alert").removeClass("alert-danger").addClass("alert-warning").removeClass("hide");
		
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
			  
			  modal.find('.modal-body ').html('<div class="form-group">		<span class="text-danger">*</span> <label>Data de Nascimento</label>'+
					  '<input type="text" class="form-control datanascimentoprofissional"	id="datanascimentoprofissional" name="datanascimentoprofissional" placeholder="Data de Nascimento"		value="" maxlength="30"></div>'+
					  '<div class="form-group">	<span class="text-danger">*</span> <label>Nome</label> <input type="text" class="form-control"		id="nomeprofissional" name="nomeprofissional" placeholder="Nome"	required	value="" ></div>'+
					  '<div class="form-group">	<span class="text-danger">*</span> <label>Especialidade</label> <select class="form-control"  id="especialidadeprofissional"		name="especialidadeprofissional"	required> </select></div>'+
					  '<div class="form-group">	<span class="text-danger">*</span> <label>CPF</label> <input type="text" class="form-control"		id="cpfprofissional" name="cpfprofissional" placeholder="CPF" maxlength="11"		requiredvalue=""></div>'+
					  '<div class="form-group">	<span class="text-danger">*</span> <label>RG</label> <input type="text" class="form-control"		id="rgprofissional" name="rgprofissional" placeholder="RG"	maxlength="15"		required value=""></div>'+
					  '<div class="form-group">	<span class="text-danger">*</span> <label>CEP</label> <input type="text" class="form-control"		id="cepprofissional" name="cepprofissional" placeholder="CEP"	required	name="cepprofissional"></div>'+
					  '<div class="form-group">	<span class="text-danger">*</span> <label>Endereço</label> <input type="text" class="form-control"		id="enderecoprofissional" name="enderecoprofissional"	required	placeholder="Endereço" name="enderecoprofissional" value=""></div>'+
					  '<div class="form-group">	<span class="text-danger">*</span> <label>Número</label> <input type="text" class="form-control"		id="numeroprofissional" name="numeroprofissional"	required	placeholder="Número"  value=""></div>'+
					  '<div class="form-group">	<span class="text-danger">*</span> <label>Bairro</label> <input type="text" class="form-control"		id="bairroprofissional" name="bairroprofissional"	required	placeholder="Bairro" name="bairroprofissional"></div>'+
					  '<div class="form-group">	<span class="text-danger">*</span> <label>Cidade</label> <input type="text" class="form-control"		id="cidadeprofissional" name="cidadeprofissional"	required	placeholder="Cidade" name="cidadeprofissional"></div>'+
					  '<div class="form-group">	<span class="text-danger">*</span> <label>Estado</label> <input type="text" class="form-control"		id="estadoprofissional" name="estadoprofissional"	required	placeholder="Estado" name="estadoprofissional"></div>'+
					  '<div class="form-group">	<label>Complemento</label> <input type="text"		class="form-control" id="complementoprofissional"		name="complementoprofissional" placeholder="Complemento"></div>'+
					  '<div class="form-group">	<span class="text-danger">*</span> <label>Telefones</label> <input type="text" class="form-control"		id="telefoneprofissional" placeholder="Telefone"	required	name="telefoneprofissional"></div>'+
					  '<div class="form-group">	<span class="text-danger">*</span> <label>Email</label> <input type="email" class="form-control"		id="emailprofissional" placeholder="Email" name="emailprofissional" value=""></div>'+
					  '<div class="form-group">	<span class="text-danger">*</span> <label>Senha</label> <input type="password" class="form-control"		id="senhaprofissional" placeholder="Digite uma senha" name="senhaprofissional" value="" required></div>'+
					  '<input type="hidden" name="action" value="cadastroProfissional">');
			  modal.find('#nomeprofissional').val(nome);
			  modal.find('#cpfprofissional').val(cpf);
			  modal.find('#emailprofissional').val(email);
			  
			  
			  $.get('especialidadeServlet',{action:"listar"},function(responseJson) {
				  
				  listaEspecialista = responseJson
					
					
					 var options = "<option>A Carregar...</option>";
					
					 options = "";
						 
			            for (x=0; x<listaEspecialista.length; x++ ) {
			            	console.log(listaEspecialista[x]);
			            	options += '<option value="' + listaEspecialista[x].id + '">' + listaEspecialista[x].nome + '</option>';
			            }
				            
					 
					 modal.find("#especialidadeprofissional").html(options);
					 


			        }).fail(function(data,status,xhr){


						console.log("<option>Lista não importada...</option>");


						return false;

					});

		
				   
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
		
		$('.modal-body').append(' <div id="aguarde" class="alert alert-info" role="alert"><i class="fa fa-spinner fa-spin" aria-hidden="true"></i> aguarde... cadastro sendo enviado</div>');
		$('.modal-body > div.form-group').addClass("hide");
		
		$.post('Profissional',$( "#concluindoCadastroForm" ).serialize() ,function(responseJson) {
			
			console.log(responseJson)
			console.log(responseJson.id);
			console.log(responseJson.nome);
			
			console.log('Pronto!');
			

			$('#moralForm').modal('hide') ;
			$(".textoalert").html("Seu cadastro foi efetuado com sucesso!!!");
			 
			$(".alert").removeClass('alert-warning').removeClass('alert-danger').addClass("alert-success").removeClass("hide");
			$("#assinaturaPre").addClass("hide");
			 
			$('.modal-body ').children('#aguarde').remove();
				
			 
			setTimeout(function(){ 
				location.href='index.jsp'; 
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