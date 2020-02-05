package jena_practice;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.query.ResultSet;

public class Consulta3_SPARQL {

	public static void main(String[] args) {

		String sparqlQueryString1 = "PREFIX dbont: <http://dbpedia.org/ontology/> " +
				"PREFIX dbp: <http://debpedia.org/property/> " +
				"PREFIX geo: <http://www.w3.org/2003/01/geo/wgs84_pos#> " +
				"	SELECT ?musician ?place" +
				"	WHERE { " +
				"		?musician dbont:birthPlace ?place " +
				"	}";
		
		// Crear el objeto de consulta
		Query query = QueryFactory.create(sparqlQueryString1);
		// Realiza la consulta al endpoint the dbpedia
		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
		
		// Luego procesar la ejecucion de la consulta y su resultado
		
		try {
			ResultSet results = qexec.execSelect();
			ResultSetFormatter.out(System.out, results, query);
		} finally {
			qexec.close();
		}
	}
}
