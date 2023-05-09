package ifEx;

public class IfEx02 {
	public static void main(String[] args) {
		int score=93;
		if(score>=90) {
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");
		}
		
		if(score<90) {
			System.out.println("점수가 90보다 작습니다.");	//false라서 실행하지 않음
		}
		System.out.println("등급은 B입니다.");				//if문이 끝났기 때문에 실행함
	}
}
