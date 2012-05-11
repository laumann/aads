import lpsolve.*;

public class Network extends MF {


  public static void main(String[] args) {
    int[][] cs = new int[27][27];
   
    connect(0	,	7	,	10	, cs);
    connect(0	,	6	,	20	, cs);
    connect(1	,	7	,	10	, cs);
    connect(1	,	8	,	10	, cs);
    connect(2	,	3	,	15	, cs);
    connect(2	,	8	,	40	, cs);
    connect(2	,	9	,	25	, cs);
    connect(3	,	9	,	5	, cs);
    connect(4	,	9	,	10	, cs);
    connect(4	,	10	,	10	, cs);
    connect(5	,	10	,	10	, cs);
    connect(6	,	7	,	10	, cs);
    connect(6	,	18	,	20	, cs);
    connect(7	,	8	,	10	, cs);
    connect(7	,	18	,	10	, cs);
    connect(8	,	12	,	10	, cs);
    connect(9	,	11	,	15	, cs);
    connect(9	,	12	,	20	, cs);
    connect(10	,	11	,	20	, cs);
    connect(11	,	13	,	20	, cs);
    connect(11	,	14	,	20	, cs);
    connect(12	,	15	,	30	, cs);
    connect(12	,	17	,	30	, cs);
    connect(12	,	23	,	10	, cs);
    connect(13	,	14	,	10	, cs);
    connect(13	,	15	,	40	, cs);
    connect(14	,	15	,	10	, cs);
    connect(14	,	19	,	30	, cs);
    connect(15	,	16	,	10	, cs);
    connect(15	,	24	,	10	, cs);
    connect(15	,	19	,	30	, cs);
    connect(16	,	19	,	50	, cs);
    connect(16	,	24	,	200	, cs);
    connect(16	,	25	,	200	, cs);
    connect(17	,	18	,	30	, cs);
    connect(17	,	23	,	10	, cs);
    connect(18	,	20	,	10	, cs);
    connect(18	,	21	,	10	, cs);
    connect(20	,	22	,	50	, cs);
    connect(20	,	26	,	50	, cs);
    connect(21	,	22	,	50	, cs);
    connect(21	,	23	,	50	, cs);
    connect(22	,	23	,	50	, cs);
    connect(22	,	24	,	50	, cs);
    connect(22	,	25	,	50	, cs);
    connect(22	,	26	,	50	, cs);
    connect(23	,	24	,	50	, cs);
    connect(25	,	26	,	50	, cs);

    int[][] cost = new int[27][27];
    connect(18, 20, 1, cost);
    connect(18, 21, 1, cost);
    connect(17, 23, 1, cost);
    connect(12, 23, 1, cost);
    connect(15, 24, 1, cost);
    connect(16, 24, 1, cost);
    connect(16, 25, 1, cost);
    

    cost = mkCost(cost, cs);
    cost = addSuperSource(mkCost(cost, cs), new int[0]);
	
    //print(cs);

    int[] sources = new int[6];
    sources[0] = 0;
    sources[1] = 1;
    sources[2] = 2;
    sources[3] = 3;
    sources[4] = 4;
    sources[5] = 5;
    String[] imap = createimap(cs, sources, 19);
    cs = addSuperSource(conv2MaxFlow(cs), sources);	


	int [][] map = createmap(cs);
	
	//print(cs);
	//print(cost);
	try {
	    int s = 0;
	    int t = 20;
	    int E = cntE(cs);
	    LpSolve solver = MF.conv2LP(cs, s, t, map);
	    solver.solve();
	    double objective = solver.getObjective();

	    System.out.println("Value of objective function: " + solver.getObjective());
	    double[] var = solver.getPtrVariables();
	    for (int i = 0; i < var.length; i++) {
		System.out.println("Flow[" + imap[i] + "] = " + var[i]);
	    }


	    System.out.println("min cost:");	    
	    LpSolve mincost = conv2MinCostLP(cs, cost, map, s, t, objective);
	    mincost.solve();
	    System.out.println("Value of objective function: " + mincost.getObjective());
	    var = mincost.getPtrVariables();
	    for (int i = 0; i < var.length; i++) {
		System.out.println("Flow[" + imap[i] + "] = " + var[i]);
	    }


	} catch (Exception e) {
	    e.printStackTrace();
	}


  }


}
