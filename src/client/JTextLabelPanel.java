package client;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class JTextLabelPanel extends JPanel {
    private JLabel[] labels;

    public JTextLabelPanel(String[] labelTexts) {
        labels = new JLabel[labelTexts.length];
        setLayout(new GridLayout(1, labelTexts.length));
        
        // 레이블 초기화 및 패널에 추가
        for (int i = 0; i < labelTexts.length; i++) {
            labels[i] = new JLabel(labelTexts[i]);
            labels[i].setHorizontalAlignment(SwingConstants.CENTER);
            labels[i].setOpaque(true); // 배경색 설정을 위해 불투명하게 설정
            labels[i].setBackground(new Color(144, 238, 144)); // 연두색 배경
            add(labels[i]);
        }
    }

    public void setText(int index, String text) {
        if (index >= 0 && index < labels.length) {
            labels[index].setText(text);
        }
    }
}

