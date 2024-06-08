package client;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JPanel { 
    private ClientMain clientMain; 
    JLabel id, pw, pws, name, dob, email, pnum, zipcode, address, gender;
    JTextField id2, name2, dob2, email2, pnum2, zipcode2, address2;
    JPasswordField pw2, pws2;
    JCheckBox male, female;
    JButton yes, no;
    ButtonGroup genderGroup;

    public SignUp(ClientMain clientMain) { 
        this.clientMain = clientMain;

        setLayout(null);

        id = new JLabel("아이디", JLabel.CENTER);
        id.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        id2 = new JTextField();
        id.setBounds(478, 65, 200, 40);
        id2.setBounds(678, 65, 200, 40);
        add(id); add(id2);

        pw = new JLabel("비밀번호", JLabel.CENTER);
        pw.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        pw2 = new JPasswordField();
        pw.setBounds(478, 120, 200, 40);
        pw2.setBounds(678, 120, 200, 40);
        add(pw); add(pw2);

        pws = new JLabel("비밀번호 확인", JLabel.CENTER);
        pws.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        pws2 = new JPasswordField();
        pws.setBounds(478, 175, 200, 40);
        pws2.setBounds(678, 175, 200, 40);
        add(pws); add(pws2);

        name = new JLabel("이 름", JLabel.CENTER);
        name.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        name2 = new JTextField();
        name.setBounds(478, 230, 200, 40);
        name2.setBounds(678, 230, 200, 40);
        add(name); add(name2);

        dob = new JLabel("생년월일", JLabel.CENTER);
        dob.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        dob2 = new JTextField();
        dob.setBounds(478, 285, 200, 40);
        dob2.setBounds(678, 285, 200, 40);
        add(dob); add(dob2);

        email = new JLabel("이메일", JLabel.CENTER);
        email.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        email2 = new JTextField();
        email.setBounds(478, 340, 200, 40);
        email2.setBounds(678, 340, 200, 40);
        add(email); add(email2);

        pnum = new JLabel("전화번호", JLabel.CENTER);
        pnum.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        pnum2 = new JTextField();
        pnum.setBounds(478, 395, 200, 40);
        pnum2.setBounds(678, 395, 200, 40);
        add(pnum); add(pnum2);

        zipcode = new JLabel("우편번호", JLabel.CENTER);
        zipcode.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        zipcode2 = new JTextField();
        zipcode.setBounds(478, 450, 200, 40);
        zipcode2.setBounds(678, 450, 200, 40);
        add(zipcode); add(zipcode2);

        address = new JLabel("상세 주소", JLabel.CENTER);
        address.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        address2 = new JTextField();
        address.setBounds(478, 505, 200, 40);
        address2.setBounds(678, 505, 200, 40);
        add(address); add(address2);

        gender = new JLabel("성별", JLabel.CENTER);
        gender.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        gender.setBounds(478, 560, 200, 40);
        add(gender);

        male = new JCheckBox("남자");
        female = new JCheckBox("여자");
        male.setBounds(678, 560, 100, 40);
        female.setBounds(778, 560, 100, 40);
        add(male); add(female);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        yes = new JButton("확인");
        yes.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        no = new JButton("취소");
        no.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        yes.setBounds(478, 620, 200, 40);
        no.setBounds(678, 620, 200, 40);
        add(yes); add(no);

        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	clientMain.showLoginPage();
            }
        });

        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientMain.showLoginPage(); 
            }
        });
    }
}
