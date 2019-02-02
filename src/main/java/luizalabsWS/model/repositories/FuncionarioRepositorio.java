/**
 * 
 */
package luizalabsWS.model.repositories;

import java.util.List;

import luizalabsWS.model.entity.Funcionario;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tiago Ferezin
 * Data: 06/09/2018
 */
@Repository
public interface FuncionarioRepositorio extends
		CrudRepository<Funcionario, Long> {
	
	@Query("SELECT t FROM Funcionario t WHERE t.nome = ?")
	public List<Funcionario> retornaFuncionarioPorNome(String nome);
	
	@Query("SELECT t FROM Funcionario t WHERE t.cpf = ?")
	public Funcionario retornaFuncionarioPeloCPF(String cpf);
	
	@Query("SELECT t FROM Funcionario t WHERE t.cargo = ?")
	public List<Funcionario> retornaFuncionarioPeloCargo(String cargo);
	
	@Query("SELECT t FROM Funcionario t WHERE t.dataCad = ?")
	public List<Funcionario> retornaFuncionarioPelaDataDeCadastro(String dataCad);
	
	@Query("SELECT t FROM Funcionario t WHERE t.status = ?")
	public List<Funcionario> retornaFuncionarioPeloStatus(String status);

}
