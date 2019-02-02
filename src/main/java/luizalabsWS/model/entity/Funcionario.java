/**
 * 
 */
package luizalabsWS.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Tiago Ferezin Data: 05/09/2018
 */
@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFunionario;

	private String dataCad;

	private String cargo;
	private String cpf;

	private String nome;
	private String ufNasc;

	private String salario;

	private String status;

	public Funcionario() {

	}

	/**
	 * @return the salario
	 */
	public String getSalario() {
		return salario;
	}

	/**
	 * @param salario
	 *            the salario to set
	 */
	public void setSalario(String salario) {
		this.salario = salario;
	}

	/**
	 * @return the idFunionario
	 */
	public Long getIdFunionario() {
		return idFunionario;
	}

	/**
	 * @param idFunionario
	 *            the idFunionario to set
	 */
	public void setIdFunionario(Long idFunionario) {
		this.idFunionario = idFunionario;
	}

	/**
	 * @return the dataCad
	 */
	public String getDataCad() {
		return dataCad;
	}

	/**
	 * @param dataCad
	 *            the dataCad to set
	 */
	public void setDataCad(String dataCad) {
		this.dataCad = dataCad;
	}

	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo
	 *            the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf
	 *            the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the ufNasc
	 */
	public String getUfNasc() {
		return ufNasc;
	}

	/**
	 * @param ufNasc
	 *            the ufNasc to set
	 */
	public void setUfNasc(String ufNasc) {
		this.ufNasc = ufNasc;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
