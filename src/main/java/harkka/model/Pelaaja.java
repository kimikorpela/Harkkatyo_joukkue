package harkka.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pelaaja {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nimi;
	private int pelinumero;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "pelipaikkaId")
	private Pelipaikka pelipaikka;

	public Pelaaja() {

	}

	public Pelaaja(String nimi, int pelinumero, Pelipaikka pelipaikka) {
		super();
		this.nimi = nimi;
		this.pelinumero = pelinumero;
		this.pelipaikka = pelipaikka;
	}

	public long getId() {
		return id;
	}

	public String getNimi() {
		return nimi;
	}

	public int getPelinumero() {
		return pelinumero;
	}

	public Pelipaikka getPelipaikka() {
		return pelipaikka;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public void setPelinumero(int pelinumero) {
		this.pelinumero = pelinumero;
	}

	public void setPelipaikka(Pelipaikka pelipaikka) {
		this.pelipaikka = pelipaikka;
	}

	@Override
	public String toString() {
		if (this.pelipaikka != null)
			return "Pelaaja [id=" + id + ", nimi=" + nimi + ", pelinumero=" + pelinumero + ", pelipaikka="
					+ this.getPelipaikka() + "]";
		else
			return "Pelaaja [id=" + id + ", nimi=" + nimi + ", pelinumero=" + pelinumero + "]";
	}
}