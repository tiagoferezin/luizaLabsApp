/**
 * 
 */
package luizalabsWS.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import luizalabsWS.model.entity.Funcionario;
import luizalabsWS.model.entity.factory.ArquivoFactory;
import luizalabsWS.model.entity.factory.FuncionarioFactory;
import luizalabsWS.model.repositories.ArquivoRepositorio;
import luizalabsWS.model.repositories.FuncionarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

/**
 * @author Tiago Ferezin Data: 05/09/2018
 */
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	FuncionarioRepositorio funcionarioRepositorio;

	@Autowired
	ArquivoRepositorio arquivoRepositorio;

	@RequestMapping(value = "/buscarFuncionarios/", method = RequestMethod.GET, headers = "Accept=appliation/json")
	@ResponseBody
	public String getFuncionario() {
		Gson gson = new Gson();

		ArquivoFactory af = new ArquivoFactory();

		List<Funcionario> retorno = new ArrayList<Funcionario>();
		try {
			retorno = (List<Funcionario>) funcionarioRepositorio.findAll();
			if ((retorno == null) || (retorno.size() == 0)) {

				af.carregarFuncionariosDoArquivo(funcionarioRepositorio,
						arquivoRepositorio);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String returno = gson.toJson(retorno);

		return returno;

	}

	@RequestMapping(value = "/funcionarioPeloCPF/{cpf}", method = RequestMethod.GET, headers = "Accept=appliation/json")
	@ResponseBody
	public String getFuncionarioCPF(@PathVariable("cpf") String cpf) {

		Gson gson = new Gson();
		Funcionario funcionario = new Funcionario();
		funcionario = funcionarioRepositorio.retornaFuncionarioPeloCPF(cpf);
		String retorno = gson.toJson(funcionario);
		return retorno;

	}

	@RequestMapping(value = "/funcionarioPeloNome/{nome}", method = RequestMethod.GET, headers = "Accept=appliation/json")
	@ResponseBody
	public String getFuncionarioPorNome(@PathVariable("nome") String nome) {
		String retorno = "";

		if (nome.contains("-")) {
			nome = nome.replaceAll("-", " ");
		}
		List<Funcionario> lista = funcionarioRepositorio
				.retornaFuncionarioPorNome(nome);
		Gson gson = new Gson();
		retorno = gson.toJson(lista);
		return retorno;
	}

	@RequestMapping(value = "/funcionarioPeloCargo/{cargo}", method = RequestMethod.GET, headers = "Accept=appliation/json")
	@ResponseBody
	public String getFuncionariosPorCargo(@PathVariable("cargo") String cargo) {
		String retorno = "";
		List<Funcionario> listaPorCargo = new ArrayList<Funcionario>();
		if (cargo.contains("-")) {
			cargo = cargo.replaceAll("-", " ");
		}
		listaPorCargo = funcionarioRepositorio
				.retornaFuncionarioPeloCargo(cargo);
		Gson gson = new Gson();
		retorno = gson.toJson(listaPorCargo);
		return retorno;
	}

	@RequestMapping(value = "/funcionarioPelaDataCadastro/{dataCad}", method = RequestMethod.GET, headers = "Accept=appliation/json")
	@ResponseBody
	public String getFuncionarioPelaDataCadastro(
			@PathVariable("dataCad") String dataCad) {
		String retorno = "";

		if (dataCad.contains("-")) {
			dataCad = dataCad.replaceAll("-", "/");
		}

		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		listaFuncionario = funcionarioRepositorio
				.retornaFuncionarioPelaDataDeCadastro(dataCad);
		Gson gson = new Gson();
		retorno = gson.toJson(listaFuncionario);

		return retorno;
	}

	@RequestMapping(value = "/quantidadeFuncionariosPorUfNascimento/", method = RequestMethod.GET, headers = "Accept=appliation/json")
	@ResponseBody
	public String getQuantidadeFuncionarioPorUf() {
		String retorno = "";

		FuncionarioFactory funcionarioFactory = new FuncionarioFactory();

		Map<String, Integer> mapRetorno = new HashMap<String, Integer>();
		mapRetorno = funcionarioFactory
				.getUfNascimentoComQuantidade(funcionarioRepositorio);

		Gson gson = new Gson();
		retorno = gson.toJson(mapRetorno);

		return retorno;
	}

	@RequestMapping(value = "/funcionariosPorFaixaSalarial/{salarioBase}-{salarioTopo}", method = RequestMethod.GET, headers = "Accept=appliation/json")
	@ResponseBody
	public String getFuncionariosPorFaixaSalarial(
			@PathVariable("salarioBase") String salarioBase,
			@PathVariable("salarioTopo") String salarioTopo) {

		String retorno = "";

		FuncionarioFactory funcionarioFactory = new FuncionarioFactory();

		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		listaFuncionarios = funcionarioFactory
				.retornaFuncionariosPelaFaixaSalarial(salarioBase, salarioTopo,
						funcionarioRepositorio);

		Gson gson = new Gson();
		retorno = gson.toJson(listaFuncionarios);
		return retorno;

	}

	@RequestMapping(value = "/funcionariosPorStatus/{status}", method = RequestMethod.GET, headers = "Accept=appliation/json")
	@ResponseBody
	public String getFuncionariosPeloStstus(
			@PathVariable("status") String status) {

		status = status.toUpperCase();

		String retorno = "";

		List<Funcionario> listaFuncionariosStatus = new ArrayList<Funcionario>();
		listaFuncionariosStatus = funcionarioRepositorio
				.retornaFuncionarioPeloStatus(status);
		Gson gson = new Gson();
		retorno = gson.toJson(listaFuncionariosStatus);

		return retorno;

	}

	@RequestMapping(value = "/deleteFuncionarioCPF/{cpf}", method = RequestMethod.DELETE, headers = "Accept=appliation/json")
	public ResponseEntity<String> deletarFuncionarioCPF(
			@PathVariable("cpf") String cpf) {
		Funcionario funcionario = new Funcionario();
		funcionario = funcionarioRepositorio.retornaFuncionarioPeloCPF(cpf);

		try {
			funcionarioRepositorio.delete(funcionario);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/adicionarFuncionario/", method = RequestMethod.POST, headers = "Accept=appliation/json")
	public ResponseEntity<Void> adicionarFuncionario(
			@RequestBody Funcionario funcionario) {
		Funcionario funcPesquisa = new Funcionario();
		funcPesquisa = funcionarioRepositorio
				.retornaFuncionarioPeloCPF(funcionario.getCpf());
		if ((funcPesquisa != null) && (funcPesquisa.getIdFunionario() > 0L)) {
			funcionarioRepositorio.save(funcPesquisa);
		} else {
			funcionarioRepositorio.save(funcionario);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

}
