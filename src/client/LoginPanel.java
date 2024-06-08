package client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginPanel extends JPanel implements ActionListener {
    private ClientMain clientMain;
    public JLabel la1, la2;
    public JCheckBox box1;
    public JTextField tf;
    public JPasswordField pf;
    public JButton b1, b2, b3, b4, b5;

    public LoginPanel(ClientMain clientMain) {
        this.clientMain = clientMain;
        
        la1 = new JLabel("아이디");
        la2 = new JLabel("비밀번호");

        box1 = new JCheckBox("아이디 저장");

        tf = new JTextField();
        pf = new JPasswordField();

        b1 = new JButton("로그인");
        b2 = new JButton("취소");
        b3 = new JButton("아이디 찾기");
        b4 = new JButton("비밀번호 찾기");
        b5 = new JButton("회원 가입");

        setLayout(null);
        la1.setBounds(500, 200, 200, 30);
        la1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        tf.setBounds(633, 200, 250, 30);

        add(la1);
        add(tf);

        la2.setBounds(500, 260, 200, 30);
        la2.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        pf.setBounds(633, 260, 250, 30);

        add(la2);
        add(pf);

        box1.setBounds(500, 300, 100, 50);
        add(box1);

        b1.setBounds(475, 350, 470, 50);
        b1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        add(b1);

        b3.setBounds(475, 410, 150, 50);
        add(b3);

        b4.setBounds(635, 410, 150, 50);
        add(b4);

        b5.setBounds(795, 410, 150, 50);
        add(b5);

        setSize(1366, 768);
        setVisible(true);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            clientMain.showMainPage();
        } else if (e.getSource() == b3) {
            // 아이디 찾기 처리
        } else if (e.getSource() == b4) {
            // 비밀번호 찾기 처리
        } else if (e.getSource() == b5) {
            clientMain.showSignUpPage(); // 회원가입 페이지로 이동
        }
    }
}
