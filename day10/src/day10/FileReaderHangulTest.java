package day10;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileReaderHangulTest {	//한글일 경우(인코딩 ANSI로 변경해서 저장) 인코딩을 거쳐야 정상적으로 출력 가능
	public static void main(String[] args) {
		try { // 파일이 있는지 없는지 모르니 "예외 처리" surround with try/catch
			FileInputStream fileInputStream = new FileInputStream("C:\\Temp\\FileReaderHangulTest.txt");
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "MS949"); // 인코딩 방식 설정
			System.out.println("인코딩 방식은 " + inputStreamReader.getEncoding()); // 인코딩 방식 출력
			int c;
			while ((c = inputStreamReader.read()) != -1) { // 가장 마지막 글자까지 받아야하므로 -1 설정
				System.out.print((char) c);
			}
			inputStreamReader.close();
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace(); // 에러가 날 경우 에러가 난 이유를 출력
		}
	}
}
