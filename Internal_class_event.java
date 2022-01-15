package javaex;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class MyApp4 extends JFrame {
	private JButton btnRed = new JButton("빨강");
	private JButton btnBlue = new JButton("파랑");
	private JPanel panel = new JPanel();
	
	class BtnRedHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.setBackground(Color.red);
		}
	}
	class BtnBlueHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			panel.setBackground(Color.blue);
		}
	}
	
	
	public MyApp4() {
		add(btnRed, BorderLayout.EAST);
		add(panel);
		add(btnBlue, BorderLayout.WEST);
		
		btnRed.addActionListener(new BtnRedHandler());
		btnBlue.addActionListener(new BtnBlueHandler());
		
		// 프로그램 크기, 버튼 종료처리, 화면에 나타나게
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
public class 내부클래스이벤트Test {
	public static void main(String[] args) {
		new MyApp4();
	}
}