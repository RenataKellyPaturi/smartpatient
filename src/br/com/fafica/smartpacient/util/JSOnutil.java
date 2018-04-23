package br.com.fafica.smartpacient.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSOnutil {
	/**
	 * Converte um Object para String JSON
	 * 
	 * @param object
	 * @return {@link String}
	 */
	public static String objectToJSON(Object object) {
		Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
		return gson.toJson(object);
	}

	/**
	 * Converte um Object para String JSON para bairros Método em teste e
	 * somente para auxiliar na exibição dos bairro
	 * 
	 * @param object
	 * @return
	 */
	public static String objectToJSONAux(Object object) {
		return (new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()).toJson(object);
	}


}
