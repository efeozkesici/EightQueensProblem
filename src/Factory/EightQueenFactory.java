package Factory;

import Model.ProblemSolver;

public class EightQueenFactory implements AbstractEightQueenFactory{

    @Override
    public ProblemSolver createSolution(){
        return new ProblemSolver();
    }

    @Override
    public AbstractGUIFactory createGUI(){
        return new GUIFactory();
    }
}
