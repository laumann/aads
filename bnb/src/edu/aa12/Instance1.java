package edu.aa12;

/** 
 * A graph with 9 randomly distributed vertices, that are fully connected by 72 edges
 */
public class Instance1 extends Graph{
	private static double[][] coords = new double[][]{
			new double[]{2.51,-0.71},
			new double[]{1.90,-0.66},
			new double[]{2.11,-0.91},
			new double[]{2.35,-1.13},
			new double[]{2.16,-1.22},
			new double[]{-1.34,-1.02},
			new double[]{-1.12,-0.55},
			new double[]{-0.88,-0.92},
			new double[]{1.89,-0.50},
	};

	public Instance1(){
		super(coords);
		int n = vertexCoords.length;
		for(int i=0;i<n;i++) 
			for(int j=i+1;j<n;j++) 
				createEdge(i, j);

	}
}
