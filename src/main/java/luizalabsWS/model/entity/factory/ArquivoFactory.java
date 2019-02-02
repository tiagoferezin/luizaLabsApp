/**
 * 
 */
package luizalabsWS.model.entity.factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import luizalabsWS.model.entity.Arquivo;
import luizalabsWS.model.entity.Funcionario;
import luizalabsWS.model.repositories.ArquivoRepositorio;
import luizalabsWS.model.repositories.FuncionarioRepositorio;

/**
 * @author Tiago Ferezin Data: 05/09/2018
 */
public class ArquivoFactory {

	public void carregarFuncionariosDoArquivo(
			FuncionarioRepositorio funcionarioRepositorio,
			ArquivoRepositorio arquivoRepositorio) throws IOException {
		List<Arquivo> listaArquivos = new ArrayList<Arquivo>();
		Arquivo arquivo = new Arquivo();

		listaArquivos = (List<Arquivo>) arquivoRepositorio.findAll();

		if (listaArquivos.size() > 0) {
			arquivo = listaArquivos.get(0);

			if (arquivo.getCarregou() == 0) {
				carregarArquivo(arquivo, arquivoRepositorio,
						funcionarioRepositorio);
			}

		} else {
			carregarArquivo(arquivo, arquivoRepositorio, funcionarioRepositorio);
		}

	}

	private void carregarArquivo(Arquivo arquivo,
			ArquivoRepositorio arquivoRepositorio,
			FuncionarioRepositorio funcionarioRepositorio) throws IOException {

		String pathArquivo = "";

		if ((arquivo.getIdArquivo() > 0L)
				&& (!arquivo.getCaminhoArquivo().isEmpty())) {
			pathArquivo = arquivo.getCaminhoArquivo();
		} else {
			pathArquivo = "C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\wtpwebapps\\luizalabsWS\\WEB-INF\\classes\\funcionarios.txt";
			arquivo.setCaminhoArquivo(pathArquivo);
		}

		BufferedReader conteudoTXT = null;

		String linha = "";

		String separador = ";";

		conteudoTXT = new BufferedReader(new FileReader(pathArquivo));
		String[] atributo = null;
		try {
			while ((linha = conteudoTXT.readLine()) != null) {

				atributo = linha.split(separador);

				// Retirando a primeira linha
				if (!atributo[1].equals("Cargo")) {
					Funcionario funcionario = new Funcionario();
					String dataCad = atributo[0];
					String cargo = atributo[1];
					String cpf = atributo[2];
					String nome = atributo[3];
					String ufNascimento = atributo[4];
					String salario = atributo[5];
					String status = atributo[6];
					funcionario.setDataCad(dataCad);

					funcionario.setCargo(cargo);

					funcionario.setCpf(cpf);
					funcionario.setNome(nome);
					funcionario.setUfNasc(ufNascimento);
					funcionario.setSalario(salario);
					funcionario.setStatus(status);

					funcionarioRepositorio.save(funcionario);

				}

			}

			arquivo.setCarregou(1);

		} catch (Exception e) {

			arquivo.setCarregou(0);

		}
		arquivoRepositorio.save(arquivo);
	}
}
