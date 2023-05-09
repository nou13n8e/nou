package day10;

import java.io.FileWriter;
import java.util.Scanner;

public class FileWriterTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // 스캐너로 값을 입력받아서 출력
		try {
			FileWriter fileWriter = new FileWriter("C:\\Temp\\FileWriterTest.txt"); // 파일 위치 지정
			while (true) {
				String line = scanner.nextLine(); // 스캐너로 값을 입력받을 line 생성
				if (line.length() == 0)
					break; // 한 글자도 입력하지 않았을 때 break;
				fileWriter.write(line, 0, line.length());
				fileWriter.write("\r\n"); // 줄바꿈을 하고 싶을 때 '캐리즈 리턴'
			}
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
