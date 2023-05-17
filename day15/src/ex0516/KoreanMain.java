package ex0516;

public class KoreanMain {
	public static void main(String[] args) {
		Korean k1 = new Korean("이하나", 890826);
		System.out.println("k1.name : " + k1.name);
		System.out.println("k1.birth : " + k1.birth);
		
		Korean k2 = new Korean("이지애", 900902);
		System.out.println("k2.name : " + k2.name);
		System.out.println("k2.birth : " + k2.birth);
	}
}
