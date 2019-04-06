package Factory;

import javax.swing.JFrame;
import Controller.SolveButtonController;
import Controller.StatisticButtonController;
import View.StatisticPanel;
import View.ChessPanel;
import View.ButtonPanel;

public class GUIFactory implements AbstractGUIFactory{

    @Override
    public JFrame createEightQueenFrame(){
        return new JFrame();
    }

    @Override
    public ChessPanel createChessPanel(){
        return new ChessPanel();
    }

    @Override
    public ButtonPanel createButtonPanel() {
        return new ButtonPanel();
    }

    @Override
    public SolveButtonController createSolveButtonController() {
        return new SolveButtonController();
    }

    @Override
    public StatisticButtonController createStatisticButtonController() {
        return new StatisticButtonController();
    }

    @Override
    public JFrame createStatisticFrame() {
        return new JFrame();
    }

    @Override
    public StatisticPanel createStatisticPanel() {
        return new StatisticPanel();
    }
}
