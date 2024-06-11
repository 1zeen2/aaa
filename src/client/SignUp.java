package client;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignUp extends JPanel implements ActionListener {
    
    JLabel id, pw, pws, name, dob, dobex, email, pnum, zipcode, address;
    JTextField id2, name2, dob2, email2, pnum2, pnum3, zipcode2, address2;
    JPasswordField pw2, pws2;
    JRadioButton male, female;
    JButton yes, no, idcheck, zipbutton;
    JComboBox<String> combo;
    private Client_Main clientMain;

    public SignUp(Client_Main clientMain) {
        this.clientMain = clientMain;
        setLayout(null);
        
        id = new JLabel("아이디", JLabel.CENTER);
        id.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        id2 = new JTextField();
        id.setBounds(478, 65, 200, 40);
        id2.setBounds(678, 65, 200, 40);
        add(id); add(id2);
        
        idcheck = new JButton("중복확인");
        idcheck.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        idcheck.setBounds(878, 65, 100, 40);
        add(idcheck);
        
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
        dobex = new JLabel(" * ex) 971224");
        dob.setBounds(478, 285, 200, 40);
        dob2.setBounds(678, 285, 200, 40);
        dobex.setBounds(878, 285, 200, 40);
        add(dob); add(dob2); add(dobex);
        
        email = new JLabel("이메일", JLabel.CENTER);
        email.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        email2 = new JTextField();
        email.setBounds(478, 340, 200, 40);
        email2.setBounds(678, 340, 230, 40);
        add(email); add(email2);
        
        combo = new JComboBox<>(new String[]{"010", "011"});
        combo.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        combo.setBounds(668, 395, 85, 40);
        add(combo);
        
        pnum = new JLabel("전화번호", JLabel.CENTER);
        pnum.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        pnum2 = new JTextField();
        pnum3 = new JTextField();
        pnum.setBounds(478, 395, 200, 40);
        pnum2.setBounds(748, 395, 80, 40);
        pnum3.setBounds(828, 395, 80, 40);
        add(pnum); add(pnum2); add(pnum3);
        
        zipcode = new JLabel("우편번호", JLabel.CENTER);
        zipcode.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        zipcode2 = new JTextField();
        zipbutton = new JButton("검색");
        zipbutton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        zipcode.setBounds(478, 450, 200, 40);
        zipcode2.setBounds(678, 450, 140, 40);
        zipbutton.setBounds(818, 450, 90, 40);
        add(zipcode); add(zipcode2); add(zipbutton);
        
        address = new JLabel("상세 주소", JLabel.CENTER);
        address.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        address2 = new JTextField();
        address.setBounds(478, 505, 200, 40);
        address2.setBounds(678, 505, 200, 40);
        add(address); add(address2);
        
        yes = new JButton("확인");
        yes.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        no = new JButton("취소");
        no.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        yes.setBounds(478, 570, 200, 40);
        no.setBounds(678, 570, 200, 40);
        add(yes); add(no);
        
        JPanel s = new JPanel();
        male = new JRadioButton("남자");
        female = new JRadioButton("여자");
        s.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        s.add(male); s.add(female);
        s.setBounds(838, 230, 200, 40);
        add(s);
        
        no.addActionListener(this); // 취소 버튼에 액션 리스너 추가
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == no) {
            clientMain.showLoginPage();
        }
    }
}
