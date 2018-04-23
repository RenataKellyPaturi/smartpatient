package br.com.fafica.smartpacient.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GeradorData {
	/**
	 * Converte uma data no formato {@link String} para o formato {@link Date}
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date dateStringToSql(String dateString) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		try {
			return format.parse(dateString);
		} catch (Exception e) {
			return null;
		}
	}
	public static Date simpleDateFormat(String dataParaFormatar){
		
		String[] dataMontada = dataParaFormatar.split("-");

		SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
		Date dataNascimento = null;
		try {
			dataNascimento = formatador.parse(dataMontada[2] + "-" + dataMontada[1] + "-" + dataMontada[0]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataNascimento;
	}

}
