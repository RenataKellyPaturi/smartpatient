package br.com.fafica.smartpacient.modelo.interfaces;


/*
 * Author Maicon Silva 
 * 
 * O intuito desse metodo é validar os atributos da classe, reforcando sua integridade junto ao banco de dados,
 * sendo assim sendo obrigatorio em todas as Entidades desenvolvidas.
 */
public interface IEntity {
	public boolean validadorClasse();

}
