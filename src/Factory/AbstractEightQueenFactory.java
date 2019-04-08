package Factory;

import Model.ProblemSolver;

public interface AbstractEightQueenFactory {
    public ProblemSolver createSolution();

    public AbstractGUIFactory createGUI();
}
