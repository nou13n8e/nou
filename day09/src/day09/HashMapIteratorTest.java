package day09;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapIteratorTest {	//HashMap에서 Iterator 사용하기
	public static void main(String[] args) {
		HashMap<String, Integer> score=new HashMap<>();
		score.put("김가나",85);				//put으로 값을 입력하는 중
		score.put("이나다",88);				//get으로 값을 출력
		score.put("강다라",90);
		score.put("권라마",95);
		score.put("장마바",85);
		score.put("정바사",82);
		score.put("박사아",83);
		
		//Set :  데이터 중복을 허용하지 않고 순서는 무작위로 출력
		Set<String> keyList=score.keySet();	//keySet : key값만 추출
		Iterator<String> iterator=keyList.iterator();
		while(iterator.hasNext()) {			//hasNext의 값는 true/false
			String name=iterator.next();	//다음 값인 next를 name에 대입
			int num=score.get(name);		//name에 대입된 key값들을 num에 대입
			System.out.println(name+" : "+num);
		}
	}
}
