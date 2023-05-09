package day02;

public class Ex05 {	//논리 연산자 (&&, ||, !) : if문과 for문에 자주 쓰임
					//&& : and연산자, 조건이 모두 true일 때 결과가 true
					//|| : or연산자, 조건이 하나라도 true일 때 결과가 true
					// ! : not연산자, 결과를 반대로 보여줌
	public static void main(String[] args) {
		System.out.println(true&&true);				//true
		System.out.println(true&&false);			//false
		System.out.println(true&&false&&true);		//false
		System.out.println(false&&false);			//false(조건이 모두 false)
		
		System.out.println(true||true);				//true
		System.out.println(true||false);			//true
		System.out.println(true||false||false);		//true
		System.out.println(false||false);			//false
	}
}
