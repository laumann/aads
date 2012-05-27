package edu.aa12;

import java.util.Comparator;
import java.util.PriorityQueue;

import edu.aa12.DisjointSet.DSNode;

/**
 * An implementation of branch-and-bound for TSP with the lower-bound method missing.
 */
public class BranchAndBound_TSP {
	/** Finds the minimum spanning tree using Kruskals algorithm */
	private final Kruskal kruskal = new Kruskal();
	private final Graph graph;
	/** The number of BnBNodes generated */
	private long nodesGenerated = 0;
	
	/** Construct a problem instance */
	public BranchAndBound_TSP(Graph g){
		graph = g;
	}
	
	/** Find the shortest tour visiting all nodes exactly once and return the result as a BnBNode. */
	public BnBNode solve(){
		//Sorting edges by length might or might not help
//		Collections.sort(graph.edges, new Comparator<Edge>(){
//			public int compare(Edge arg0, Edge arg1) {
//				return -Double.compare(graph.getLength(arg0),graph.getLength(arg1));
//			}});
		
		//The ordering in the nodePool determines which nodes gets polled first. 
		PriorityQueue<BnBNode> nodePool = new PriorityQueue<BnBNode>(10000,	new Comparator<BnBNode>(){
			public int compare(BnBNode n0, BnBNode n1) {
				return Double.compare(n0.lowerBound, n1.lowerBound);//Best-first
				//return (n0.depth-n1.depth);//Breadth-first
				//return (n1.depth-n0.depth);//Depth-first
			}});
		
		BnBNode root = new BnBNode(null,null, false);
		root.lowerBound = Double.POSITIVE_INFINITY;
		nodePool.add(root);
		
		BnBNode best = root;
		
		while(!nodePool.isEmpty()){
			BnBNode node = nodePool.poll();
			if(node.edgesDefined==(graph.getVertices())){
				if(node.lowerBound<best.lowerBound) best = node;
			}else{
				if(node.lowerBound<=best.lowerBound){
					branch(node,nodePool);
				}
			}
		}
		
		System.out.printf("Finished branch-and-bound. Path-length: %.3f, %d nodes generated\n",best.lowerBound, nodesGenerated);
		return best;
	}
	
	/** 
	 * Branch on a node, generating either 0, 1 or 2 new children of the node. A child is only generated 
	 * if it does not result in a sub-tour, a vertex with degree more than 2, or a vertex where the degree 
	 * can never become 2.    
	 */ 
	private void branch(BnBNode node, PriorityQueue<BnBNode> nodePool){
		if(graph.edges.indexOf(node.edge)==graph.edges.size()-1) return;
		
		//Choose next edge to branch on. Uses the ordering in graph.edges.
		Edge nextEdge = graph.edges.get(graph.edges.indexOf(node.edge)+1);
		
		//Represent graph components as sets (used to detect subtours) 
		DisjointSet ds = new DisjointSet();
		DSNode[] vertexSets = new DSNode[graph.getVertices()];
		for(int i=0;i<graph.getVertices();i++)
			vertexSets[i] = ds.makeSet(i);
		BnBNode n = node;
		while(n.parent!=null){
			if(n.edgeIncluded) {
				ds.union(vertexSets[n.edge.u], vertexSets[n.edge.v]);
			}
			n=n.parent;
		}


		//Check out-degree<=2 and in-degree>=2
		//Find maximum adjacent edges (could be optimized away using an array)
		int uAdjMax = graph.incidentEdges[nextEdge.u].size();
		int vAdjMax = graph.incidentEdges[nextEdge.v].size();
		int uAdj = 0, vAdj = 0;
		//Find length of defined edges
		n = node;
		while(n.parent!=null){
			if(n.edgeIncluded){
				if(n.edge.u==nextEdge.u||n.edge.v==nextEdge.u) uAdj++;
				if(n.edge.u==nextEdge.v||n.edge.v==nextEdge.v) vAdj++;
			}else{
				if(n.edge.u==nextEdge.u||n.edge.v==nextEdge.u) uAdjMax--;
				if(n.edge.u==nextEdge.v||n.edge.v==nextEdge.v) vAdjMax--;
			}
			n=n.parent;
		}
		
		//Exclude nextEdge (assuming constraints can be met)
		if(uAdjMax>2 && vAdjMax>2){
			n = new BnBNode(node, nextEdge, false);
			n.lowerBound = lowerBound(n);
			nodePool.add(n);
			nodesGenerated++;
		}
		
		//Include nextEdge (assuming constraints can be met)
		if( (node.edgesDefined==graph.getVertices()-1||ds.find(vertexSets[nextEdge.u])!=ds.find(vertexSets[nextEdge.v])) && uAdj<2 && vAdj<2){
			n = new BnBNode(node,nextEdge,true);
			n.lowerBound = lowerBound(n);
			nodePool.add(n);
			nodesGenerated++;
		}
		
	}
	
	/** Return a lower-bound for the node */
	public double lowerBound(BnBNode node){
		if(node.edgesDefined==graph.getVertices()) {
			return objectiveValue(node);
		}

		//TODO: See assignment text
		
		return 0;
	}
	
	/** Assuming that n represents a valid hamiltonian tour return the length of the tour */
	public double objectiveValue(BnBNode n){
		//Find length of defined edges
		double pathLength = 0;
		while(n.parent!=null){
			if(n.edgeIncluded)
				pathLength += graph.getDistance(n.edge.u, n.edge.v);
			n=n.parent;
		}
		return pathLength;
	}
	
}
