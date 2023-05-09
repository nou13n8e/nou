package day09;

import java.util.Iterator;
import java.util.Vector;

class Point{								//클래스 생성
	private int x,y;						//사용할 변수 선언

	public Point(int x, int y) {			//생성자 생성
		this.x = x;
		this.y = y;
	}

	public int getX() {						//getter생성
		return x;
	}
	public int getY() {
		return y;
	}

	@Override
	public String toString() {				//toString 오버라이드
		return "Point [x=" + x + ", y=" + y + "]";
	}
}

public class VectorIteratorTest {
	public static void main(String[] args) {
		Vector<Point> pointVector=new Vector<>();
		
		pointVector.add(new Point(10,10));	//add로 값을 입력하는 중
		pointVector.add(new Point(20,20));
		pointVector.add(new Point(30,30));
		
//		System.out.println(pointVector.get(0).getX());		//x값만 출력
//		System.out.println(pointVector.get(0).getY());		//y값만 출력
//		System.out.println(pointVector.toString());			//전체의 값 출력 1
		
//		for(int i=0; i<pointVector.size(); i++) {		
//			Point point=pointVector.get(i);					//for문을 이용한
//			System.out.println(point.toString());			//전체의 값 출력 2
//		}
		
//		for(Point point:pointVector) {						//for-each문을 이용한
//			System.out.println(point.toString());			//전체의 값 출력 3
//		}
		
		Iterator<Point> iterator=pointVector.iterator();	//iterator를 이용한
		while(iterator.hasNext()) {							//전체의 값 출력 4
			System.out.println(iterator.next().toString());
		}
	}
}
