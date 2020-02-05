package jena_practice;

import java.io.InputStream;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.util.FileManager;

public class Statement_IO {

	public static void main(String[] args) {

		// Creates an in-memory jena Model
		Model model = ModelFactory.createDefaultModel(); 
		
		// Abrir el archivo en la ontología
		InputStream in = FileManager.get().open("src/owl/Robots.owl");
		model.read(in, null, "RDF/XML"); // parses an InputStream assuming RDF in Turtle format
		
		StmtIterator iter = model.listStatements();
		
		try {
			while (iter.hasNext()) {
				Statement stmt = iter.next();
				
				Resource s = stmt.getSubject();
				Resource p = stmt.getPredicate();
				RDFNode o = stmt.getObject();
				
				if (s.isURIResource()) {
					System.out.println("URI");
				}
				else if (s.isAnon()) {
					System.out.println("blank");
				}
				
				if (p.isURIResource()) {
					System.out.println("URI");
				}
				if (o.isURIResource()) {
					System.out.println("URI");
				}
				else if (o.isAnon()) {
					System.out.println("blank");
				}
				else if (o.isLiteral()) {
					System.out.println("Literal");
				}
				
				System.out.println();
			}
		} finally {
			if (iter != null) iter.close();
		}

	}

}
