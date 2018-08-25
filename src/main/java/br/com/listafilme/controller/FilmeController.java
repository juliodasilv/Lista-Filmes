package br.com.listafilme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.listafilme.model.Filme;
import br.com.listafilme.service.FilmeService;

/**
 * @author Julio
 */
@Controller
public class FilmeController {
	
	@Autowired
	private FilmeService service;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@GetMapping("/filmes")
	public String listaFilmes(Model model){
		Iterable<Filme> filmes = service.findAll();
		model.addAttribute("filmes", filmes);
		return "listafilmes";
	}

	@GetMapping("/detalhe")
	public String detalhe(@RequestParam("id") String id,ModelMap model) {
		Filme filme = service.findById(id);
		model.addAttribute("seriado",filme);
		int totalAtores = 0;
		if (filme.getAtores() != null) {
			totalAtores = filme.getAtores().size();
		}
		model.addAttribute("totalAtores", totalAtores);
		return "detalhe";
	}

//	@RequestMapping(value = "/alterar",method = RequestMethod.GET)
//	public String alterar(@ModelAttribute Seriado seriado,ModelMap model,HttpServletRequest request) {
//
//		List<String> personagens = new ArrayList<String>();
//		personagens.add(request.getParameter("personagem1"));
//		personagens.add(request.getParameter("personagem2"));
//		personagens.add(request.getParameter("personagem3"));
//		personagens.add(request.getParameter("personagem4"));
//		personagens.add(request.getParameter("personagem5"));
//		personagens.add(request.getParameter("personagem6"));
//		seriado.setPersonagens(personagens);
//
//		repository.update(seriado);
//		model.addAttribute("msg","update");
//
//		return "detalhe";
//
//	}
//
//	@RequestMapping(value = "/remover",method = RequestMethod.GET)
//	public String remover(@RequestParam("id") String id,ModelMap model) {
//		repository.remove(id);
//		model.addAttribute("msg","delete");
//		return "detalhe";
//	}
//
//	@RequestMapping(value = "/novo",method = RequestMethod.GET)
//	public String novo() {
//		return "novo";
//	}
//
//	@RequestMapping(value = "/adicionar",method = RequestMethod.POST)
//	public String adicionar(@ModelAttribute Seriado seriado,ModelMap model,HttpServletRequest request) {
//		List<String> personagens = new ArrayList<String>();
//		personagens.add(request.getParameter("personagem1"));
//		personagens.add(request.getParameter("personagem2"));
//		personagens.add(request.getParameter("personagem3"));
//		personagens.add(request.getParameter("personagem4"));
//		personagens.add(request.getParameter("personagem5"));
//		personagens.add(request.getParameter("personagem6"));
//		seriado.setPersonagens(personagens);
//
//		repository.insert(seriado);
//		model.addAttribute("msg","add");
//
//		return "novo";
//	}
//	
//	@RequestMapping(value = "salvar", method = RequestMethod.POST )
//	public String salvar(@RequestParam("nome") String nome, @RequestParam("email")String email, 
//			@RequestParam("telefone") String telefone, Model model){
//		
//		Convidado novoConvidado = new Convidado(nome, email, telefone);
//		
//		service.salvar(novoConvidado);
//		
//		Iterable<Convidado> convidados = service.obterTodos();
//		
//		
//		model.addAttribute("convidados", convidados);
//		
//		return "listaconvidados";
//		
//	}

}
