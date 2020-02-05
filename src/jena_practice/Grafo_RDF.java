package jena_practice;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

public class Grafo_RDF {
	
	// Some definitions
	static String personURI = "http://algunLugar/RafaelJimenez";
	static String fullName = "Rafael Jimenez";

	public static void main(String[] args) {

		// Create an empty Model (empty graph)
		Model model = ModelFactory.createDefaultModel();
		
		// Create the resource
		Resource jaimeGuzman = model.createResource(personURI);
		
		// Add the property 
		jaimeGuzman.addProperty(VCARD.FN, fullName);
		
		// Write the model in XML form to a file
		model.write(System.out);

	}

}
