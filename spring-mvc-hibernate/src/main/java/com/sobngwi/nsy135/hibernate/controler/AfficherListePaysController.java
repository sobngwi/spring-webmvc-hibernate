package com.sobngwi.nsy135.hibernate.controler;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sobngwi.hibernate.nsy135.modele.persistence.Pays;
import com.sobngwi.hibernate.nsy135.modele.service.IServiceHibernate;


@Controller
@RequestMapping(value="/afficherListePays")
public class AfficherListePaysController {

    @Inject
    private IServiceHibernate service;

    @RequestMapping(method = RequestMethod.GET)
    public String afficher(ModelMap pModel) {
    	
        final List<Pays> lListeDesPays = service.listeDesPaysViaHBNHQL();
        pModel.addAttribute("listeDesPays", lListeDesPays);
        return "listeDesPays";
    }
}