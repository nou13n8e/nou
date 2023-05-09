package day10;

import java.io.FileInputStream;

public class FileInputStreamTest {	// byte타입 파일을 읽기
	public static void main(String[] args) {
		byte byteArray[] = new byte[6]; // 배열 생성
		try {
			FileInputStream fileInputStream = new FileInputStream("C:\\Temp\\FileInputStreamTest.out");
			int num = 0;
			int c;
			while ((c = fileInputStream.read()) != -1) {
				byteArray[num] = (byte) c;
				num++;
			}
			for (int i = 0; i < byteArray.length; i++) {
				System.out.println(byteArray[i]);
			}
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
