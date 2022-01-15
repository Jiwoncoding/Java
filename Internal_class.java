package javaex;

class AAA {
	int a = 10;
	class BBB {
		int b = 20;
		public void print() {
			System.out.println(a + " " + b);
		}
	}
}

class XXX {
	static class ZZZ {
		public void print() {
			System.out.println("까꿍");
		}
	}
}

public class 내부클래스Test {
	public static void main(String[] args) {
		AAA.BBB obj =  new AAA().new BBB();
		obj.print();
		
		XXX.ZZZ obj2 = new XXX.ZZZ();
		obj2.print();
	}
}



