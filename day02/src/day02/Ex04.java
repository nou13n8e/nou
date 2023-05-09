package day02;

public class Ex04 {	//문자열 연산자 (+)
	public static void main(String[] args) {
		String a="JDK"+6.0;
		System.out.println(a);
		
		String b=a+"특징";
		System.out.println(b);
		
		String c="JDK"+3+3.0;
		String d=3+3.0+"JDK";
		System.out.println(c);	//JDK와 3이 연산된 뒤 3.0 연산
		System.out.println(d);	//3과 3.0이 연산된 뒤 JDK 연산
		
		int e=100;
		String f="100";
		System.out.println(e+" "+f);
		//String타입과 연산하면 String타입으로 출력
	}
}
