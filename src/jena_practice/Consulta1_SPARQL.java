package jena_practice;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;

public class Consulta1_SPARQL {

	public static void main(String[] args) {
		
		FileManager.get().addLocatorClassLoader(Consulta1_SPARQL.class.getClassLoader());
		Model model = FileManager.get().loadModel("src/owl/data.ttl");
		
		// Hacer un String de consulta
		String queryString = 
				"PREFIX foaf: <http://xmlns.com/foaf/0.1/>" +
				"SELECT ?name WHERE { " +
				"	?person foaf:mbox <mailto:alice@example.org> ." +
				"	?person foaf:name ?name " +
				"}";
		
		Query query = QueryFactory.create(queryString); // Crea un objeto para consulta
		QueryExecution qexec = QueryExecutionFactory.create(query, model); // Ejecutar la consulta SPARQL
		
		try {
			ResultSet results = qexec.execSelect();
				while (results.hasNext()) {
					QuerySolution soln = results.nextSolution();
					Literal name = soln.getLiteral("name");
					System.out.println(name);
				} 
			} finally {
				qexec.close();
		}				
	}
}
