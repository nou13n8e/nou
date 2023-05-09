package day02;

public class Ex03 {	//비교연산자 (==,>,<,>=,<=,!)
					//결과값을 true, false로 출력
	public static void main(String[] args) {
		System.out.println(10>0);		//true
		System.out.println(10==0);		//false
		System.out.println(10==0+10);	//true
		System.out.println(10!=0);		//true
		
		int a=10, b=0;
		System.out.println(a>=b);		//true
		System.out.println(a==b+10);	//true
		System.out.println(a!=b);		//true
	}
}
