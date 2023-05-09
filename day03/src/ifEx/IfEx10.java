package ifEx;

public class IfEx10 {
	public static void main(String[] args) {
		int score=97;
		String result="";
		
		if(score>=90) {
			if(score>=95) {
				result="A+";
			}else {
				result="A";
			}
		}
		System.out.println(result);
		//result 오류
		//if문이 false일 때 값이 없기 때문에 result의 초기화 필수!
		//String타입은 "" 공백도 문자로 취급
	}
}
