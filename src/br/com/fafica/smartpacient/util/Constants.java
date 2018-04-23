package br.com.fafica.smartpacient.util;

public class Constants {

public static String PERSISTENCE_UNIT_NAME = "br.com.fafica.smartpacient";


//status para Entidades

public static boolean INATIVADO = false;
public static boolean ATIVADO 	= true;

// Header's
public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
public static final String ACCESS_CONTROL_ALLOW_ORIGIN_EXTRA = "*";




//Status para excessões
public static int CPFINVALIDO 					= 3;
public static String CPFINVALIDO_MSG 			= "Cpf Inválido!";

public static int CPFSEMDIGITOS 				= 2;
public static String CPFSEMDIGITOS_MSG 			= "Digitos insuficientes";

public static int CPFJACADASTRADO 				= 1;
public static String CPFJACADASTRADO_MSG 		= "Já existe registro com este cpf";


public static int CPFNAOCADASTRADO 				= 7;
public static String CPFNAOCADASTRADO_MSG 		= "Registro não encontrado";

public static int EMAILINVALIDO 				= 4;
public static final String EMAILINVALIDO_MSG 	= "Este email é inválido";

public static int IDADEINVALIDA	 				= 6;
public static String IDADEINVALIDA_MSG	 		= "Esta idade é inválida";

}
