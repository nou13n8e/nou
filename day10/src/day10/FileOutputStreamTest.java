package day10;

import java.io.FileOutputStream;

public class FileOutputStreamTest {	//byte타입 파일을 내보내기
	public static void main(String[] args) {
		byte byteArray[]= {7,51,3,4,-1,24};	//배열 생성
		try {
			FileOutputStream fileOutputStream=new FileOutputStream("C:\\Temp\\FileOutStreamTest.out");
			for(int i=0; i<byteArray.length; i++) {
				fileOutputStream.write(byteArray[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
