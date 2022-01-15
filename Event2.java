package javaex;

import java.awt.event.*;

import javax.swing.*;

class My프로그램 extends JFrame implements ActionListener {
	private JButton button = new JButton("버튼 클릭");
	private Integer count = 0;
	public My프로그램() {
		add(button);
		// 이벤트 소스 : button
		// 이벤트 핸들러 : actionPerformed를 구현한 객체
		// 소스와 핸들러를 연결
		// js : $('#button').click(actionPerformed);
		// java : button.addActionListener(ActionListener 구현 객체);
		button.addActionListener(this);
		
		// 프로그램 크기, 버튼 종료처리, 화면에 나타나게
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(count+"번 클릭");
		count++;
	}
}

public class 이벤트Test2 {
	public static void main(String[] args) {
		// 객체를 만들었는데 참조변수가 없다 -> 익명 객체
		new My프로그램();
	}
}
