package edu.aa12;

/** 
 * Graph with 30 vertices distributed roughly on a circle and 66 edges corresponding 
 * to an alpha-complex with alpha = 2.
 */
public class Instance2 extends Graph{
	private static double[][] coords = new double[][]{
		new double[]{-3.44,0.87},
		new double[]{-3.16,0.72},
		new double[]{-3.04,-0.07},
		new double[]{-2.40,-1.81},
		new double[]{-2.25,-1.69},
		new double[]{-1.88,-2.13},
		new double[]{-1.14,2.08},
		new double[]{-0.94,-2.32},
		new double[]{-0.94,2.65},
		new double[]{-0.89,2.19},
		new double[]{-0.55,-2.26},
		new double[]{-0.45,2.59},
		new double[]{-0.35,2.39},
		new double[]{0.43,1.92},
		new double[]{0.46,-2.27},
		new double[]{0.70,2.33},
		new double[]{0.95,-2.22},
		new double[]{0.96,-2.02},
		new double[]{1.26,1.43},
		new double[]{1.28,-2.00},
		new double[]{1.54,1.56},
		new double[]{1.55,-1.98},
		new double[]{1.57,-1.82},
		new double[]{1.61,0.79},
		new double[]{1.79,0.05},
		new double[]{1.83,-0.96},
		new double[]{2.01,-1.29},
		new double[]{2.08,1.13},
		new double[]{2.11,-0.73},
		new double[]{2.41,-0.37},
	};

	public Instance2(){
		super(coords);

		createEdge(0,1);
		createEdge(0,2);
		createEdge(0,6);
		createEdge(1,2);
		createEdge(1,6);
		createEdge(2,3);
		createEdge(2,4);
		createEdge(2,6);
		createEdge(3,4);
		createEdge(3,5);
		createEdge(4,5);
		createEdge(4,7);
		createEdge(4,10);
		createEdge(5,7);
		createEdge(6,8);
		createEdge(6,9);
		createEdge(6,13);
		createEdge(7,10);
		createEdge(8,9);
		createEdge(8,11);
		createEdge(9,11);
		createEdge(9,12);
		createEdge(9,13);
		createEdge(10,14);
		createEdge(10,17);
		createEdge(10,24);
		createEdge(11,12);
		createEdge(11,15);
		createEdge(12,13);
		createEdge(12,15);
		createEdge(13,15);
		createEdge(13,18);
		createEdge(13,23);
		createEdge(14,16);
		createEdge(14,17);
		createEdge(15,18);
		createEdge(15,20);
		createEdge(16,17);
		createEdge(16,19);
		createEdge(16,21);
		createEdge(17,19);
		createEdge(17,22);
		createEdge(17,24);
		createEdge(17,25);
		createEdge(18,20);
		createEdge(18,23);
		createEdge(19,21);
		createEdge(19,22);
		createEdge(20,23);
		createEdge(20,27);
		createEdge(21,22);
		createEdge(21,26);
		createEdge(22,25);
		createEdge(22,26);
		createEdge(23,24);
		createEdge(23,27);
		createEdge(24,25);
		createEdge(24,27);
		createEdge(24,28);
		createEdge(24,29);
		createEdge(25,26);
		createEdge(25,28);
		createEdge(26,28);
		createEdge(26,29);
		createEdge(27,29);
		createEdge(28,29);
	}

}
