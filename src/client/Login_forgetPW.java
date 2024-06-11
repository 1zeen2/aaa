package client;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_forgetPW extends JPanel implements ActionListener {

    JLabel titleLabel, idLabel, nameLabel, emailLabel;
    JTextField idTextField, nameTextField, emailTextField;
    JButton confirmButton, cancelButton;
    private Client_Main clientMain;

    public Login_forgetPW(Client_Main clientMain) {
        this.clientMain = clientMain;
        setLayout(null);

        titleLabel = new JLabel("비밀번호 찾기");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        titleLabel.setBounds(620, 50, 200, 40);
        add(titleLabel);

        idLabel = new JLabel("아이디", JLabel.CENTER);
        idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        idLabel.setBounds(478, 220, 200, 40);
        add(idLabel);

        idTextField = new JTextField();
        idTextField.setBounds(678, 220, 200, 40);
        add(idTextField);

        nameLabel = new JLabel("이름", JLabel.CENTER);
        nameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        nameLabel.setBounds(478, 280, 200, 40);
        add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(678, 280, 200, 40);
        add(nameTextField);

        emailLabel = new JLabel("이메일", JLabel.CENTER);
        emailLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        emailLabel.setBounds(478, 340, 200, 40);
        add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setBounds(678, 340, 200, 40);
        add(emailTextField);

        confirmButton = new JButton("확인");
        confirmButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        confirmButton.setBounds(478, 500, 200, 40);
        confirmButton.addActionListener(this);
        add(confirmButton);

        cancelButton = new JButton("취소");
        cancelButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        cancelButton.setBounds(678, 500, 200, 40);
        cancelButton.addActionListener(this);
        add(cancelButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            clientMain.showLoginPage();
        }
    }
}
