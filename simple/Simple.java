import lpsolve.*;

public class Simple {

  public static void main(String[] args) {
    try {
      // Create a problem with 4 variables and 0 constraints
      LpSolve solver = LpSolve.makeLp(0, 6);

      // add constraints
      solver.strAddConstraint("1 0 0 0 0 0", LpSolve.LE, 5);
      solver.strAddConstraint("0 1 0 0 0 0", LpSolve.LE, 10);
      solver.strAddConstraint("0 0 1 0 0 0", LpSolve.LE, 7);
      solver.strAddConstraint("0 0 0 1 0 0", LpSolve.LE, 7);
      solver.strAddConstraint("0 0 0 0 1 0", LpSolve.LE, 3);
      solver.strAddConstraint("0 0 0 0 0 1", LpSolve.LE, 12);

      solver.strAddConstraint("1 0 -1 0 0 0", LpSolve.EQ, 0);

      solver.strAddConstraint("0 1 0 -1 -1 0", LpSolve.EQ, 0);

      solver.strAddConstraint("0 0 1 1 0 -1", LpSolve.EQ, 0);




      // set objective function
      solver.strSetObjFn("1 1 0 0 0 0");
      solver.setMaxim();
      solver.setLpName("Simple example for assignment 1");
      solver.setVerbose(3);
      // solve the problem
      //solver.dualizeLp();
      solver.solve();
      
      solver.printDuals();
      //      solver.printTableau();
      //      solver.printLp();
      // print solution

      System.out.println("Value of objective function: " + solver.getObjective());
      double[] var = solver.getPtrVariables();
      for (int i = 0; i < var.length; i++) {
        System.out.println("Value of var[" + i + "] = " + var[i]);
      }

      // delete the problem and free memory

      System.out.println(solver.getStatustext(solver.getStatus()));
      solver.deleteLp();
    }
    catch (LpSolveException e) {
       e.printStackTrace();
    }
  }

}
