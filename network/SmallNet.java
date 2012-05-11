import lpsolve.*;

class SmallNet extends MF {
    public static void main(String[] args) {
	int [][] cs = new int[5][5];
	connect(0, 1, 5, cs);
	connect(0, 2, 10, cs);
	connect(1, 3, 7, cs);
	connect(2, 3, 7, cs);
	connect(2, 4, 3, cs);
	connect(3, 4, 12, cs);
	
	print(cs);
	int[] sources = new int[1];
	sources[0] = 3;

	int s = 0;
	int t = 4;
	
	int[][] cost = new int[5][5];
	connect(2, 3, 1, cost);
	cost = mkCost(cost, cs);

	cs = conv2MaxFlow(cs);
	print(cs);
	print(cost);
	int [][] map = createmap(cs);
	try {
	    LpSolve solver = MF.conv2LP(cs, 0, 4, map);
	    solver.solve();
	    double objective = solver.getObjective();
	    System.out.println("Value of objective function: " + solver.getObjective());
	    double[] var = solver.getPtrVariables();
	    for (int i = 0; i < var.length; i++) {
		System.out.println("Value of var[" + i + "] = " + var[i]);
	    }

	    System.out.println("min cost:");	    
	    LpSolve mincost = conv2MinCostLP(cs, cost, map, s, t, objective);
	    mincost.solve();
	    System.out.println("Value of objective function: " + solver.getObjective());
	    var = solver.getPtrVariables();
	    for (int i = 0; i < var.length; i++) {
		System.out.println("Value of var[" + i + "] = " + var[i]);
	    }


	} catch (Exception e) {
	    e.printStackTrace();
	}
    

    }
}
