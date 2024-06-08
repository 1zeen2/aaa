package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class SchedulerPanel extends JPanel { 
    JButton searchBtn, prevBtn, nextBtn;
    JLabel titleLa;
    JLabel monthLabel; 
    JTable table;
    DefaultTableModel model;
    public Calendar currentCalendar;

    public SchedulerPanel() {
        currentCalendar = new GregorianCalendar();
        initializeComponents();
        setLayout(null);
        arrangeComponents();
        updateCalendar();
    }

    private void initializeComponents() {
        // 버튼 초기화
        searchBtn = new JButton("검색");
        prevBtn = new JButton("이전");
        nextBtn = new JButton("다음");

        // 이전, 다음 버튼에 액션 리스너 추가
        prevBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentCalendar.add(Calendar.MONTH, -1);
                updateCalendar();
            }
        });
        
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentCalendar.add(Calendar.MONTH, 1); 
                updateCalendar();
            }
        });
        
        // 라벨 초기화
        titleLa = new JLabel("Scheduler", JLabel.CENTER);
        titleLa.setFont(new Font("맑은 고딕", Font.BOLD, 40));

        // 월 정보 표시 라벨 생성
        monthLabel = new JLabel("", JLabel.CENTER);
        monthLabel.setFont(new Font("맑은 고딕", Font.BOLD, 40));

        // 테이블 컬럼 및 데이터 초기화
        String[] col = {"일", "월", "화", "수", "목", "금", "토"};
        String[][] row = new String[6][7];
        model = new DefaultTableModel(row, col) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // 테이블 설정
        table = new JTable(model);
        table.setGridColor(Color.BLACK); // 그리드 선 색상 설정
        table.setShowGrid(true); // 그리드 선 보이기 설정
        table.setRowHeight(87); // 행 높이 설정

        configureScrollPane();
        configureTable();
    }

    private void configureScrollPane() {
        // JScrollPane 설정
        JScrollPane js = new JScrollPane(table);
        js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // 수직 스크롤 바 비활성화

        // 컬럼 너비 설정
        int columnWidth = 153;
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidth);
        }

        // 테이블 속성 설정
        table.getTableHeader().setReorderingAllowed(false);
        table.setShowVerticalLines(true); // 수직 선 표시 설정
        table.setShowHorizontalLines(true); // 수평 선 표시 설정

        js.setViewportView(table);
        add(js);
    }

    private void configureTable() {
        // 요일에 대한 셀 렌더러 설정
        TableCellRenderer dayCellRenderer = new CalendarCellRenderer();

        // 각 열에 대한 셀 렌더러 설정
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setCellRenderer(dayCellRenderer);
        }

        // 요일 헤더 색상 설정
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel headerLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
                if (column == 0) { // 일요일(0)인 경우
                    headerLabel.setBackground(new Color(255, 204, 204)); // 연한 분홍색
                } else if (column == 6) { // 토요일(6)인 경우
                    headerLabel.setBackground(new Color(204, 229, 255)); // 연한 하늘색
                } else {
                    headerLabel.setBackground(Color.WHITE); // 월요일부터 금요일까지 색상
                }
                headerLabel.setForeground(Color.BLACK); // 헤더 텍스트 색상
                headerLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK)); // 테두리 설정
                return headerLabel;
            }
        });
    }

    private void arrangeComponents() {
        titleLa.setBounds(315, 25, 620, 50); // 타이틀 텍스트 위치와 크기 설정
        add(titleLa);

        searchBtn.setBounds(1070, 95, 90, 40); // 검색 버튼 위치와 크기 설정
        add(searchBtn);

        prevBtn.setBounds(420, 95, 90, 40); // 이전 버튼 위치와 크기 설정
        add(prevBtn);

        nextBtn.setBounds(730, 95, 90, 40); // 다음 버튼 위치와 크기 설정
        add(nextBtn);

        monthLabel.setBounds(500, 35, 250, 150); // 월 정보 표시 라벨 위치와 크기 설정
        add(monthLabel);

        JScrollPane js = new JScrollPane(table);
        js.setBounds(356, 170, 820, 542); // 스크롤 패널의 위치와 크기 설정
        js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 수평 스크롤바 비활성화
        js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // 수직 스크롤바 비활성화
        add(js);
    }

    // 현재 월을 반환하는 메서드
    private String getMonthString() {
        int year = currentCalendar.get(Calendar.YEAR); // 현재 연도 가져오기
        int month = currentCalendar.get(Calendar.MONTH) + 1; // 현재 월 가져오기 (Calendar.MONTH는 0부터 시작하므로 +1)
        return year + "." + (month < 10 ? "0" + month : month); // 월이 한 자리 숫자일 경우 앞에 0을 붙임
    }

    public void updateCalendar() {
        monthLabel.setText(getMonthString());

        Calendar calendar = (Calendar) currentCalendar.clone();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int numberOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int day = i * 7 + j - startDay + 1;
                if (day > 0 && day <= numberOfDays) {
                    model.setValueAt(day, i, j);
                } else {
                    model.setValueAt("", i, j);
                }
            }
        }
    }

    class CalendarCellRenderer extends JPanel implements TableCellRenderer {
        private JLabel dayLabel;

        public CalendarCellRenderer() {
            setLayout(new BorderLayout());
            dayLabel = new JLabel();
            dayLabel.setHorizontalAlignment(SwingConstants.LEFT);
            add(dayLabel, BorderLayout.NORTH);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Calendar calendar = (Calendar) currentCalendar.clone();
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            int startOffset = dayOfWeek - 1;

            int day = row * 7 + column - startOffset + 1;
            if (day > 0 && day <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                dayLabel.setText(String.valueOf(day));
            } else {
                dayLabel.setText("");
            }

            if (column == 0) {
                setBackground(new Color(255, 204, 204)); // 연한 분홍색
            } else if (column == 6) {
                setBackground(new Color(204, 229, 255)); // 연한 하늘색
            } else {
                setBackground(Color.WHITE); // 나머지는 흰색 배경
            }

            // 테두리 설정
            setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK)); // 아래쪽과 오른쪽 테두리만 설정

            return this;
        } 
    }

}