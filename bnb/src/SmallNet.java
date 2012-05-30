import lpsolve.*;

class SmallNet extends MF {
	public static void main(String[] args) {
		int[][] cs = new int[5][5];
		uconnect(0, 1, 5, cs);
		uconnect(0, 2, 10, cs);
		uconnect(1, 3, 7, cs);
		uconnect(2, 3, 7, cs);
		uconnect(2, 4, 3, cs);
		uconnect(3, 4, 12, cs);

		print(cs);
		int[] sources = new int[1];
		sources[0] = 3;

		int s = 0;
		int t = 4;

		int[][] cost = new int[5][5];
		uconnect(2, 3, 1, cost);
		// cost = mkCost(cost, cs);

		// cs = conv2MaxFlow(cs);
		// since it already is a max flow

		// print(cs);
		// print(cost);
		int[][] map = createmap(cs);
		try {
			LpSolve solver = MF.conv2LP(cs, s, t, map);
			solver.solve();
			double objective = solver.getObjective();
			System.out.println("Value of objective function: " + solver.getObjective());
			double[] var = solver.getPtrVariables();
			for (int i = 0; i < var.length; i++) {
				System.out.println("Value of var[" + i + "] = " + var[i]);
			}
			// solver.printDuals();

			System.out.println("min cost:");
			LpSolve mincost = conv2MinCostLP(cs, cost, map, s, t, objective);
			mincost.solve();
			System.out.println("Value of objective function: " + mincost.getObjective());
			var = mincost.getPtrVariables();
			for (int i = 0; i < var.length; i++) {
				System.out.println("Value of var[" + i + "] = " + var[i]);
			}

			// mincost.printLp();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
