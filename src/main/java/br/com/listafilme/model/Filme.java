package br.com.listafilme.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "filmes")
public class Filme implements Serializable {

	private static final long serialVersionUID = -5142278083403921512L;

	@Id
	private ObjectId id;

	private String nome;
	private String nomeOriginal;
	private String sinopse;
	private Double notaImdb;
	
	@JsonIgnore
	private String atoresString;
	
	private List<String> atores = new ArrayList<>();

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeOriginal() {
		return nomeOriginal;
	}

	public void setNomeOriginal(String nomeOriginal) {
		this.nomeOriginal = nomeOriginal;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public List<String> getAtores() {
		return Arrays.asList(atoresString.trim().split(","));
	}

	public void setAtores(List<String> atores) {
		this.atores = atores;
	}

	public Double getNotaImdb() {
		return notaImdb;
	}

	public void setNotaImdb(Double notaImdb) {
		this.notaImdb = notaImdb;
	}

	public String getAtoresString() {
		StringBuilder sb = new StringBuilder();
		atores.forEach(s -> sb.append(s).append(","));
		return removeLastCharOptional(sb.toString());
	}

	public void setAtoresString(String atoresString) {
		this.atoresString = atoresString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (id == null ? 0 : id.hashCode());
		result = prime * result + (nome == null ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		Filme other = (Filme) obj;
		if (id == null) {
			if (other.id != null) { return false; }
		} else if (!id.equals(other.id)) { return false; }
		if (nome == null) {
			if (other.nome != null) { return false; }
		} else if (!nome.equals(other.nome)) { return false; }
		return true;
	}

	@Override
	public String toString() {
		return "Filme [id=" + id + ", nome=" + nome + ", nomeOriginal=" + nomeOriginal + ", sinopse=" + sinopse
				+ ", notaImdb=" + notaImdb + ", atores=" + atores + "]";
	}
	
	private String removeLastCharOptional(String s) {
	    return Optional.ofNullable(s)
	      .filter(str -> str.length() != 0)
	      .map(str -> str.substring(0, str.length() - 1))
	      .orElse(s);
	    }

}