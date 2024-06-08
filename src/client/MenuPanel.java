package client;

import java.awt.GridLayout;
import javax.swing.*;

public class MenuPanel extends JPanel { 
    public JButton b1, b2, b3, b4, b5;

    public MenuPanel() {
        setLayout(new GridLayout(5, 1, 5, 5));
        
        b1 = new JButton("홈");
        b2 = new JButton("채팅");
        b3 = new JButton("게시판");
        b4 = new JButton("뉴스");
        b5 = new JButton("나가기");

        add(b1); 
        add(b2);
        add(b3);
        add(b4);
        add(b5);
    }
}