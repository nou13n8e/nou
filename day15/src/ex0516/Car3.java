package ex0516;

public class Car3 {
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	// 생성자 오버로딩 : 매개변수가 다른 여러 개의 생성자를 생성
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
