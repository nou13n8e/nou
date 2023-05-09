package ifEx;

public class IfTest {
	public static void main(String[] args) {
		int kor=93;
		int eng=90;
		int mat=85;
		
		int sum=(kor+eng+mat);
		double average=(sum/3);
		
		if(sum>=250) {
			System.out.println("국어 점수는 "+kor+"점입니다.");
			System.out.println("영어 점수는 "+eng+"점입니다.");
			System.out.println("수학 점수는 "+mat+"점입니다.");
			System.out.println("총점은 "+sum+"입니다.");
			System.out.println("평균은 "+average+"입니다.");
		}
		
		
		String result;
		
		if(average>=90){
			result="학점은 A입니다.";
		}else if(average>=80){
			result="학점은 B입니다.";
		}else if(average>=70){
			result="학점은 C입니다.";
		}else if(average>=60){
			result="학점은 D입니다.";
		}else{
			result="학점은 F입니다.";
		}
		System.out.println(result);
		
		
		String error;

		if(kor>100){
			error="잘못 입력하셨습니다.";
		}else if(eng>100){
			error="잘못 입력하셨습니다.";
		}else if(mat>100){
			error="잘못 입력하셨습니다.";
		}else{
			error="정상";
		}
		System.out.println(error);	
	}
}
