package ifEx;

public class IfEx03 {	//if와 else
	public static void main(String[] args) {
		int a=6;
		if(a<0) {
			System.out.println("크다");	//false, 실행하지 않음
		}else {
			System.out.println("작다");	//true, 실행함
		}
		System.out.println(a);
	}
}
