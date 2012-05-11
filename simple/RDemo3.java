import lpsolve.*;

public class RDemo3 {

  public static void main(String[] args) {
    try {
      // Create a problem with 4 variables and 0 constraints
      LpSolve solver = LpSolve.makeLp(0, 3);

      // add constraints
      solver.strAddConstraint("3 -2 0", LpSolve.LE, 6);
      solver.strAddConstraint("2 -1 -1", LpSolve.GE, 4);
      solver.strAddConstraint("1 2 3", LpSolve.LE, 10);

      // set objective function
      solver.strSetObjFn("-1 3 1");
      solver.setMaxim();
      solver.setLpName("Example from http://www.hs-augsburg.de/informatik/projekte/mebib/emiel/entw_inf/or_verf/linopt_bsp.html");
      solver.setVerbose(3);
      //solver.dualizeLp();
      // solve the problem
      solver.solve();
      //      solver.printTableau();
      //solver.printDuals();
      solver.printLp();
      // print solution
      System.out.println("Value of objective function: " + solver.getObjective());
      double[] var = solver.getPtrVariables();
      for (int i = 0; i < var.length; i++) {
        System.out.println("Value of var[" + i + "] = " + var[i]);
      }

      // delete the problem and free memory
      solver.deleteLp();
    }
    catch (LpSolveException e) {
       e.printStackTrace();
    }
  }

}
