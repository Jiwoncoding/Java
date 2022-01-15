package javaex;

import java.awt.event.*;

import javax.swing.*;

// 자바에서 클릭 이벤트를 처리한다 -> 누가 하나 같은 방법으로 처리 -> 아 인터페이스가 있겠구나
// 인터페이스는 추상 메소드를 통해서 메소드 이름을 지정
//		jQuery라면 미리 정해놓은 메소드 이름(click)을 이용해서 코딩을 하면 된다
//		자바에서는 정해진 메소드 이름은 인터페이스에 들었고, 인터페이스를 implements 해야만 이름을 사용할 할 수 있다 
// implements를 어디에 할 건가? 제일 간단한 방법은 JFrame를 상속한 클래스에 한다
class MyFrame extends JFrame implements ActionListener {
	private JButton button = new JButton("클릭하세요");
	public MyFrame() {
		// 이벤트소스와 이벤트핸들러를 연결해주자
		// 이벤트소스.addActionListner(이벤트핸들러를 구현한 객체)
		button.addActionListener(this);
		add(button);
		setTitle("마이 프로그램");
		setSize(600, 400);
		// setD + Ex
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	// 뭔가를 선택한다 : 버튼을 클릭한다, 메뉴를 클릭한다, 입력하고 엔터누른다 -> 자바는 ActionEvent라고 부른다
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 클릭");
	}
}

public class 이벤트Test {
	public static void main(String[] args) {
		new MyFrame();
	}
}
