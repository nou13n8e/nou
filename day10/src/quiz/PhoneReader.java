package quiz;

import java.io.File;
import java.io.FileReader;

public class PhoneReader {	//PhoneWriter에서 입력한 전화번호부를 읽어서 출력하기
	public static void main(String[] args) {
		File phone = new File("C:\\Temp\\phone.txt");
		try {
			int c;
			FileReader fileReader = new FileReader(phone);
			while (true) { // while문 안에 넣는 조건을 다르게
				c = fileReader.read();
				if (c == -1)
					break;
				System.out.print((char) c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
