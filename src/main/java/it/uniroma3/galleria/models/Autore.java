package it.uniroma3.galleria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;
import java.util.List;


@Entity
@Table(name="Autore")
public class Autore {

	// Dell’autore sono di interesse nome, cognome, nazionalità data di nascita e data di morte.
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String cognome;
	
	@ManyToOne
	private Nazionalita nazionalita;
	
	@OneToMany(mappedBy="autore")
	private List <Opera> opere;
	
	@Temporal(TemporalType.DATE)
	private Date nascita;
	@Temporal(TemporalType.DATE)
	private Date morte;

	public Autore(){}

	public Autore(String name, String cognome, Nazionalita naz, Date birth, Date death, List<Opera>operaList)
	{
		this.name=name;
		this.cognome=cognome;
		this.nazionalita=naz;
		this.nascita=birth;
		this.morte=death;
		this.opere=operaList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Nazionalita getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(Nazionalita nazionalita) {
		this.nazionalita = nazionalita;
	}

	public Date getNascita() {
		return nascita;
	}

	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}

	public Date getMorte() {
		return morte;
	}

	public void setMorte(Date morte) {
		this.morte = morte;
	}
	
	@Override
	public String toString(){
		return "id="+id+", name="+name+", country="+nazionalita;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public void addOpera(Opera opera){ this.opere.add(opera);}

	public List<Opera> getOpere(){ return this.opere; }

	public boolean equals(Autore autore)
	{
		boolean whetherEquals=false;
		if(autore.getName().equals(this.name) && this.cognome.equals(autore.getCognome()) &&
				this.nazionalita.getNazione().equals(autore.getNazionalita().getNazione()) &&
				this.nascita.compareTo(autore.getNascita())==0 &&
				this.opere.get(0).equals(autore.getOpere().get(0)))
			whetherEquals=true;
		return whetherEquals;
	}
}