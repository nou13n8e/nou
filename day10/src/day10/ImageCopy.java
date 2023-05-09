package day10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

public class ImageCopy {
	public static void main(String[] args) {
		File originalImg = new File("C:\\Temp\\jun.jpg");
		File copyImg = new File("C:\\Temp\\jun_copy.jpg");
		Date date = null;
		int c;
		try {
			FileInputStream fileInputStream = new FileInputStream(originalImg);
			FileOutputStream fileOutputStream = new FileOutputStream(copyImg);
			byte buffer[] = new byte[1024];
			date = new Date();
			long start = date.getTime();

//			while ((c = fileInputStream.read()) != -1) {
//				fileOutputStream.write((byte) c); // 이미지 파일은 byte로 형변환
//			}
			while (true) {
				int num = fileInputStream.read(buffer); // 버퍼가 읽은 값만큼 num에 대입
				fileOutputStream.write(buffer, 0, num);
				if (num < buffer.length)
					break;
			}
			date = new Date();
			long end = date.getTime();
			System.out.println((end - start));

			fileInputStream.close();
			fileOutputStream.close();
			System.out.println(originalImg.getPath() + "를 " + copyImg.getPath() + "로 복사하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
