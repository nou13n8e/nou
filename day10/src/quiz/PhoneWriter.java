package quiz;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneWriter {
	public static void main(String[] args) {
		// 전화번호부
		File file = new File("C:\\Temp\\phone.txt");
		try {
			FileWriter fileWriter = new FileWriter(file);
			Scanner scanner = new Scanner(System.in);
			System.out.println("전화번호를 입력하세요.");
			while (true) {
				System.out.println("이름 전화번호 : ");
				String line = scanner.nextLine();
				if (line.equals("exit"))
					break;
				fileWriter.write(line, 0, line.length());
				fileWriter.write("\r\n");
			}
			scanner.close();
			fileWriter.close();		//fileWriter를 close해야 file에 저장됨
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
