package  com.sobngwi.hibernate.nsy135.converters ;
     
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.sobngwi.hibernate.nsy135.modele.persistence.Pays;


public class PaysToOrigine implements Converter<Pays,Origine>{

	@Override
	public Origine convert(Pays source) {
		
		if ( source.getCode().equals("CM") ) source.setCode("CAMER");
		    System.out.println("CONVERSION ===" + source.getCode() );
		return new Origine (source);
	}

}


	
	
