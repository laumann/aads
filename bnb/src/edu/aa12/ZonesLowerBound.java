package edu.aa12;

import java.util.List;

import lpsolve.LpSolve;
import lpsolve.LpSolveException;

public class ZonesLowerBound implements ILowerBound {

	private LpSolve LP = null;
	private double minLowerBound = -1;
	private double[] radii = null;

	private String constraintStr(int i, int j, int n) {
		StringBuilder constraint = new StringBuilder();

		for (int k = 0; k <= n; k++)
			if (k == i || k == j)
				constraint.append("1 ");
			else
				constraint.append("0 ");

		return constraint.toString().trim();
	}

	@Override
	public double lowerBound(Graph g, BnBNode node) {
		
		
		
		// LpSolve, you suck! I don't want try-catch nightmare.
		try {
			// Only compute the linear program once
			if (LP == null) {
				LPfrom(g, node);
				LP.solve();
//				LP.printLp();
				
				
				/* Store some values */
				minLowerBound = LP.getObjective();
				radii = LP.getPtrVariables();
				
				System.out.println("[ ");
				for (double d : radii) {
					System.out.print("    " + d);
				}
				System.out.println(" ]");
				
				System.out.println("Minimal lower bound: " + minLowerBound);
				
				double sum = 0;
				for (double r : radii)
					sum += r;
				System.out.println("minLowerBound - 2*sum = " + (minLowerBound-2*sum));
			}
			
			/* TODO Improve on the lower bound given information on the branch node */
			double newBound = minLowerBound;
			
			// Get included edges
			List<Edge> incEdges = node.getIncludedEdges();
			for (Edge e : incEdges) {
				newBound = newBound - radii[e.u] - radii[e.v] + g.getLength(e);
			}
			
//			List<Edge> exEdges = node.getExcludedEdges();
//			for (Edge e : exEdges) {
//				
//			}
			
//			if (newBound != minLowerBound)
//				System.out.println("New lower bound: " + newBound);
		
			
			
			
			return (newBound > minLowerBound) ? newBound : minLowerBound;
		} catch (LpSolveException lpe) {
			lpe.printStackTrace();
		}
		
		return 0;
	}

	private void LPfrom(Graph g, BnBNode node) {
		System.out.println("Generating LP.");
		try {
			// Create solver
			LpSolve solver = LpSolve.makeLp(0, g.getVertices());

			// Add objective function
			// String of "2 2 2 2 2 ... 2"
			StringBuilder obj = new StringBuilder();
			for (int i = 0; i < g.getVertices(); i++)
				obj.append("2 ");

			solver.strSetObjFn(obj.toString().trim());
			solver.setAddRowmode(true);
			
			int numConstraints = 0;
			// Add constraints
			// "0 0 0 .. 1 .. 0 0 ... 1 .. 0 0" <=
//			for (Edge edge : g.edges) {
////				if (g.getLength(edge) == Double.POSITIVE_INFINITY) 
////					continue;
//				
//				solver.strAddConstraint(constraintStr(edge.v, edge.u, g.getVertices()), LpSolve.LE, g.getLength(edge));
//				numConstraints++;
//			}
			System.out.println("Added " + numConstraints + " constraints!");

			numConstraints = 0;
			for (int i = 0; i < g.getVertices() - 1; i++) {
				for (int j = i + 1; j < g.getVertices(); j++) {
					solver.strAddConstraint(constraintStr(i, j, g.getVertices()), LpSolve.LE, g.getDistance(i, j));
					numConstraints++;
				}
			}
			System.out.println("Other method adds " + numConstraints + " constraints!");

			// indicate whether min or max problem
			solver.setMaxim();

			// Make it shut up
			solver.setVerbose(0);
			
			// solve
			this.LP = solver;

		} catch (LpSolveException lpe) {
			lpe.printStackTrace();
		}
	}
}
