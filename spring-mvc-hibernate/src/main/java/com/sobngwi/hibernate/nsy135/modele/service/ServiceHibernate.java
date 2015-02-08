/**
 * 
 */
package com.sobngwi.hibernate.nsy135.modele.service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.sobngwi.hibernate.nsy135.modele.dao.IServiceHibernateDAO;
import com.sobngwi.hibernate.nsy135.modele.persistence.Film;
import com.sobngwi.hibernate.nsy135.modele.persistence.Internaute;
import com.sobngwi.hibernate.nsy135.modele.persistence.Pays;

/**
 * @author Alain Narcisse SOBNGWI.
 * Classe implementant les methode de tests via Hibernate.
 */
@Service
public class ServiceHibernate implements  IServiceHibernate {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceHibernate.class);
	
	@Inject
	private IServiceHibernateDAO dao;

	@Transactional(readOnly=true)
	public List<Pays> listeDesPaysViaHBNCRI() {
				
		return dao.listeDesPaysViaHBNCRI() ;
	}
	@Transactional(readOnly=true)
	public List<Pays> listeDesPaysViaHBNHQL() {
		
		return dao.listeDesPaysViaHBNHQL();
	}
	@Transactional(readOnly=true)
	public List<Film> listeDesFilmsViaHBNCRI() {
		
		return dao.listeDesFilmsViaHBNCRI() ;
		
	}
	@Transactional(readOnly=true)
	public List<Film> listeDesFilmsViaHBNHQL() {
				
		return  dao.listeDesFilmsViaHBNHQL() ;
	}
	
	@Transactional(readOnly=true)
	public List<Internaute> listeDesInternautesViaCRI() {
		return dao.listeDesInternautesViaCRI() ;
	}


	@Transactional
	public void persistPays(Pays p) {
				
		dao.persistPays(p);
	}
	
	
	@Transactional
	public Film persistFilmFromScratch() {
		
		return	dao.persistFilmFromScratch() ;
		
	}
	@Transactional(readOnly=true)
	public Film lireFilmParCle(Serializable o) {
		return null ;
		
	}

	@Transactional(readOnly=true)
	public List<Film> lireFilmParTitre(String titre) {
		return dao.LireFilmParTitre(titre) ;
	}
	@Transactional(readOnly=true)
	public List<Film> lireFilmParTitreFetch(String titre) {
		return dao.lireFilmParTitreFetch(titre) ;
	}
	@Transactional(readOnly=true)
	public Set<Film> listeDesFilmsRealisesParActeurDuFilmId(Serializable o) {
		return dao.listeDesFilmsRealisesParActeurDuFilmId(o);
	}
	
	

}
