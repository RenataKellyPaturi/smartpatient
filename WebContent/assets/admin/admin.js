
+function ($) {

	listarAdm = function() {
				var retorno =  $.get('../administradorServ',{action:"listar"},function(responseJson) {
                    $(".listaAdm tbody").find("tr").remove();
					
					labelMensagem.iniciar('Carregando...');
					
				for (i=0; i<responseJson.length; i++) {
					
					$(".listaAdm tbody").append("<tr>"+
							  "<td>"+responseJson[i].id+"</td>"+
			                 
			                  "<td>"+responseJson[i].nome+"</td>"+
			                  "<td><a href='administradores.editar.jsp?id="+responseJson[i].id+"' class='btn btn-primary'><i class='fa fa-pencil'></i></a> <button data-id='"+responseJson[i].id+"' class='btn btn-danger excluirregistro'><i class='fa fa-trash'></i></button></td>"+
			                  "</tr>");
				}

            }).done(function() {
	  				$('.listaAdm').DataTable({
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
				
				
				$(".listaAdm tbody").on("click", ".excluirregistro", function() {
					var item = $(this);
						if(confirm("Excluir o registro?")) {
							var id = $(this).data("id");
							
							$.get('../administradorServ',{action:"inativar", id: id},function(responseJson) {
								
								var table = $('.listaAdm').DataTable();
								
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

	
//	BuscarPorId
	buscarPorId = function(id) {
				var retorno =  $.get('../administradorServ',{action:"buscarPorId", id: id},function(responseJson) {
                   
					labelMensagem.iniciar('Carregando...');
//					console.log(responseJson);
				
					$( ":input[name=email]" ).val(responseJson.email);
					$( ":input[name=nome]" ).val(responseJson.nome);
					$( ":input[name=senha]" ).val(responseJson.senha);
					$( ':input[name=tipoAcesso] option[value="'+responseJson.tipoAcesso+'"]').attr("selected", "selected");
					
//					Enviar Editar
					$(document).ready(function() {                        
						
						$("#editarAdministrador").submit(function(e) {
							e.preventDefault();
							labelMensagem.iniciar('Enviando...');
							 $.post("../administradorServ", $(this).serialize() ,
						                function(data){
						                    console.log(data);
						                    
						                }).done(function() {
						                	labelMensagem.iniciar('Registro enviado...');
						                	
						                	setTimeout(function(){ location.href='administradores.jsp'; }, 2000);
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
	
	
	inserirAdm = function(){
			
		$(document).ready(function() {                        
		
				$("#inserirAdministrador").submit(function(e) {
					e.preventDefault();
					labelMensagem.iniciar('Enviando...');
					 $.post("../administradorServ", $(this).serialize() ,
				                function(data){
				                    console.log(data);
				                    
				                }).done(function() {
				                	labelMensagem.iniciar('Registro enviado...');
				                	
				                	setTimeout(function(){ location.href='administradores.jsp'; }, 2000);
				                })
				                .fail(function() {
				                  alert( "Ocorreu um erro, tente novamente" );
				                  location.href='administradores.cadastro.jsp';
				                })
				                .always(function() {
				                	labelMensagem.encerrar();
				              });
					
				})
			              
		});
		
	}

	editarAdm = function(){
			
		$(document).ready(function() {                        
		
				$("#inserirAdministrador").submit(function(e) {
					e.preventDefault();
					labelMensagem.iniciar('Enviando...');
					 $.post("administradorServ", $(this).serialize() ,
				                function(data){
				                    console.log(data);
				                    
				                }).done(function() {
				                	labelMensagem.iniciar('Registro enviado...');
				                	
				                	setTimeout(function(){ location.href='admin/administradores.jsp'; }, 2000);
				                })
				                .fail(function() {
				                  alert( "Ocorreu um erro, tente novamente" );
				                  location.reload();
				                })
				                .always(function() {
				                	
				                	labelMensagem.encerrar();
				              });
					
				})
			              
		});
		
	}
	
}(jQuery);