package day01;

public class Ex10 {
	public static void main(String[] args) {
		//오버플로우 : 표현할 수 있는 범위를 초과해서 나타나는 현상
		
		int a=130;
		byte b=(byte)a;
		System.out.println(b);
	}
}
