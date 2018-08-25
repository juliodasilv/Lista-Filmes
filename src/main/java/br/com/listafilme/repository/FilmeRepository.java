package br.com.listafilme.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import br.com.listafilme.model.Filme;

@Repository
public class FilmeRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Filme> findAll() {
		List<Filme> filmes = new ArrayList<Filme>();
		filmes = mongoTemplate.findAll(Filme.class);
		System.out.println("total de Filmes = " + filmes.size());
		return filmes;
	}

	public Filme findById(String id) {
		Filme filme = new Filme();
		System.out.println("busca por id = " + id);
		Query queryDeBuscaPorID = new Query(Criteria.where("id").is(id));
		filme = mongoTemplate.findOne(queryDeBuscaPorID, Filme.class);
		return filme;
	}

	public void insert(Filme filme) {
		mongoTemplate.insert(filme);
		System.out.println("novo Filme = " + filme);
	}

	public void update(Filme filme) {
		mongoTemplate.save(filme);
		System.out.println("Filme alterado = " + filme);
	}

	public void remove(String id) {
		Filme FilmeParaRemover = new Filme();
		FilmeParaRemover.setId(new ObjectId(id));
		mongoTemplate.remove(FilmeParaRemover);
		System.out.println("Filme removido = " + id);
	}
}