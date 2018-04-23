+function ($) {

	listarAlimentacao = function() {
				var retorno =  $.get('../alimentacaoServ',{action:"listar"},function(responseJson) {
                    $(".listaAlimentacao tbody").find("tr").remove();
					
					labelMensagem.iniciar('Carregando...');
					
				for (i=0; i<responseJson.length; i++) {
					
					$(".listaAlimentacao tbody").append("<tr>"+
							  "<td>"+responseJson[i].id+"</td>"+
			                 
			                  "<td>"+responseJson[i].nome+"</td>"+
			                  "<td><a href='editar-alimentacao.jsp?id="+responseJson[i].id+"' class='btn btn-primary'><i class='fa fa-pencil'></i></a> <button data-id='"+responseJson[i].id+"' class='btn btn-danger excluirregistro'><i class='fa fa-trash'></i></button></td>"+
			                  "</tr>");
				}

            }).done(function() {
	  				$('.listaAlimentacao').DataTable({
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
				
				
				$(".listaAlimentacao tbody").on("click", ".excluirregistro", function() {
					var item = $(this);
						if(confirm("Excluir o registro?")) {
							var id = $(this).data("id");
							
							$.get('../alimentacaoServ',{action:"inativar", id: id},function(responseJson) {
								
								var table = $('.listaAlimentacao').DataTable();
								
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
				var retorno =  $.get('../alimentacaoServ',{action:"buscarPorId", id: id},function(responseJson) {
                   
					labelMensagem.iniciar('Carregando...');
//					console.log(responseJson);
				
					$( ":input[name=nome]" ).val(responseJson.nome);
					$( ":input[name=descricao]" ).val(responseJson.descricao);
					
//					Enviar Editar
					$(document).ready(function() {                        
						
						$("#editarAlimentacao").submit(function(e) {
							e.preventDefault();
							labelMensagem.iniciar('Enviando...');
							 $.post("../alimentacaoServ", $(this).serialize() ,
						                function(data){
						                    console.log(data);
						                    
						                }).done(function() {
						                	labelMensagem.iniciar('Registro enviado...');
						                	
						                	setTimeout(function(){ location.href='alimentacao.jsp'; }, 2000);
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
	
	
	inserirAlimentacao = function(){
			
		$(document).ready(function() {                        
		
				$("#inserirAlimentacao").submit(function(e) {
					e.preventDefault();
					labelMensagem.iniciar('Enviando...');
					 $.post("../alimentacaoServ", $(this).serialize() ,
				                function(data){
				                    console.log(data);
				                    
				                }).done(function() {
				                	labelMensagem.iniciar('Registro enviado...');
				                	
				                	setTimeout(function(){ location.href='alimentacao.jsp'; }, 2000);
				                })
				                .fail(function() {
				                  alert( "Ocorreu um erro, tente novamente" );
				                  location.href='cadastro-alimentacao.jsp';
				                })
				                .always(function() {
				                	labelMensagem.encerrar();
				              });
					
				})
			              
		});
		
	}

	editarAlimentacao = function(){
			
		$(document).ready(function() {                        
		
				$("#inserirAlimentacao").submit(function(e) {
					e.preventDefault();
					labelMensagem.iniciar('Enviando...');
					 $.post("alimentacaoServ", $(this).serialize() ,
				                function(data){
				                    console.log(data);
				                    
				                }).done(function() {
				                	labelMensagem.iniciar('Registro enviado...');
				                	
				                	setTimeout(function(){ location.href='alimentacao.jsp'; }, 2000);
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