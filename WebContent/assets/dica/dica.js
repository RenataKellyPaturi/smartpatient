
+function ($) {

	listarDica = function() {
				var retorno =  $.get('../dicaServ',{action:"listar"},function(responseJson) {
                    $(".listaDica tbody").find("tr").remove();
					
					labelMensagem.iniciar('Carregando...');
					
				for (i=0; i<responseJson.length; i++) {
					
					$(".listaDica tbody").append("<tr>"+
							  "<td>"+responseJson[i].id+"</td>"+
			                 
			                  "<td>"+responseJson[i].titulo+"</td>"+
			                  "<td><a href='editar-dica.jsp?id="+responseJson[i].id+"' class='btn btn-primary'><i class='fa fa-pencil'></i></a> <button data-id='"+responseJson[i].id+"' class='btn btn-danger excluirregistro'><i class='fa fa-trash'></i></button></td>"+
			                  "</tr>");
				}

            }).done(function() {
	  				$('.listaDica').DataTable({
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
				
				
				$(".listaDica tbody").on("click", ".excluirregistro", function() {
					var item = $(this);
						if(confirm("Excluir o registro?")) {
							var id = $(this).data("id");
							
							$.get('../dicaServ',{action:"inativar", id: id},function(responseJson) {
								
								var table = $('.listaDica').DataTable();
								
								labelMensagem.iniciar('Excluindo...');
	//							$(".listaMed tbody").find("tr").remove();
								
								table
						        .row( item.parents('tr') )
						        .remove()
						        .draw();
	
			            }).done(function(){
							labelMensagem.iniciar('Registro de id '+ id +' Excluido...');
	//						location.href='medicamento.jsp';
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
				var retorno =  $.get('../dicaServ',{action:"procurar", id: id},function(responseJson) {
                   
					labelMensagem.iniciar('Carregando...');
					console.log(responseJson);	
				
					var importancia = responseJson.importancia;
					console.log("importancia -> " + importancia)
					if (importancia=="baixa") {
						 document.getElementById("option1").checked = true;
						 $(".impo1").addClass(" active ")
					} else if (importancia == "media") {
						document.getElementById("option2").checked = true;
						$(".impo2").addClass(" active ")
					} else if (importancia == "alta") {
						document.getElementById("option3").checked = true;
						$(".impo3").addClass(" active ")
					}
					
					
					$( ":input[name=titulo]" ).val(responseJson.titulo);
					$( ":input[name=descricao]" ).val(responseJson.descricao);
								
//					Enviar Editar
					$(document).ready(function() {                        
						
						$("#editarDica").submit(function(e) {
							e.preventDefault();
							labelMensagem.iniciar('Enviando...');
							 $.post("../dicaServ", $(this).serialize() ,
						                function(data){
						                    console.log(data);
						                    
						                }).done(function() {
						                	labelMensagem.iniciar('Registro enviado...');
						                	
						                	setTimeout(function(){ location.href='dica.jsp'; }, 2000);
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
	
	
	inserirDica = function(){
			
		$(document).ready(function() {                        
		
				$("#inserirDica").submit(function(e) {
					e.preventDefault();
					labelMensagem.iniciar('Enviando...');
					 $.post("../dicaServ", $(this).serialize() ,
				                function(data){
				                    console.log(data);
				                    
				                }).done(function() {
				                	labelMensagem.iniciar('Registro enviado...');
				                	
				                	setTimeout(function(){ location.href='dica.jsp'; }, 2000);
				                })
				                .fail(function() {
				                  alert( "Ocorreu um erro, tente novamente" );
				                  location.href='cadastro-dica.jsp';
				                })
				                .always(function() {
				                	labelMensagem.encerrar();
				              });
					
				})
			              
		});
		
	}

	editarDica = function(){
			
		$(document).ready(function() {                        
		
				$("#inserirDica").submit(function(e) {
					e.preventDefault();
					labelMensagem.iniciar('Enviando...');
					 $.post("dicaServ", $(this).serialize() ,
				                function(data){
				                    console.log(data);
				                    
				                }).done(function() {
				                	labelMensagem.iniciar('Registro enviado...');
				                	
				                	setTimeout(function(){ location.href='dica.jsp'; }, 2000);
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