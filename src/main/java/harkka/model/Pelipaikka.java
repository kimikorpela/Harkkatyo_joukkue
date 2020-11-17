package harkka.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pelipaikka {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long pelipaikkaId;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pelipaikka")
	private List<Pelaaja> pelaajat;

	public Pelipaikka() {

	}

	public Pelipaikka(long pelipaikkaId, String name) {
		super();
		this.pelipaikkaId = pelipaikkaId;
		this.name = name;
	}

	public Pelipaikka(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Long getPelipaikkaId() {
		return pelipaikkaId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPelipaikkaId(long pelipaikkaId) {
		this.pelipaikkaId = pelipaikkaId;
	}

}