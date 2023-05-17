package ex0516;

public class CarMain {
	public static void main(String[] args) {
		// 객체 생성
		Car myCar = new Car();
		
		// 변수 값 읽기
		System.out.println("제작회사: " + myCar.company);
		System.out.println("모델명: " + myCar.model);
		System.out.println("색깔: " + myCar.color);
		System.out.println("최고속도: " + myCar.maxSpeed);
		System.out.println("현재속도: " + myCar.speed);
		
		// 변수 값 변경
		myCar.speed = 60;
		// myCar라는 변수에 객체 주소가 대입되어있기 때문.
		System.out.println("수정된 속도: " + myCar.speed);
	}
}
