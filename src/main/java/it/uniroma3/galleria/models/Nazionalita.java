package it.uniroma3.galleria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Nazionalita")
public class Nazionalita {

	public Nazionalita(){}

	public Nazionalita(String nation) { this.nome=nation; }
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nazione) {
		this.nome = nazione;
	}
	
	

}
