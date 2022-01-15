package javaex;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class MyApp3 extends JFrame implements ActionListener {

	// 버튼이 2개있고 Panel 한개. 버튼을 클릭하면 패널의 색을 변경하자
	private JButton btnRed = new JButton("빨강");
	private JButton btnBlue = new JButton("파랑");
	private JPanel panel = new JPanel();
	
	// 화면을 배치하는 관리자 객체가 따로 존재한다
	// 기본 배치 관리자는 BorderLayout. 이놈은 동 서 남 북 가운데로 배치한다
	// 단 따로 지정하지 않고 그냥 배치하지 않으면 무조건 가운데로 들어간다
	public MyApp3() {
		add(btnRed, BorderLayout.EAST);
		add(panel);
		add(btnBlue, BorderLayout.WEST);
		
		btnRed.addActionListener(this);
		btnBlue.addActionListener(this);
		
		// 프로그램 크기, 버튼 종료처리, 화면에 나타나게
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println(e.getActionCommand()); - 글자를 읽어온다
		if(e.getActionCommand().equals("빨강"))
			panel.setBackground(new Color(255, 0, 0));
		else
			panel.setBackground(new Color(0,0,255));
	}
}

public class 이벤트Test3 {
	public static void main(String[] args) {
		new MyApp3();
	}
}
