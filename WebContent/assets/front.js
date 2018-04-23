 $(function() {
    // coloca como variaveis as listas de A Escolher e Escolhidos
    var $escolher = $( "#funcionalidadesescolher" ),
      $escolhidos = $( "#funcionalidadesescolhidas" ), $idsEnvio = [];
    
    
//     Seta a função DRAG nos itens a serem escolhidos
    $( "li", $escolher ).draggable({
      cancel: "a.ui-icon", 
      revert: "invalid", 
      containment: "document",
      helper: "clone",
      cursor: "move"
    });
 
//     Recebe e afixa a funcionalidade escolhida pelo usuário
    $escolhidos.droppable({
      accept: "#funcionalidadesescolher li",
    
      drop: function( event, ui ) {
        escolheFuncao( ui.draggable );
    	  console.log("item escolhido")
      }
    });
 
//     Seta os itens escolhidos para poderem ser retirados da pilha de escolhidos e 
//    possibilita que estes possam ser retirados e colocados novamente como itens a escolher
    $escolher.droppable({
      accept: "#funcionalidadesescolhidas li",

      drop: function( event, ui ) {
        retiraFuncao( ui.draggable );
    	  console.log("item retirado da escolha")
      }
    });
    
    
    function escolheFuncao( $item ) {
        $item.fadeOut(function() {
//          var $list = 
//            $( "#funcionalidadesescolhidas" ).appendTo( $escolhidos );
   
//          $item.find( "a.ui-icon-trash" ).remove();
        	
          $item.appendTo( $( "#funcionalidadesescolhidas ul" ) ).fadeIn(function() {
            console.log("Item selecionado " + $item.data("id"));
            arrayParaEnvioInsere($item);
            console.log($idsEnvio);
          });
        });
      }
	  
    
    function retiraFuncao( $item ) {
        $item.fadeOut(function() {
          $item           
            .appendTo( "#funcionalidadesescolher ul")
            .fadeIn();
        
          arrayParaEnvioRetira($item);
          console.log($idsEnvio);
        });
        
      }
    
//    Metodos para administrar o array
    function arrayParaEnvioInsere($item) {
    	$idsEnvio.push($item.children('a').data("id"));
    	return $idsEnvio;
    }
    
    function arrayParaEnvioRetira($item) {
    	$idsEnvio.pop($item.children('a').data("id"));
    	return $idsEnvio;
    }
    
    
});

