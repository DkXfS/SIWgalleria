package it.uniroma3.galleria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;


@Entity
@Table(name="Opera")
public class Opera {
	
	
	//siano di interesse il titolo, l’anno in cui è stato realizzato, la tecnica, le dimensioni, l’autore.
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String titolo;
	
	@ManyToOne
	private Autore autore;
	
	@ManyToOne
	private Tecnica tecnica;
	
	@Temporal(TemporalType.DATE)
	private Date anno;
	
	private String dimensioni;

	public Opera(String title, Autore author, Tecnica technique, Date anno, String dimensions)
	{
		this.titolo=title;
		this.autore=author;
		this.tecnica=technique;
		this.anno=anno;
		this.dimensioni=dimensions;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public Tecnica getTecnica() {
		return tecnica;
	}

	public void setTecnica(Tecnica tecnica) {
		this.tecnica = tecnica;
	}

	public Date getAnno() {
		return anno;
	}

	public void setAnno(Date anno) {
		this.anno = anno;
	}

	public String getDimensioni() {
		return dimensioni;
	}

	public void setDimensioni(String dimensioni) {
		this.dimensioni = dimensioni;
	}

}
