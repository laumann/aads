package edu.aa12;

/** 
 * A graph with 9 randomly distributed vertices, that are fully connected by 72 edges
 */
public class Instance0 extends Graph{
	private static double[][] coords = new double[][]{
			new double[]{0,0},
			new double[]{0,1},
			new double[]{1,-1},
			new double[]{1,1},

	};

	public Instance0(){
		super(coords);
		int n = vertexCoords.length;
		for(int i=0;i<n;i++) 
			for(int j=i+1;j<n;j++) 
				createEdge(i, j);

	}
}
