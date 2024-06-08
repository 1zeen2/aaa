package client;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class ControllerPanel extends JPanel {
    public CardLayout card = new CardLayout();
    
    public SchedulerPanel scP = new SchedulerPanel();
    public ChattingPanel chP = new ChattingPanel();
 

    public ControllerPanel() {
        setLayout(card);

        add("SCHEDULER", scP);
        add("CHATTING", chP);

    }
} 