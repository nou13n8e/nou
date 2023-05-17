package ex0516;

public class StudentMain {
	public static void main(String[] args) {
		Student s1 = new Student();
		System.out.println("s1 변수가 Student 객체를 참조합니다.");
		// new Student(); 객체를 생성하고 주소를 Student s1에 리턴하겠다.
		
		Student s2 = new Student();
		System.out.println("s2 변수가 또 다른 Student 객체를 참조합니다.");

		// 변수 s1,s2 스택 영역에 생성, 두개의 Student 객체 힙 영역에 생성 
		// 변수 s1,s2 는 두 객체의 주소를 각각 참조하고 있다.
	}
}
