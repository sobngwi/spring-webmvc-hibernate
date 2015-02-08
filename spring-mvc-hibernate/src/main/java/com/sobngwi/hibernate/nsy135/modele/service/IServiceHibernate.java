/**
 * 
 */
package com.sobngwi.hibernate.nsy135.modele.service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.sobngwi.hibernate.nsy135.modele.persistence.Film;
import com.sobngwi.hibernate.nsy135.modele.persistence.Internaute;
import com.sobngwi.hibernate.nsy135.modele.persistence.Pays;

/**
 * Cette interface devra etre implemente, pour les requetes via JDBC.
 * Class qui va permettre une simulation des requetes Hibernate.
 * @author Alain Narcisse SOBNGWI
 *
 */
public interface IServiceHibernate {
	//void createSesion ();
	Film       lireFilmParCle ( Serializable o) ;
	List<Film> lireFilmParTitre ( String title ) ;
	List<Film> lireFilmParTitreFetch( String title ) ;
	Set<Film>  listeDesFilmsRealisesParActeurDuFilmId (Serializable o) ;
	List<Pays> listeDesPaysViaHBNCRI () ;
	List<Pays> listeDesPaysViaHBNHQL () ;
	List<Film> listeDesFilmsViaHBNCRI () ;
	List<Film> listeDesFilmsViaHBNHQL () ;
	List<Internaute> listeDesInternautesViaCRI () ;
	Film persistFilmFromScratch() ;
	void persistPays( Pays p );

}
