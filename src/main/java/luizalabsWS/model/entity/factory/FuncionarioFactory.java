/**
 * 
 */
package luizalabsWS.model.entity.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import luizalabsWS.model.entity.Funcionario;
import luizalabsWS.model.repositories.FuncionarioRepositorio;

/**
 * @author Tiago Ferezin Data: 08/09/2018
 */
public class FuncionarioFactory {

	public Map<String, Integer> getUfNascimentoComQuantidade(
			FuncionarioRepositorio funcionarioRepositorio) {
		Map<String, Integer> mapRetorno = new HashMap<String, Integer>();

		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

		listaFuncionarios = (List<Funcionario>) funcionarioRepositorio
				.findAll();

		for (Funcionario funcionario : listaFuncionarios) {
			String ufNasc = funcionario.getUfNasc();

			Integer quantidade = 0;

			if (mapRetorno.containsKey(ufNasc)) {
				Integer qtdRegistrado = mapRetorno.get(ufNasc);
				quantidade = qtdRegistrado + 1;
				mapRetorno.replace(ufNasc, quantidade);
			} else {
				mapRetorno.put(ufNasc, quantidade + 1);
			}

		}

		return mapRetorno;
	}

	public List<Funcionario> retornaFuncionariosPelaFaixaSalarial(
			String salarioBase, String salarioTopo,
			FuncionarioRepositorio funcionarioRepositorio) {
		
		Double salTopo = Double.parseDouble(salarioTopo);
		Double salBase = Double.parseDouble(salarioBase);
		
		List<Funcionario> retorno = new ArrayList<Funcionario>();
		
		List<Funcionario> listFuncionarios = new ArrayList<Funcionario>();
		listFuncionarios=(List<Funcionario>) funcionarioRepositorio.findAll();
		
		for (Funcionario funcionario : listFuncionarios) {
			
			Double salario = Double.parseDouble(funcionario.getSalario());
			
			if((salario>=salBase)&&(salario<=salTopo)){
				retorno.add(funcionario);
			}
			
		}
		return retorno;
	}

}
