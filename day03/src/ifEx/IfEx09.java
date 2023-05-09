package ifEx;

public class IfEx09 {
	public static void main(String[] args) {
		int a=100;
		if(a>0) {
			int x=1000;
			
			System.out.println(a);
			System.out.println(x);
		}
		System.out.println(a);
//		System.out.println(x);	선언된 영역{}밖이라서 지역변수 삭제, 오류!	
	}
}
