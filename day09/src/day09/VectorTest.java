package day09;

import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		Vector<Integer> vector=new Vector<>();
		vector.add(5);
		vector.add(3);
		vector.add(1);
		
		System.out.println(vector.size());		//vector에 입력된 값의 갯수 출력
		
		System.out.println(vector.get(0));		//0번에 입력된 값 출력
		System.out.println(vector.get(1));		//1번에 입력된 값 출력
		System.out.println(vector.get(2));		//2번에 입력된 값 출력
		System.out.println(vector.capacity());	//메모리를 차지하는 용량을 byte단위로 측정
		
		for(int i=0; i<vector.size(); i++) {
			int num=vector.get(i);				//print문을 여러 번 사용하지 않고
			System.out.print(num+", ");			//for문을 사용해 전체의 값 출력하는 방법
		}
		
		for(int num:vector) {
			System.out.print(num+", ");			//for-each문을 사용해 전체의 값 출력하는 방법
		}
	}
}
