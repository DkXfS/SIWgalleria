package it.uniroma3.galleria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Nazionalita")
public class Nazionalita {
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nazione;

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	
	

}
