
	var especialidadeprofissional = function() {


	$.get('especialidadeServlet',{action:"listar"},function(responseJson) {

		console.log(responseJson);
		
		
		return responseJson;
		 


        }).done(function(){

		console.log("done");
				
		return false;

		}).fail(function(data,status,xhr){


			console.log("<option>Lista não importada...</option>");


			return false;

		});

	}