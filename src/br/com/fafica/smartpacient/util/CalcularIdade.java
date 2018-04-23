package br.com.fafica.smartpacient.util;

import java.util.Calendar;
import java.util.Date;


/**
 * @author Diego 
 * 
 * Esta classe tem o intuito de  calcular a idade, passando como paramentro a data de nascimento,
 * calculando ano atual -  ano nascimento.
 *
 */
public class CalcularIdade {
	
    public static Integer getIdade(Date data) {
	
    	Calendar dataNascimento = Calendar.getInstance();
    	dataNascimento.setTime(data);
    	Calendar dataAtual = Calendar.getInstance();
    	Integer diferencaMes = dataAtual.get(Calendar.MONTH) - dataNascimento.get(Calendar.MONTH);
    	Integer diferencaDia = dataAtual.get(Calendar.DAY_OF_MONTH) - dataNascimento.get(Calendar.DAY_OF_MONTH);
    	Integer idade = (dataAtual.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR));
    	if(diferencaMes < 0	|| (diferencaMes == 0 && diferencaDia < 0)) {
    		idade--;
    	}
    	return idade;
	}
    
    
    public static boolean verificarMaiorIdade(Integer idade) {
    	boolean r = false;
    	
    	if (idade > 18) {
    		r = true;
    	}
    	
    	
    	return r;
    }
    
}
