package quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PhoneBufferedReader {
	public static void main(String[] args) {
		File phone = new File("C:\\Temp\\phone.txt");

		try {
			FileReader fileReader = new FileReader(phone);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while (true) {
				String line = bufferedReader.readLine(); // String타입으로 출력(리턴)
				if (line == null)
					break;
				System.out.print(line + "\r\n");
			}
			bufferedReader.close();
		} catch (Exception e) {
		}
	}
}
