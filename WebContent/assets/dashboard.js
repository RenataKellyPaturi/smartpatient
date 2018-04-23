+function ($) {
	$(".funcionalidadeslista").on('click','.linkadoModal', function(e) {
	  e.preventDefault()
	  var button = $(this);  
	  
	  var titulo = button.data('titulo');
	  
	  var formdestino = button.data('form');
		  

	  $.get('dashboardrequisicao',{titulo:titulo, action:'chama', quem: formdestino},function(responseText) {
		  console.log("No get");
		  console.log(responseText)
		  chamaModal(responseText,formdestino); 
	  });
	  

	  var chamaModal = function(stringQualquer,formdestino) {
		  console.log("chama modal");
		  console.log(stringQualquer)

		  if (formdestino == "pacientes") {
			  $("#funcionalidadesModalPaciente").modal('show') ;
			  
			  var modal = $('#funcionalidadesModalPaciente');
			  modal.find('.modal-title').text('Função: Formulario Pacientes')
			  modal.find('.modal-body .retorno').html(stringQualquer)
			 
			$(".retorno").on('click', '.cadastrogenerico', function() {
				
				console.log('Clicou em cadastrar sobre ' + $(this).data('funcao1') )
				
			})  ;

			$(".retorno").on('click', '.listargenerico', function() {
				
				console.log('Clicou em listar sobre ' + $(this).data('funcao1') )
				
			})  ;
			  

		  } else if(formdestino == "medicamento")
			  {
			  
 $("#funcionalidadesModalMedicamento").modal('show') ;
			  
			  var modal = $('#funcionalidadesModalMedicamento');
			  modal.find('.modal-title').text('Função: ' + titulo)
			  modal.find('.modal-body .retorno').html(stringQualquer)
			 
			$(".retorno").on('click', '.cadastrogenerico', function() {
				
				console.log('Clicou em cadastrar sobre ' + $(this).data('funcao1') )
				
			})  ;

			$(".retorno").on('click', '.listargenerico', function() {
				
				console.log('Clicou em listar sobre ' + $(this).data('funcao1') )
				
			})  ;
			  
			  
			  }else if(formdestino == "dicas")
			  		{
		  
$("#funcionalidadesModalDicas").modal('show') ;
		  
		  var modal = $('#funcionalidadesModalDicas');
		  modal.find('.modal-title').text('Função: ' + titulo)
		  modal.find('.modal-body .retorno').html(stringQualquer)
		 
		$(".retorno").on('click', '.cadastrogenerico', function() {
			
			console.log('Clicou em cadastrar sobre ' + $(this).data('funcao1') )
			
		})  ;

		$(".retorno").on('click', '.listargenerico', function() {
			
			console.log('Clicou em listar sobre ' + $(this).data('funcao1') )
			
		})  ;
		  
		  
		  }

		  
		  
			  else if(formdestino == "alimentacao") {
				  
				  $("#funcionalidadesModalAlimentacao").modal('show') ;
				  
				  var modal = $('#funcionalidadesModalAlimentacao');
				  modal.find('.modal-title').text('Função: ' + titulo)
				  modal.find('.modal-body .retorno').html(stringQualquer)
				  
				  $(".cadAlimentacao").click(function(){
					 var modal = $('.cadAlimentacao');
					 modal.find('.modal-title').text('Função: ' + titulo)
					  modal.find('.modal-body .retorno').html(stringQualquer)
				  });
				  
			  }else if(formdestino == "exercicio") {
				  
				  $("#funcionalidadesModaleExercicio").modal('show') ;
				  
				  var modal = $('#funcionalidadesModalExercicio');
				  modal.find('.modal-title').text('Função: ' + titulo)
				  modal.find('.modal-body .retorno').html(stringQualquer)
				  
				  $(".cadExercicio").click(function(){
						 var modal = $('.cadExercicio');
						 modal.find('.modal-title').text('Função: ' + titulo)
						  modal.find('.modal-body .retorno').html(stringQualquer)
					  });
			  
			  
		  } else {
		  

			  $('#funcionalidadesModal').modal('show') ;
			  
			  var modal = $('#funcionalidadesModal');
			  modal.find('.modal-title').text('Função: ' + titulo)
			  modal.find('.modal-body .retorno').html(stringQualquer)
			 
		  }
		  
		
		 
		  
	  }
	  
	});

}(jQuery);S