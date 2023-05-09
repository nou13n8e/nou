package day01;

public class Ex09 {	//타입의 변환
	public static void main(String[] args) {
		//디모션, 다운캐스팅 : 큰 타입 -> 작은 타입
		//변환하려고 하는 타입명을 명시할 것!
		
		int a=97;
		char b=(char)a;
		System.out.println(a);
		System.out.println(b);
		
		double x=10.5;
		int y=(int)x;
		System.out.println(x);
		System.out.println(y);
		//0.5의 데이터 손실 발생
		
		double z=(double)y;
		System.out.println(z);
		//double타입으로 재변환 시켜도 회복 불가능
	}
}
