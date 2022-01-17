package com.icia.example10;

import lombok.*;

// 주문을 할려면 상품, 고객 클래스가 존재해야 한다
@AllArgsConstructor
class 고객 {
	String username;
	String password;
	String tel;
	String address;
}

@AllArgsConstructor
class 상품 {
	Integer productNo;
	String productName;
	String price;
}

@AllArgsConstructor
class 주문 {
	String username;
	Integer productNo;
	Integer count;
	Integer totalprice;
}

class 주문Service {
	public void do주문(int count) {
		// 주문 서비스가 객체를 생성하려면 주문자, 상품번호, 상품가격은 주문 서비스, 상품 서비스에서 받아와야 한다
		고객 user = 고객Service.getLoginUser();
		상품 product = 상품Service.get상품(15);
		주문 order = new 주문(user.username, product.productNo, count, product.price*count);
		// 주문 정보를 데이터베이스에 저장
	}
}
public class JumunTest {

}
