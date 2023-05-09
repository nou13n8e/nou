package day01;

public class Ex02 {	//변수의 기본 타입 8가지 중 정수형
	public static void main(String[] args) {
		//정수형 byte < char < short < int < long
		//실수형 float < double
		//논리형 boolean : true, false로 출력
		
		int a;						//변수의 초기화 : 변수에 최초의 값을 넣는 것
		a=10;						//선언만 하고 값을 대입하지 않으면 사용불가
		a=20;						//변수는 선언된 영역{}안에서만 사용 가능
		System.out.println(a);		//마지막에 대입된 값 출력
		
		int b=10;					//선언과 대입 동시에 가능
		int c=b;					//같은 타입이라면 대입 가능
		System.out.println(b);
		System.out.println(c);
		
	}
}
