package ifEx;

public class IfEx08 {	//if문 속에 if문(중첩 if문)
	public static void main(String[] args) {
		int score=93;
		String grade;
		
		if(score>90) {
			if(score>=95) {
				grade="A+";
			}else {
				grade="A";
			}
		}else {
			if(score>=85) {
				grade="B+";
			}else {
				grade="B";
			}
		}
		System.out.println("학점 : "+grade);
	}
}
