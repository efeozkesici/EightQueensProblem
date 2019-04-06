package View;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.SolveButtonController;
import Controller.StatisticButtonController;

public class ButtonPanel extends JPanel{
    private static final long serialVersionUID = 3682338522785801993L;

    private JButton buttonSolve = new JButton("Solve");
    private JButton buttonStatistics = new JButton("Statistics");

    public ButtonPanel(){
        super(new BorderLayout());

        JPanel panelAlign = new JPanel();
        panelAlign.setLayout(new BoxLayout(panelAlign, BoxLayout.PAGE_AXIS));
        this.add(panelAlign, BorderLayout.CENTER);

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.Y_AXIS));
        panelButton.setBorder(BorderFactory.createEmptyBorder());
        panelAlign.add(panelButton);

        panelButton.add(this.buttonSolve);
        panelButton.add(this.buttonStatistics);
    }

    public void setController(SolveButtonController solveButtonController, StatisticButtonController statisticButtonController){
        this.buttonSolve.addActionListener(solveButtonController);
        this.buttonStatistics.addActionListener(statisticButtonController);
    }
}
