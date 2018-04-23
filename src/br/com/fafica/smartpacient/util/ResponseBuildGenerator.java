package br.com.fafica.smartpacient.util;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

/*
 * 
 * Author maicon
 */

public class ResponseBuildGenerator {
	
	
	/*
	 * esse metodo retorna um  link ResponserBuilder de sucesso do tipo Application_Json
	 * 
	 * usado para metodos que venha atravez de get,  ex : Lista,Procura id  ou nome, entre outros.
	 * 
	 */
	public static ResponseBuilder createOKResponseJSON(ResponseBuilder responseBuilder, String jsonElement) {
		responseBuilder = responseBuilder.header(Constants.ACCESS_CONTROL_ALLOW_ORIGIN,
				Constants.ACCESS_CONTROL_ALLOW_ORIGIN_EXTRA);
		responseBuilder = responseBuilder.type(MediaType.APPLICATION_JSON);
		responseBuilder = responseBuilder.status(Status.OK);
		responseBuilder = responseBuilder.entity(jsonElement);
		return responseBuilder;
	}

	
	
	/**
	 * Este metodo retorna um {@link ResponseBuilder} de sucesso do tipo
	 * APPLICATION_JSON
	 * 
	 * Usado para os metodos Create, Update , Delete ou outros que venha atras de post.
	 * 
	 * @param responseBuilder
	 * @return {@link ResponseBuilder}
	 */
	
	public static ResponseBuilder createOKResponseTextPlain(ResponseBuilder responseBuilder) {
		responseBuilder = responseBuilder.header(Constants.ACCESS_CONTROL_ALLOW_ORIGIN,
				Constants.ACCESS_CONTROL_ALLOW_ORIGIN_EXTRA);
		responseBuilder = responseBuilder.type(MediaType.TEXT_PLAIN);
		responseBuilder = responseBuilder.status(Status.OK);
		return responseBuilder;
	}

	/**
	 * Este método retorna um {@link ResponseBuilder} de erro do tipo TEXT_PLAIN
	 * 
	 * usado para retorna o determinado erro
	 * 
	 * @param responseBuilder
	 * @return {@link ResponseBuilder}
	 */
	public static ResponseBuilder createErrorResponse(ResponseBuilder responseBuilder) {
		responseBuilder = responseBuilder.header(Constants.ACCESS_CONTROL_ALLOW_ORIGIN,
				Constants.ACCESS_CONTROL_ALLOW_ORIGIN_EXTRA);
		responseBuilder = responseBuilder.type(MediaType.TEXT_PLAIN);
		responseBuilder = responseBuilder.status(Status.INTERNAL_SERVER_ERROR);
		return responseBuilder;
	}

}
