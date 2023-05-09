package day10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	public static void main(String[] args) { // 파일이 있는지 없는지 모르니 "예외 처리" surround with try/catch
		try { // 밑에 있는 코드 실행
			FileReader fileReader = new FileReader("C:\\windows\\system.ini");
			try {
				int c;
				while ((c = fileReader.read()) != -1) { // c에 대입된 값이 -1이 아니라면 반복
					System.out.print((char) c);
				}
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) { // 예외가 발생하면 print문 출력
//			e.printStackTrace();			//에러가 날 경우 에러가 난 이유를 출력
			System.out.println("입출력 오류");
		}
	}
}
