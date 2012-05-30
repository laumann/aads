package edu.aa12;

/**
 * Here's a wicked-ass comment (or wicked ass-comment)
 *
 */
public class MainMethods {

	public static void main(String[] args){
//        solveGraph(new Instance0());	// Our own little test instance
		solveGraph(new Instance1());
		solveGraph(new Instance2());
//		solveGraph(new Instance3());
	}
	
	public static void solveGraph(Graph g){
		// Naive strategy
		BranchAndBound_TSP solver = new BranchAndBound_TSP(g, new SimpleStrategy());
		long start = System.nanoTime();
		BnBNode n = solver.solve();
		long end = System.nanoTime();
		System.out.printf("Took %.2fms\n",(end-start)/1000000.0);

		/*
		 * Possible strategies to give the BnB solver:
		 *  - SimpleStrategy
		 *  - OneTreeStrategy
		 *  - OneTreeStrategyVx, where x is a number in the range: { 2, 3, 4, 5, 6, 7 }
		 *  - ZonesLowerBound
		 *  - RelaxILPLowerBound  
		 */
		BranchAndBound_TSP zonesSolver = new BranchAndBound_TSP(g, new RelaxILPLowerBound());
		long zstart = System.nanoTime();
		BnBNode zonesNode = zonesSolver.solve();
		long zend = System.nanoTime();
		System.out.printf("Took %.2fms\n",(zend-zstart)/1000000.0);
		
//		System.out.println(zonesNode);
		Visualization.visualizeSolution(g, n);//Requires ProGAL (www.diku.dk/~rfonseca/ProGAL)
	}
}
