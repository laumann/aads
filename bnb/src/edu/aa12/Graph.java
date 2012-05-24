package edu.aa12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** A representation of an undirected graph. Vertices are implicitly represented as numbers from 0 to (getVertices()-1). */
public abstract class Graph {
	public final double[][] vertexCoords;
	/** An array of lists. The i'th entry indicates the edges adjacent to vertex i */
	public final List<Edge> edges;
	/** An array of lists. The i'th entry indicates the edges adjacent to vertex i */
	public final List<Edge>[] incidentEdges;
	protected final double[][] distances;
	
	@SuppressWarnings("unchecked")
	Graph(double[][] coords){
		this.vertexCoords = coords;
		int n = vertexCoords.length;
		this.edges = new ArrayList<Edge>();
		this.incidentEdges = new List[n];
		for(int i=0;i<n;i++) incidentEdges[i]=new LinkedList<Edge>();
		this.distances = new double[n][n];
		for(int i=0;i<n;i++) for(int j=0;j<n;j++) distances[i][j] = Double.POSITIVE_INFINITY;

	}
	
	public int getVertices(){ return vertexCoords.length; }
	
	public double getDistance(int i, int j){ return distances[i][j]; }
	
	public double getLength(Edge e){
		return distances[e.u][e.v];
	}
	
	protected void createEdge(int i, int j){
		if(distances[i][j]<Double.POSITIVE_INFINITY) return;
		double dx = vertexCoords[i][0]-vertexCoords[j][0];
		double dy = vertexCoords[i][1]-vertexCoords[j][1];
		distances[i][j] = distances[j][i] = Math.sqrt( dx*dx+dy*dy );
		Edge e = new Edge(i,j);
		edges.add(e);
		incidentEdges[i].add(e);
		incidentEdges[j].add(e);
		
	}
}
