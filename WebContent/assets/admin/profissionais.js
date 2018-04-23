
+function ($) {

	listarProf = function() {
				var retorno =  $.get('../Profissional',{action:"listar"},function(responseJson) {
                    $(".listaProf tbody").find("tr").remove();
					
					labelMensagem.iniciar('Carregando...');
					
				for (i=0; i<responseJson.length; i++) {
					
					$(".listaProf tbody").append("<tr>"+
							  "<td>"+responseJson[i].id+"</td>"+
			                 
			                  "<td>"+responseJson[i].nome+"</td>"+
			                  "<td><a href='profissionais.editar.jsp?action=procurarId&id="+responseJson[i].id+"' class='btn btn-primary'><i class='fa fa-pencil'></i></a> <button data-id='"+responseJson[i].id+"' class='btn btn-danger excluirregistro'><i class='fa fa-trash'></i></button></td>"+
			                  "</tr>");
				}

            }).done(function() {
	  				$('.listaProf').DataTable({
	  			        "language": {
	  			            "lengthMenu": "Mostrar _MENU_ registros por páginas",
	  			            "zeroRecords": "Nenhum registro - desculpe!",
	  			            "info": "Exibindo página _PAGE_ de _PAGES_",
	  			            "infoEmpty": "Não há registros disponíveis",
	  			            "infoFiltered": "(Filtrado a partir de _MAX_ registros)"
	  			        },
	  			      "ordering": false
	  			    });
	  				
					labelMensagem.encerrar();
	
			});
				
				
				$(".listaProf tbody").on("click", ".excluirregistro", function() {
					var item = $(this);
						if(confirm("Excluir o registro?")) {
							var id = $(this).data("id");
							
							$.get('../Profissional',{action:"inativar", id: id},function(responseJson) {
								
								var table = $('.listaProf').DataTable();
								
								labelMensagem.iniciar('Excluindo...');
	//							$(".listaAdm tbody").find("tr").remove();
								
								table
						        .row( item.parents('tr') )
						        .remove()
						        .draw();
	
			            }).done(function(){
							labelMensagem.iniciar('Registro de id '+ id +' Excluido...');
	//						location.href='administradores.jsp';
						}).fail(function(){
							labelMensagem.erro('Erro ao excluir a informação de '+ id);
						})
						  .always(function() {
							  labelMensagem.encerrar();
						  });
						}
				});
//				Fim do excluir
				
	}

	inserirProf = function(){
			
		$(document).ready(function() {
			
			$.get('../especialidadeServlet',{action:"listar"},function(responseJson) {
				  
				  listaEspecialista = responseJson
					console.log(listaEspecialista);
					
					 var options = "<option>A Carregar...</option>";
					
					 options = "";
						 
			            for (x=0; x<listaEspecialista.length; x++ ) {
//			            	console.log(listaEspecialista[x]);
			            	options += '<option value="' + listaEspecialista[x].id + '">' + listaEspecialista[x].nome + '</option>';
			            }
				            
					 
					 $("#especialidadeprofissional").html(options);
					 


			        }).fail(function(data,status,xhr){


						console.log("<option>Lista não importada...</option>");


						return false;

					});

		
				   
				    $('.datanascimentoprofissional').datepicker({
				        format: 'dd-mm-yyyy',
				        maxDate: "-19Y"
				    });
				    
			                        
		

			$("#concluindoCadastroForm").submit(function() {
				
				console.log("Finalizar cadastro")
				console.log($( "#concluindoCadastroForm" ).serialize());
				
				  $('.modal-title').append(' <i class="fa fa-spinner fa-spin" aria-hidden="true"></i>');
				
				$.post('../Profissional',$( "#concluindoCadastroForm" ).serialize() ,function(responseJson) {
					
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
		
	}


//	BuscarPorId
	buscarPorId = function(id) {
				var retorno =  $.get('../Profissional',{action:"buscarPorId", id: id},function(responseProfJson) {
                   
					labelMensagem.iniciar('Carregando...');
					console.log(responseProfJson);
					
					
					
					$( ":input[name=datanascimentoprofissional]" ).val(responseProfJson.dataNascimento);
					$( ":input[name=emailprofissional]" ).val(responseProfJson.email);
					$( ":input[name=nomeprofissional]" ).val(responseProfJson.nome);
					$( ":input[name=senhaprofissional]" ).val(responseProfJson.senha);
					$( ":input[name=cpfprofissional]" ).val(responseProfJson.cpf);
					$( ":input[name=rgprofissional]" ).val(responseProfJson.rg);
					$( ":input[name=cepprofissional]" ).val(responseProfJson.endereco.cep);
					$( ":input[name=enderecoprofissional]" ).val(responseProfJson.endereco.rua);
					$( ":input[name=numeroprofissional]" ).val(responseProfJson.endereco.numero);
					$( ":input[name=bairroprofissional]" ).val(responseProfJson.endereco.bairro);
					$( ":input[name=cidadeprofissional]" ).val(responseProfJson.endereco.cidade);
					$( ":input[name=estadoprofissional]" ).val(responseProfJson.endereco.estado);
					$( ":input[name=complementoprofissional]" ).val(responseProfJson.complemento);
					$( ":input[name=senhaprofissional]" ).val(responseProfJson.telefone);
					$( ":input[name=telefoneprofissional]" ).val(responseProfJson.contatos);
					$.get('../especialidadeServlet',{action:"listar"},function(responseJson) {
						  
						  listaEspecialista = responseJson
//							console.log(listaEspecialista);
							
							 var options = "<option>A Carregar...</option>";
							
							 options = "";
								 
					            for (x=0; x<listaEspecialista.length; x++ ) {
//					            	console.log(listaEspecialista[x]);
					            	options += '<option value="' + listaEspecialista[x].id + '">' + listaEspecialista[x].nome + '</option>';
					            }
						            
							 
							 $("#especialidadeprofissional").html(options);

							$( ':input[name=especialidadeprofissional] option[value="'+responseProfJson.Especialidade.id+'"]').attr("selected", "selected");


					        }).fail(function(data,status,xhr){


								console.log("<option>Lista não importada...</option>");


								return false;

							});
								console.log("especialidade " + responseProfJson.Especialidade.id);
					
					
					
//					Enviar Editar
					$(document).ready(function() {                        
						
						$("#concluindoEditarForm").submit(function(e) {
							e.preventDefault();
							labelMensagem.iniciar('Enviando...');
							 $.post("../Profissional", $(this).serialize() ,
						                function(data){
						                    console.log(data);
						                    
						                }).done(function() {
						                	labelMensagem.iniciar('Registro enviado...');
						                	
						                	setTimeout(function(){ location.href='profissionais.jsp'; }, 2000);
						                })
						                .fail(function() {
						                  alert( "Ocorreu um erro, tente novamente" );
						                  location.refresh();
						                })
						                .always(function() {
						                	labelMensagem.encerrar();
						              });
							
						})
					              
				});
//					FimEnviarEditar
            }).done(function() {
	  				
	  				
					labelMensagem.encerrar();
	
			});
				
				
				
	}
//FimBuscarPorId
	
	
	editarProf = function(){
			
		$(document).ready(function() {                        
		
				$("#editarProfissionais").submit(function(e) {
					e.preventDefault();
					labelMensagem.iniciar('Enviando...');
					 $.post("../Profissional", $(this).serialize() ,
				                function(data){
				                    console.log(data);
				                    
				                }).done(function() {
				                	labelMensagem.iniciar('Registro enviado...');
				                	
				                	setTimeout(function(){ location.href='admin/profissionais.jsp'; }, 2000);
				                })
				                .fail(function() {
				                	
				    				
				    				console.log('Deu erro!');
				    				
				    				console.log(data);
				    				
				    				console.log(excessaoRetorno(data.status));
				    				
				    				$(".textoalert").html(excessaoRetorno(data.status));
				    				$(".alert").addClass("alert-danger").removeClass("hide").removeClass("alert-warning");
				    				$(".enviarReg").children("i").remove();
				    				$(".enviarReg").removeClass("active")
				    				
				    					$('#moralForm').modal('hide') ;
				    				
				                  location.reload();
				                })
				                .always(function() {
				                	
				                	labelMensagem.encerrar();
				              });
					
				})
			              
		});
		
	}
	
}(jQuery);