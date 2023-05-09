package day02;

public class Ex08 {	//대입 연산자 (=, +=, -=, *=, /=, %=) : 변수의 값을 변경
	public static void main(String[] args) {
		int a=10;
		System.out.println(a+10);
		System.out.println(a);		//변수 a의 값이 변하지 않음
		
		System.out.println(a+=10);
		System.out.println(a);		//변수 a의 값이 변함
	}
}
