package it.uniroma3.galleria.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;

import java.util.Date;


@Entity
@Table(name="Opera")
public class Opera {
	
	
	//siano di interesse il titolo, l’anno in cui è stato realizzato, la tecnica, le dimensioni, l’autore.
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

    @NotBlank(message = "è richiesta una stringa non nulla e non vuota")
    @Column(nullable=false)
	private String titolo;
	
	@ManyToOne
	private Autore autore;
	
	@ManyToOne//(cascade = {CascadeType.PERSIST})
	private Tecnica tecnica;

    @Min(value = 1, message = "Inserire un valore maggiore di 0")
	private int anno;

    private double altezza;

    private double larghezza;

	private String descrizione;

	private String imageUri;

	public Opera(){}

	public Opera(String title, Autore author, Tecnica technique, String descr, int anno, double height, double lenght)
	{
		this.titolo=title;
		this.autore=author;
		this.tecnica=technique;
		this.anno=anno;
		this.altezza=height;
		this.larghezza=lenght;
		this.descrizione = descr;
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

	public double getAltezza() {return altezza;}

	public void setAltezza(double altezza) {this.altezza = altezza;}

	public double getLarghezza() {return larghezza;}

	public void setLarghezza(double lunghezza) {this.larghezza=lunghezza;}

	public String getImageUri() {return imageUri;}

	public void setImageUri(String imageUri) {this.imageUri = imageUri;}

	public String getDescrizione() {return descrizione;}

	public String getNomeAutoreCompleto(){
		if(autore!=null)
		return autore.getName() + " " + autore.getCognome();
		else
			return "";
	}

	public void setDescrizione(String descrizione) {this.descrizione = descrizione;}

}
