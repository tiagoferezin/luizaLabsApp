/**
 * 
 */
package luizalabsWS.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Tiago Ferezin Data: 08/09/2018
 */
@Entity
public class Arquivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idArquivo;

	@Column(nullable = false)
	private Integer carregou;

	private String caminhoArquivo;

	public Arquivo() {

	}

	/**
	 * @return the idArquivo
	 */
	public Long getIdArquivo() {
		return idArquivo;
	}

	/**
	 * @param idArquivo
	 *            the idArquivo to set
	 */
	public void setIdArquivo(Long idArquivo) {
		this.idArquivo = idArquivo;
	}

	/**
	 * @return the carregou
	 * @return 1 se já está no banco
	 * @return 0 se não está persistido no BD
	 */
	public Integer getCarregou() {
		return carregou;
	}

	/**
	 * @param carregou
	 *            the carregou to set
	 * @param 1 para carregado em DB
	 * @param 0 para não carregado em DB
	 */
	public void setCarregou(Integer carregou) {
		this.carregou = carregou;
	}

	/**
	 * @return the caminhoArquivo
	 */
	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

	/**
	 * @param caminhoArquivo
	 *            the caminhoArquivo to set
	 */
	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}

}
