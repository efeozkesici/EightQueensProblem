package Model;

import Algorithms.HillClimbing;
import Observer.NotifyAction;
import Observer.Subject;

public class ProblemSolver extends Subject {
    HillClimbing hillClimbing;

    public int[] getCurrentPositions(){
        return this.hillClimbing.getCurrentPositions();
    }

    public ProblemSolver(){
        hillClimbing = new HillClimbing();
    }

    public void solveProblem(){
        hillClimbing.init();

        this.setChanged();
        this.notifyAllObservers(NotifyAction.START);
        hillClimbing.runHillClimbing(this);
        this.setChanged();
        this.notifyAllObservers(NotifyAction.FINISH);
    }

    public int getRandomRestartCount(){
        return this.hillClimbing.getRandomRestartCount();
    }

    public int getMoveCount(){
        return this.hillClimbing.getMoveCount();
    }

    public double getProcessTime(){
        return this.hillClimbing.getProcessTime();
    }
}
