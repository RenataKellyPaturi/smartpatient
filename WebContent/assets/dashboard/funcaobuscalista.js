	
$(document).ready(function() {
 		
		$.ajax({
             url: "../paciente",
             dataType: "json",
             data: {
           	  action : "getSessionPaciente"
           	 },
             success: function( data, textStatus, jqXHR) {
            	 	console.log("Verificar se paciente ta selcionado");
           	  		console.log(data);
           	  		if (data != null) {
           	  				mostrarPaciente(data.nome,data.id);
           	  		}
 	    		
             },
             error: function(jqXHR, textStatus, errorThrown){
                  console.log( textStatus);
             }
         });
		 
		 
			listaBusca() ;
		  
		});
		



			$('.espacoclienteseleciona').on('click','.retiraselecaopaciente', function() {
				$.ajax({
		             url: "../paciente",
		             dataType: "json",
		             data: {
		           	  action : "inactiveSessionPaciente"
		           	 },
		             success: function( data, textStatus, jqXHR) {
		            	 	console.log("Retirando seleção de paciente");
		           	  		console.log(data);
		           	  		console.log("Reencaminha para index, desativando menus....")
		           	  		setTimeout(function(){ location.href='index.jsp'; }, 2000);
		 	    		
		             },
		             error: function(jqXHR, textStatus, errorThrown){
		                  console.log( textStatus);
		             }
		         });
				  
			});

		  $('.espacoclienteseleciona').on('click','.novabuscapaciente', function() {
			  
			  $('.espacoclienteseleciona').html('<input type="text" name="pacientebusca" class="form-control" id="pacientebusca" placeholder="busque o paciente a ser atendido...">');
			  
			  
				  
				listaBusca() ;
		  });
		
		
		function listaBusca() {
			var listaGrande=[];
			 
			  $("input#pacientebusca").autocomplete({
			      width: 300,
			      max: 10,
			      delay: 100,
			      minLength: 1,
			      autoFocus: true,
			      cacheLength: 1,
			      scroll: true,
			      select: function(event, ui) {
			    	     //alert(ui.item.value);
			    	     
			    	     for (x=0; x<listaGrande.length; x++) {
			    	    
			    	    	 if (listaGrande[x].nome == ui.item.value) {
			    	    		 console.log(listaGrande[x].nome);
			    	    		 console.log(listaGrande[x].id);
			    	    		 
			    	    		 $.ajax({
						              url: "../paciente",
						              dataType: "json",
						              data: {
						            	  id : listaGrande[x].id,
						            	  action : "setSessionPaciente"
						            	 },
						              success: function( data, textStatus, jqXHR) {
						            	  console.log( data);
						            	 
						            	    
						                  
						              },
						              error: function(jqXHR, textStatus, errorThrown){
						                   console.log( textStatus);
						              }
						          });
			    	    		 
			    	    		 mostrarPaciente(listaGrande[x].nome,listaGrande[x].id);
			    	    		 	setTimeout(function(){ location.href='index.jsp'; }, 3000);
			    	    		 
			    	    		 
			    	    	 }
			    	     }
			    	     
			    	     
			    	     
		    	    },
			      highlight: false,
			      source: function(request, response) {
			          $.ajax({
			              url: "../paciente",
			              dataType: "json",
			              data: {
			            	  term : request.term,
			            	  action : "autoComplete"
			            	 },
			              success: function( data, textStatus, jqXHR) {
			            	  console.log( data);
			            	  listaGrande = data;
			            	  var lista = [];
			            	  
			            	  for (x=0; x<data.length; x++) {
			            		  
			            		console.log(data[x].nome);  
			            		
			            		lista.push(data[x].nome);
			            		  
			            	  };
			                	
			            	  response(lista);
				                
			                  
			              },
			              error: function(jqXHR, textStatus, errorThrown){
			                   console.log( textStatus);
			              }
			          });
			      }
			
			  });
		}
		
		
		function mostrarPaciente(nomepaciente,id) {
			
			 $(".espacoclienteseleciona").html('<div class="btn " role="group"><button type="button" class="btn btn-primary  btn-lg btn-block dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">'+nomepaciente+' <span class="caret"></span></button><ul class="dropdown-menu"><li><a href="editar-paciente.jsp?id='+id+'">Dados do Paciente</a></li><li role="separator" class="divider"></li><li class=""><a href="#" class="novabuscapaciente ">Buscar novo paciente...</a></li><li role="separator" class="divider"></li><li class=""><a href="#" class="retiraselecaopaciente ">Retirar seleção do paciente...</a></li></ul></div>');
	    		
			
		}
 
		 
