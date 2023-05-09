package day02;

public class Ex06 {	//비교연산자 + 논리연산자 활용
	public static void main(String[] args) {
		int a=10;
		int b=5;
		boolean result=(a>0) && (a>100);			//조건이 모두 true여야 함
		System.out.println(result);					//false
		
		boolean result2=(a>0) || (a>100);			//조건이 하나라도 true여야 함
		System.out.println(result2);				//true
		System.out.println(!result2);				//false, !=결과값 반전
		
		System.out.println(a>7 && b<=5);			//true, 조건이 모두 true여야 함
		System.out.println((a%3==2) || (b%2!=1));	//false, 조건이 하나라도 true여야 함
	}
}
