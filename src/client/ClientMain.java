package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientMain extends JFrame implements ActionListener {
    public MenuPanel mp = new MenuPanel();
    public ControllerPanel cp = new ControllerPanel();
    public LoginPanel lp;
    public SignUp sp; // SignUp 패널 추가
    public JPanel cardPanel;
    public CardLayout cardLayout;

    public ClientMain() {
        // CardLayout 설정
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // LoginPanel과 SignUpPanel 추가
        lp = new LoginPanel(this);
        sp = new SignUp(this); // SignUp 패널 초기화
        
        // MainPanel 추가
        JPanel mainPanel = new JPanel(null);
        mp.setBounds(50, 168, 100, 400);
        mainPanel.add(mp);
        cp.setBounds(150, 0, 1216, 768);
        mainPanel.add(cp);

        // CardLayout에 패널 추가
        cardPanel.add(lp, "LOGIN");
        cardPanel.add(sp, "SIGNUP"); // SignUp 패널 추가
        cardPanel.add(mainPanel, "MAIN");

        // 레이아웃 설정 및 컴포넌트 추가
        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);

        // 창 속성 설정
        setSize(1366, 768);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 버튼에 액션 리스너 추가
        mp.b1.addActionListener(this);
        mp.b2.addActionListener(this);
        mp.b5.addActionListener(this);
    }

    public static void main(String[] args) {
        try {
            // UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        new ClientMain();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mp.b1) { // 홈 버튼 클릭 시
            cp.card.show(cp, "SCHEDULER");
        } else if (e.getSource() == mp.b2) { // 찾기 버튼 클릭 시
            cp.card.show(cp, "CHATTING");
        } else if (e.getSource() == mp.b5) { // 종료 버튼 클릭 시
            JOptionPane.showMessageDialog(this, "프로그램을 종료합니다");
            System.exit(0);
        }
    }

    public void showMainPage() {
        cardLayout.show(cardPanel, "MAIN");
        cp.card.show(cp, "SCHEDULER");
    }

    public void showSignUpPage() {
        cardLayout.show(cardPanel, "SIGNUP");
    }

    public void showLoginPage() {
        cardLayout.show(cardPanel, "LOGIN");
    }
}