package edu.aa12;

import java.util.Arrays;
import java.util.List;

import lpsolve.LpSolve;
import lpsolve.LpSolveException;

public class RelaxILPLowerBound implements ILowerBound {

	private LpSolve LP = null;
	private double minLowerBound = 0;

	@Override
	public double lowerBound(Graph g, BnBNode node) {

		setupLP(g, node);

		return minLowerBound;
		
	}

	private void setupLP(Graph g, BnBNode node) {
		LPfrom(g, node);

		try {
			LP.solve();

			minLowerBound = LP.getObjective();
			
			LP.deleteLp();
		} catch (LpSolveException lpe) {
			lpe.printStackTrace();
		}
	}

	private void LPfrom(Graph graph, BnBNode node) {
		
		int n = graph.edges.size();
		
		try {
			LpSolve solver = LpSolve.makeLp(0, graph.edges.size());
			
			// Build objective function
			// We have |E| variables
			double[] obj = new double[graph.edges.size()];
			for (int i=0; i < graph.edges.size(); i++) {
				obj[i] = graph.getLength(graph.edges.get(i));
			}
			solver.strSetObjFn(ary2str(obj));
			
			
			int[] constraint = new int[graph.edges.size()];
			
			
			List<Edge> incEdges = node.getIncludedEdges();
			List<Edge> exEdges  = node.getExcludedEdges(); 
			
			// Step through our vertices - add a constraint row for each
			for (int i=0; i < graph.getVertices(); i++) {
				
				for (int j=0; j < graph.edges.size(); j++) {
					Edge e = graph.edges.get(j);
					
					if (e.v == i || e.u == i)
						constraint[j] = 1;
					else
						constraint[j] = 0;

					// Extra constraints
					// for all edges included, add constraint that this variable is 1
					// for all edges _excluded_ add constraint that this variable is 0
					if (incEdges.contains(e)) {
						int[] mustBe1 = new int[graph.edges.size()];
						mustBe1[j] = 1;
						solver.strAddConstraint(ary2str(mustBe1), LpSolve.EQ, 1);
					}
					else if (exEdges.contains(e)) {
						int[] mustBe1 = new int[graph.edges.size()];
						mustBe1[j] = 1;
						solver.strAddConstraint(ary2str(mustBe1), LpSolve.EQ, 0);
					}
				}
				solver.strAddConstraint(ary2str(constraint), LpSolve.EQ, 2);
			}

			// indicate whether min or max problem
			solver.setMinim();

			// Make it shut up
			solver.setVerbose(0);

			// solve
			this.LP = solver;

		} catch (LpSolveException lpe) {
			lpe.printStackTrace();
		}
	}
	
	private String ary2str(double[] ary) {
		return Arrays.toString(ary)
				.replace(",", "")
				.replace("[", "")
				.replace("]", "").trim();
	}
	
	private String ary2str(int[] ary) {
		return Arrays.toString(ary)
				.replace(",", "")
				.replace("[", "")
				.replace("]", "").trim();
	}

}
