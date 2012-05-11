import lpsolve.*;


public class MF {
    
     public static int cntE(int [][] cs) {
	int cnt = 0;
	for (int i = 0; i < cs.length; i++) {
	    for (int j = 0; j < cs.length; j++) {
		if (cs[i][j] != 0) cnt ++;
	    }
	}
	return cnt;
    }

    public static int cntV(int [][] cs) {
	return cs.length;
    }

    public static int[][] conv2MaxFlow(int [][]cs)
    {
	int V = cntV(cs);
	int E = cntE(cs)/2;
	int[][] nw = new int[V+E][V+E];
	int cap;
	int insert = cs.length;
	
	for (int from = 0; from < cs.length; from++)
	    for (int to = from+1; to < cs.length; to++) {
		if (cs[from][to] != 0) {
		    cap = cs[from][to];
		    nw[from][to] = cap;
		    nw[to][insert] = cap;
		    nw[insert][from] = cap;
		    insert++;
		}
	    }
	
	return nw;
    }

    public static int[][] addSuperSource(int [][] cs, int[] sources)
    {
	int V = cntV(cs);
	int [][] nw = new int[V+1][V+1];
	for (int i = 0; i < cs.length; i++) {
	    for (int j = 0; j < cs.length; j++) {
		nw[i+1][j+1] = cs[i][j];
	    }
	}

	//	for (int i = 0; i < sources.length; i++) {
	for (int source: sources) {
	    nw[0][source+1] = 999;
	}
	return nw;
    }

    public static int[][] createmap(int [][] cs) {

	int cnt = 0;
	int [][] map = new int[cs.length][cs.length];
	for (int i = 0; i < cs.length; i++) {
	    for (int j = 0; j < cs.length; j++) 
		
		if (cs[i][j] != 0) {
		    map[i][j] = cnt;
		    cnt ++;
		} else {
		    map[i][j] = -1;
		}
	}

	return map;

    }

    public static LpSolve conv2LP(int[][] cs, int s, int t) throws LpSolveException{
	int E = cntE(cs);
	int V = cntV(cs);
	LpSolve solver = LpSolve.makeLp(0, E);
	int [][] map = createmap(cs);

	// GENERATE capacity constraints
	for (int from = 0; from < cs.length; from++) {
	    for (int to = 0; to < cs.length; to++) {
		if (cs[from][to] != 0) {
		    int [] constr = new int[E];
		    constr[map[from][to]] = 1;
		    solver.strAddConstraint(constrStr(constr), LpSolve.LE, cs[from][to]);
		}
	    }
	}

	// GENERATE in-out-equalities
	for (int u = 0; u < cs.length; u++) {   
	    if (u != s && u != t) {
		int [] constr = new int[E];
		for (int v = 0; v < cs.length; v++) {
		    if (cs[v][u] != 0) {
			constr[map[v][u]] = 1;
		    }
		    if (cs[u][v] != 0) {
			constr[map[u][v]] = -1;
		    }
		}
		solver.strAddConstraint(constrStr(constr), LpSolve.EQ, 0);
	    }
	}
		

	// GENERATE objective function
	int [] obj = new int[E];
	for (int i = 0; i < cs.length; i++) {
	    if (cs[s][i] != 0) {
		obj[map[s][i]] = 1;
	    }
	    if (cs[i][s] != 0) {
		obj[map[i][s]] = -1;
	    }
	}

	solver.strSetObjFn(constrStr(obj));

	// other options
	solver.setMaxim();
	solver.setLpName("Converted max flow");
	solver.setVerbose(3);

	solver.solve();

	return solver;
    }


    public static String constrStr(int[] c) {
	StringBuilder str = new StringBuilder(c.length*3);
	for (int i : c) {
	    str.append(i);
	    str.append(' ');
	}
	return str.toString();
    }


  public static void connect(int i, int j, int capacity, int[][] cs){
    cs[i][j] = cs[j][i] = capacity;

  }

  public   static void print(int [][] cs) {
	System.out.println();
	System.out.println();
	System.out.printf("    ");
	System.out.printf("    ");
	for(int j=0;j<cs[0].length;j++){
		System.out.printf("%4d",j);
	    }
	System.out.println();
	System.out.println();
	for(int i=0;i<cs.length;i++){
	    System.out.printf("%4d",i);
		
	    System.out.printf("    ");

	    for(int j=0;j<cs[0].length;j++){
		System.out.printf("%4d",cs[i][j]);
	    }
	    System.out.println();
	}
    }
}