package ex0517;

public class Calculator {
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	void powerOff() {
		System.out.println("전원을 끕니다");
	}
	
	int plus(int x,int y) {
		int result = x+y;
		return result;
	}
	
	double divice(double x, double y) {
		double result = (double)(x/y);
		return result;
	}
	
	//메서드 오버로딩
	//매개변수가 다른 여러 개의 메서드를 생성 가능
	
}
