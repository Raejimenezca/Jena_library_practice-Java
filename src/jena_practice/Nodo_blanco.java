package jena_practice;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.*;

public class Nodo_blanco {
	
	//Algunas definiciones
	static String personURI = "http://algunLugar/RafaelJimenez";
	static String givenName = "Rafael";
	static String familyName = "Jimenez";
	static String fullName = givenName + " " + familyName;

	public static void main(String[] args) {
		
		// Crea un modelo vacio
		Model model = ModelFactory.createDefaultModel();
		
		// Crea el recurso y las propiedades en estilo cascada
		Resource rafaelJimenez = model.createResource(personURI)
				.addProperty(VCARD.FN, fullName)
				.addProperty(VCARD.N, 
						model.createResource()
						.addProperty(VCARD.Given, givenName)
						.addProperty(VCARD.Family, familyName));
		
		// Escribe el modelo en forma de XMl
		model.write(System.out);

	}

}
