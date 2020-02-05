package jena_practice;

import java.io.InputStream;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;

public class Lectura_archivos_manejo_formatos {
	public static void main(String[] args) {
			
		// Creates in-memory model
		Model model = ModelFactory.createDefaultModel();
		
		// Abrir el archivo con la ontología
		InputStream in = FileManager.get().open("src/owl/mammals.ttl");
		model.read(in , null, "TURTLE"); // parses an InputStream assuming RDF in Turtle format
		
		//Write the jena model in Turtle, RDF/XML and N-Triples format
		System.out.println("\n---- Turtle ----");
		model.write(System.out, "TURTLE");
		System.out.println("\n---- RDF/XML ----");
		model.write(System.out, "RDF/XML");
		System.out.println("\n---- RDF/XML Abbreviated ----");
		model.write(System.out, "RDF/XML-ABBREV");
		System.out.println("\n---- N-Triples ----");
		model.write(System.out, "N-TRIPLES");
		System.out.println("\n---- RDF/JSON ----");
		model.write(System.out, "RDF/JSON");
	
	}
}
