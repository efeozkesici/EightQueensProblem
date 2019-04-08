package Factory;

import javax.swing.JFrame;
import Controller.StatisticButtonController;
import Controller.SolveButtonController;
import View.ButtonPanel;
import View.ChessPanel;
import View.StatisticPanel;

public interface AbstractGUIFactory {
    public JFrame createEightQueenFrame();

    public ChessPanel createChessPanel();

    public ButtonPanel createButtonPanel();

    public SolveButtonController createSolveButtonController();

    public StatisticButtonController createStatisticButtonController();

    public JFrame createStatisticFrame();

    public StatisticPanel createStatisticPanel();
}
