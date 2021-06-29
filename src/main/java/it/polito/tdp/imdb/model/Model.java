package it.polito.tdp.imdb.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.imdb.db.ImdbDAO;

public class Model {

	private Graph<Director,DefaultWeightedEdge> grafo;
	private ImdbDAO dao;
	private Map<Integer, Director> map;
	
	public Model() {
		dao=new ImdbDAO();
		map=new HashMap<Integer,Director>();
	}
	public void creaGrafo(int anno) {
		
		grafo=new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(this.grafo, map.values());
		for(Adiacenza a: dao.getarchi(map,anno)) {
			
		}
	}
}
