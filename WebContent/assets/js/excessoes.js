
	var excessaoRetorno = function(codigo) {
		
		switch (codigo) {
		case 1:
			return "Já existe registro com este cpf";
		break;
		case 2:
			return "Digitos do cpf são insuficientes";
		break;
		case 3:
			return "Este Cpf é Inválido!";
		break;
		case 6:
			return "Idade inválida!";
		break;
		default:
			return "Um erro inesperado ocorreu. Tente novamente";
		break;
		}
		
	}