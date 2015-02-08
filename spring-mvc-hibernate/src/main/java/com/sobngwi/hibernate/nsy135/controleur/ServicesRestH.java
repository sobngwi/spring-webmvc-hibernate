package com.sobngwi.hibernate.nsy135.controleur;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.sobngwi.hibernate.nsy135.modele.persistence.Film;
import com.sobngwi.hibernate.nsy135.modele.persistence.Internaute;
import com.sobngwi.hibernate.nsy135.modele.persistence.Pays;
import com.sobngwi.hibernate.nsy135.modele.service.IServiceHibernate;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


@Path("ServicesRESTH")
@Api(value = "/ServicesRESTH", description = "NSY135  : Pilote pour les tests Hibernate")
@Controller
public class ServicesRestH {

	
	@Inject
	private IServiceHibernate serviceHbn;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ServicesRestH.class);

	@POST
	@Path("/createCountry/{code}/{nom}/{langue}")
	@ApiOperation(value = "Service de creation de Pays a partir du code", 
	notes = "Un service de creation de Pays a partir du code , la langue et son nom  ", 
	httpMethod = "POST", response = Pays.class)
	@Produces(MediaType.APPLICATION_JSON)
	public Pays  createCountry(
			@ApiParam(defaultValue = "FR") @PathParam("code") String code,	
			@ApiParam(defaultValue = "FRANCE") @PathParam("nom") String nom,
			@ApiParam(defaultValue = "FRANCAIS") @PathParam("langue") String langue
			) {

		LOGGER.info(" Create the Country To Persist [" + code + "-->" + nom +"-->" + langue + "]") ;
		Pays paysToPersist = new Pays () ; 
		paysToPersist.setCode(code);
		paysToPersist.setLangue(langue);
		paysToPersist.setNom(nom);
		serviceHbn.persistPays(paysToPersist);

	   LOGGER.info("End Of persist of the Country in The Web Service return  ");
		 return paysToPersist ;
	}
	
	
	@GET
	@Path("/listeDesPaysCRI")
	@ApiOperation(value = "Un service qui liste les Pays dans NOTRE SI de CINEMA en Hibernate Criteria", 
	notes = "listeDesFilmsCRI  :Donne la liste des films dans notre base de donnees ", 
	httpMethod = "GET", response = List.class)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pays> listeDesPaysCRI() {
	
		LOGGER.info("Starting Liste Des Films Services Avec Criteria");
		return serviceHbn.listeDesPaysViaHBNCRI();
	}
	
	@GET
	@Path("/listeDesPaysHQL")
	@ApiOperation(value = "Un service qui liste les Pays dans NOTRE SI de CINEMA en Hibernate HQL", 
	notes = "listeDesPaysHQL  :Donne la liste des films dans notre base de donnees ", 
	httpMethod = "GET", response = List.class)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pays> listeDesPaysViaHQL() {

		LOGGER.info("Starting Liste Des Films Services Avec Criteria");
		return serviceHbn.listeDesPaysViaHBNHQL();
	}

	@GET
	@Path("/listeDesFilmsCRI")
	@ApiOperation(value = "Un service qui liste les Films dans NOTRE SI de CINEMA en Hibernate Criteria", 
	notes = "listeDesFilmsCRI  :Donne la liste des films dans notre base de donnees ", 
	httpMethod = "GET", response = List.class)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Film> listeDesFilmsCRI() {

		LOGGER.info("Starting Liste Des Films Services Avec Criteria");
		return serviceHbn.listeDesFilmsViaHBNCRI();
	}
	@GET
	@Path("/listeDesFilmsHQLFETCH")
	@ApiOperation(value = "Un service qui liste les Films dans NOTRE SI de CINEMA en Hibernate HQL ", 
	notes = "listeDesFilmsHQLFETCH  :Donne la liste des films dans notre base de donnees HQL FETCH minimisation"
			+ " des requetes Hibernate envoye au serveur", 
	httpMethod = "GET", response = List.class)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Film> listeDesFilmsHQLFETCH() {

		LOGGER.info("Starting Liste Des Films Services Avec HQL FETCH ");
		return serviceHbn.listeDesFilmsViaHBNHQL();
	}
	
	@GET
	@Path("/listeDesInternautesCRI")
	@ApiOperation(value = "Un service qui liste les Internautes dans NOTRE SI de CINEMA en Hibernate Criteria", 
	notes = "listeDesFilmsCRI  :Donne la liste des Internautes sui ont noté les fims  dans notre base de donnees ", 
	httpMethod = "GET", response = List.class)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Internaute> listeDesInternautesCRI() {

		LOGGER.info("Starting Liste Des Internautes Services Avec Criteria");
		return serviceHbn.listeDesInternautesViaCRI();
	}
	
	@POST
	@Path("/createFilmFromScratch")
	@ApiOperation(value = "Service de creation de Film A partir de rien  , fait dans le code  code", 
	notes = "Un service de creation de Film a partir de rien, fait dan le Code  ", 
	httpMethod = "POST", response = Film.class)
	@Produces(MediaType.APPLICATION_JSON)
	public Film  createFilmFromScratch() {

		Film film = serviceHbn.persistFilmFromScratch();
		LOGGER.info(film.toString());
		LOGGER.info("End Of persist of the Country in The Web Service return  ");
		return film ;
	}
	
	
}
