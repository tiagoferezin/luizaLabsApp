/**
 * 
 */
package luizalabsWS.controller;

import java.io.IOException;

import luizalabsWS.model.entity.factory.ArquivoFactory;
import luizalabsWS.model.repositories.ArquivoRepositorio;
import luizalabsWS.model.repositories.FuncionarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Tiago Ferezin Data: 08/09/2018
 */
@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	FuncionarioRepositorio funcionarioRepositorio;

	@Autowired
	ArquivoRepositorio arquivoRepositorio;

	@RequestMapping(method = RequestMethod.GET, value = "/index")
	public String index(Model model) {

		ArquivoFactory arquivoFactory = new ArquivoFactory();
		String erro = "";

		try {
			arquivoFactory.carregarFuncionariosDoArquivo(
					funcionarioRepositorio, arquivoRepositorio);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			erro = e.getMessage();
		}
		model.addAttribute("erro", erro);
		return "home/index";

	}
	
	

}
