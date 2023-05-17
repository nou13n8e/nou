package ex0517;

public class Calculator2Main {
	public static void main(String[] args) {
		//정적(static) 멤버는 객체 생성을 하지 않고, 호출만으로 사용 가능
		System.out.println(Calculator2.pi);
		
		int result01=Calculator2.plus(10, 5);
		System.out.println(result01);
		
		int result02=Calculator2.minus(10, 5);
		System.out.println(result02);
		
	}
}
