package day09;

import java.util.HashMap;
import java.util.Scanner;

class Student{								//클래스 생성
	private int id;							//사용할 변수 선언
	private String tel;
	public Student(int id, String tel) {	//생성자 생성
		this.id = id;
		this.tel = tel;
	}
	public int getId() {					//getter 생성
		return id;
	}
	public String getTel() {
		return tel;
	}
}

public class HashMapStudentTest {	//이름을 입력하면 it:=tel이 출력되게 하기
	public static void main(String[] args) {
		HashMap<String, Student> studentMap=new HashMap<>();
		studentMap.put("김가나", new Student(1, "010-1111-1111"));	//put으로 값 입력하는 중
		studentMap.put("이나다", new Student(2, "010-2222-2222"));
		studentMap.put("강다라", new Student(3, "010-3333-3333"));
		studentMap.put("권라마", new Student(4, "010-4444-4444"));
		studentMap.put("장마바", new Student(5, "010-5555-5555"));
		studentMap.put("정바사", new Student(6, "010-6666-6666"));
		studentMap.put("박사아", new Student(7, "010-7777-7777"));
		Scanner scanner=new Scanner(System.in);						//스캐너로 값을 입력
		
		while(true) {
			System.out.println("이름을 입력하세요. 정보를 알려드립니다. exit를 입력하면 종료됩니다.");
			String name=scanner.nextLine();							//스캐너로 입력받은 값을 name에 대입
			if(name.equals("exit")) break;
				Student student=studentMap.get(name);
				if(student==null) System.out.println("없는 사람입니다.");
				else System.out.println(name+" id : "+student.getId()+" = "+student.getTel());
		}
	}
}
