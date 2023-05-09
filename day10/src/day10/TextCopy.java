package day10;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class TextCopy {
	public static void main(String[] args) {
		File original = new File("C:\\windows\\system.ini");
		File copy = new File("C:\\Temp\\system.txt");
		int c;
		try {
			FileReader fileReader = new FileReader(original); // system.ini를 original로 읽어서
			FileWriter fileWriter = new FileWriter(copy); // system.txt로 copy에 쓰기
			while ((c = fileReader.read()) != -1) {
				fileWriter.write((char) c); // 텍스트 파일은 char로 형변환
			}
			fileWriter.close();
			fileReader.close();
			System.out.println(original.getPath() + "를 " + copy.getPath() + "로 복사하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
