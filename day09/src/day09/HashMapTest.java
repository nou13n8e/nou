package day09;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, String> dictionary=new HashMap<>();
		dictionary.put("apple", "사과");					//put으로 값을 입력하는 중
		dictionary.put("grape", "포도");					//get으로 값을 출력
		dictionary.put("strawberry", "딸기");
		dictionary.put("pear", "배");
		dictionary.put("mango", "망고");
		dictionary.put("watermelon", "수박");
		dictionary.put("orange", "오렌지");
		
//		String kor=dictionary.get("orange");			//해당하는 key값을 대입하면
//		System.out.println(kor);						//해당하는 value값이 출력
		
		Scanner scanner=new Scanner(System.in);
		while(true) {
			System.out.println("찾고 싶은 단어를 입력하세요. exit를 입력하면 종료됩니다.");
			String eng=scanner.next();					//스캐너에서 입력받은 key값을 eng에 대입
			if(eng.equals("exit")) break;				//exit를 입력하면 종료
			String kor=dictionary.get(eng);				//value값은 key값으로 추출해 kor에 대입
			if(kor==null) System.out.println("없는 과일입니다.");
			else System.out.println(kor);				//eng에 맞는 kor를 출력
		}
	}
}
