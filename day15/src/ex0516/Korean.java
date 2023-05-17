package ex0516;

public class Korean {
	// 변수 선언
	String nation = "대한민국";	// 모든 객체에 동일하게 들어감.
		
	String name;				// 사람마다 다르니 생성자로 초기화 해준다.
	int birth;
		
	// 생성자 선언
	public Korean(String name, int birth) {	// 생성자의 매개변수 이름은 헷갈릴수 있으니 필드 이름과 같게 적어준다.
		this.name = name;
		this.birth = birth;
	}
}
