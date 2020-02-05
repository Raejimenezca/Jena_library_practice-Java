package jena_practice;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSetFactory;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.query.ResultSetRewindable;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;

public class Consulta2_SPARQL {

	public static void main(String[] args) {

		FileManager.get().addLocatorClassLoader(Consulta2_SPARQL.class.getClassLoader());
		Model model = FileManager.get().loadModel("src/owl/data.ttl");
		
		String queryString = "SELECT * { ?s ?p ?o }";
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		
		try {
			ResultSetRewindable results = ResultSetFactory.makeRewindable(qexec.execSelect());
			
			// Realiza la consulta y presenta los resultados en diferentes formatos
			
			System.out.println("---- XML ----");
			ResultSetFormatter.outputAsXML(System.out, results);
			results.reset();
			System.out.println("---- Text ----");
			ResultSetFormatter.out(System.out, results);
			results.reset();
			System.out.println("---- CSV ----");
			ResultSetFormatter.outputAsCSV(System.out, results);
			results.reset();
			System.out.println("---- JSON ----");
			ResultSetFormatter.outputAsJSON(System.out, results);
			results.reset();
		} finally {
			qexec.close();
		}
	}
}
