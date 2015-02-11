package com.sobngwi.hibernate.nsy135.converters;

import com.sobngwi.hibernate.nsy135.modele.persistence.Pays;

public class Origine  {
	
	private  Pays pays ;

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public Origine(Pays pays) {
		this.pays = pays;
	}
	
	
	
}