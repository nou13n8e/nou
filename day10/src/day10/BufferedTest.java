package day10;

import java.io.BufferedOutputStream;
import java.io.FileReader;

public class BufferedTest {
	public static void main(String[] args) {
		int c;
		try {
			FileReader fileReader = new FileReader("C:\\Temp\\BufferedTest.txt"); // 1234567
//			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(System.out, 1);
//			범위 지정을 1로 했을 때 123456까지 출력되는 이유는 7이 들어오면서 6이 출력되고 난 뒤 더 이상 값이 입력되지 않기 때문
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(System.out, 8); // 범위 지정
			while ((c = fileReader.read()) != -1) {
				bufferedOutputStream.write(c);
			}
			bufferedOutputStream.flush(); // 8개가 넘지 않아도 전부 다 밀어내려가도록
		} catch (Exception e) {
			e.printStackTrace();
		}
		//입력된 값이 지정된 범위 밖으로 나오면 출력,
		//flush;를 이용해서 지정된 범위 밖으로 나오지 않아도 출력 가능
	}
}
