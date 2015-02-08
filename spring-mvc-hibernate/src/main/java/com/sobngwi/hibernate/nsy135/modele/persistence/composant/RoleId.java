package com.sobngwi.hibernate.nsy135.modele.persistence.composant;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sobngwi.hibernate.nsy135.modele.persistence.Film;
import com.sobngwi.hibernate.nsy135.modele.persistence.Artiste;

@Embeddable
public class RoleId implements java.io.Serializable { // Set de cle pour le Role 
	private static final long serialVersionUID = 1L; // Cache Hibernate
	@ManyToOne
	@JoinColumn(name = "id_acteur")
	private Artiste acteur;
	public Artiste getActeur() {
		return acteur;
	}
	public void setActeur(Artiste a) {
		this.acteur = a;
	}
	@ManyToOne
	@JoinColumn(name = "id_film")
	private Film film;
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film f) {
		this.film = f;
	}
}
