package day09;

import java.util.ArrayList;

public class ArrayListTest {	//입력된 이름들 중 가장 긴 이름 출력하기
	public static void main(String[] args) {
		ArrayList<String> nameList=new ArrayList<>();
		nameList.add("토르");							//add로 값을 입력하는 중
		nameList.add("아이언 맨");
		nameList.add("캡틴 아메리카");
		nameList.add("블랙 펜서");
		nameList.add("스파이더 맨");
		nameList.add("블랙 위도우");
		
		int longest = 0;							//가장 긴 이름을 대입할 변수 선언
		
		for(int i=0; i<nameList.size(); i++) {
			System.out.println(nameList.get(i));	//for문을 사용해 전체의 값 출력
		}
		
		for(int i=0; i<nameList.size(); i++) {		//ArrayList에 입력된 값의 크기만큼 반복
			if(nameList.get(longest).length() < nameList.get(i).length()) {
													//i의 길이가 longest보다 길다면 i의 값을 longest에 대입
				longest=i;
			}
		}
		System.out.println("가장 긴 이름은 "+nameList.get(longest)+"입니다.");
	}
}
