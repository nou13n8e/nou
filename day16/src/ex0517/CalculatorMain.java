package ex0517;

public class CalculatorMain {
	public static void main(String[] args) {
		Calculator c=new Calculator();
		c.powerOn();
		//c라는 참조변수가 가진 powerOn이라는 메서드를 호출=return타입이 없기 때문에 호출만으로도 사용 가능
		
		int result01=c.plus(5, 6);
		System.out.println(result01);
		//return타입이 있는 경우 값을 대입할 변수를 선언(=result)
		
		byte x=10;
		byte y=4;
		double result02=c.divice(x, y);
		System.out.println(result02);
		
		c.powerOff();
		//c라는 참조변수가 가진 powerOff라는 메서드를 호출=return타입이 없기 때문에 호출만으로도 사용 가능
	}
}
