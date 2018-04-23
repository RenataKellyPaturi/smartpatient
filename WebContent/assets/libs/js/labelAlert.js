
	var labelMensagem = {
		
		iniciar: function (mensagem) {
			$("body").append('<div class="tagLoad sucesso"><div class="content">'+mensagem+'</div></div>');	
		},
		
		encerrar: function() {
			setTimeout(function(){  $("body").find("div.tagLoad").remove(); }, 2000);
		},
		erro: function (mensagem) {
			$("body").append('<div class="tagLoad erro"><div class="content">'+mensagem+'</div></div>');	
		},
		              		
	}
