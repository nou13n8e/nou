package day09;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListIteratorTest {	//ArrayList에서 Iterator 사용하기
	public static void main(String[] args) {
		ArrayList<String> nameList=new ArrayList<>();
		nameList.add("토르");								//add로 값을 입력하는 중
		nameList.add("아이언 맨");
		nameList.add("캡틴 아메리카");
		nameList.add("블랙 펜서");
		nameList.add("스파이더 맨");
		nameList.add("블랙 위도우");
		
//		for(int i=0; i<nameList.size(); i++) {
//			System.out.println(nameList.get(i));		//for문을 사용해 전체의 값 출력
//		}
		
		Iterator<String> iterator=nameList.iterator();	//iterator를 사용해 전체의 값 출력
		while(iterator.hasNext()) {						//hasNext의 값은 true/false
			System.out.println(iterator.next());		//next는 다음 값을 출력
		}
	}
}
