package br.com.listafilme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.listafilme.model.Filme;
import br.com.listafilme.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository repository;
	
	public Iterable<Filme> findAll() {
		return repository.findAll();
	}

//	public void salvar(Fi novoConvidado) {
//	    repository.save(novoConvidado);
//	}

	public Filme findById(String id) {
		return repository.findById(id);
	}

}
