package it.uniroma3.galleria.models;

import javax.persistence.*;

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
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	private Tecnica tecnica;
	
	private int anno;
	
	private float altezza;

	private float lunghezza;

	private String imageUri;

	public Opera(){}

	public Opera(String title, Autore author, Tecnica technique, int anno, float height, float lenght)
	{
		this.titolo=title;
		this.autore=author;
		this.tecnica=technique;
		this.anno=anno;
		this.altezza=height;
		this.lunghezza=lenght;
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

	public int getAnno() {return anno;}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public float getAltezza() {return altezza;}

	public void setAltezza(float altezza) {this.altezza = altezza;}

	public float getLunghezza() {return lunghezza;}

	public void setLunghezza(float lunghezza) {this.lunghezza=lunghezza;}

	public String getImageUri() {return imageUri;}

	public void setImageUri(String imageUri) {this.imageUri = imageUri;}

}
