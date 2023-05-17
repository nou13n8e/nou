package ex0516;

public class Car3 {
	// 생성자 오버로딩
	// 이유 : 클래스 더 만들지 않고 객체 생성으로 간단하게 가능.
	
	// 필드
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	// 생성자
	Car3() {
	}
		
	Car3(String model) {
		this.model = model;
	}
		
	Car3(String model, String color) {
		this.model = model;
		this.color = color;
	}
		
	Car3(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
