package Controller;

import Model.ProblemSolver;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolveButtonController implements ActionListener{
    private ProblemSolver solver;

    public void init(ProblemSolver solver){
        this.solver = solver;
    }

    @Override
    public void actionPerformed(ActionEvent arg0){
        solver.solveProblem();
    }
}
