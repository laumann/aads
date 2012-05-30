package edu.aa12;

import lpsolve.LpSolve;
import lpsolve.LpSolveException;

public class ZonesLowerBound implements ILowerBound {

	private LpSolve LP = null;
	private double minLowerBound = -1;

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
				// Construct LP
				LPfrom(g, node);
				
				
				// Solve and store value of optimal
				LP.solve();
				minLowerBound = LP.getObjective(); 
				
//				Debugging:
//				LP.printLp();
//				LP.printObjective();
//				System.out.println("Lower bound: " + minLowerBound);
			}
			
			// Should modify the min lower bound here...
			
			
			return minLowerBound;
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
			
			// Add constraints
			// "0 0 0 .. 1 .. 0 0 ... 1 .. 0 0" <=
			for (int i = 0; i < g.getVertices() - 1; i++) {
				for (int j = i + 1; j < g.getVertices(); j++) {
					solver.strAddConstraint(constraintStr(i, j, g.getVertices()), LpSolve.LE, g.getDistance(i, j));
				}
			}

			// Add objective function
			// sum 2r_i
			StringBuilder obj = new StringBuilder();
			for (int i = 0; i < g.getVertices(); i++)
				obj.append("2 ");
			solver.strSetObjFn(obj.toString().trim());

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
