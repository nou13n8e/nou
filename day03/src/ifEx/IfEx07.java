package ifEx;

public class IfEx07 {	//else-if
	public static void main(String[] args) {
		int score=87;
//		if(score>=90) {
//			System.out.println("A학점");
//		}else if(score>=80) {
//			System.out.println("B학점");
//		}else if(score>=70) {
//			System.out.println("C학점");
//		}else {
//			System.out.println("F학점");
//		}
		
		String result;				//결과값의 타입이 같을 때는 변수로 선언
									//반복되는 문장을 여러번 쓸 필요 없음
		if(score>=90) {
			result="A학점";
		}else if(score>=80) {
			result="B학점";
		}else if(score>=70) {
			result="C학점";
		}else {
			result="F학점";
		}
		System.out.println(result);
	}
}
