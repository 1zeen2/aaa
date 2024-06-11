package client;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class Controller_Panel extends JPanel {
    public CardLayout card = new CardLayout();
    
    public Scheduler_Panel scP = new Scheduler_Panel();
    public Chatting_Panel chP = new Chatting_Panel();
 

    public Controller_Panel() {
        setLayout(card);

        add("SCHEDULER", scP);
        add("CHATTING", chP);

    }
} 