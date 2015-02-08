package com.sobngwi.nsy135.hibernate.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bonjour/{personne}")
            
public class BonjourController {

	
	 @RequestMapping(method = RequestMethod.GET)
	    public String afficherBonjour(final ModelMap pModel, 
	                @PathVariable(value="personne") final String pPersonne) {

	        pModel.addAttribute("personne", pPersonne);
	        return "bonjour";
	    }
}