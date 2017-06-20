package it.uniroma3.galleria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tecnica")
public class Tecnica {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String tecnica;

	public String getNome() {
		return tecnica;
	}

	public void setNome(String tecnica) {
		this.tecnica = tecnica;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
