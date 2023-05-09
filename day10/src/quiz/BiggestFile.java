package quiz;

import java.io.File;

public class BiggestFile {	//C디렉토리 안에 있는 모든 파일 중에 용량이 가장 큰 파일 찾아보기
	public static void main(String[] args) {
		File file = new File("C:\\");
		File files[] = file.listFiles(); // C디레토리 안에 있는 파일들의 배열 생성
		long bigSize = 0;
		File bigFile = null;
		System.out.println(files.length); // 배뎔에 들어있는 값들의 갯수 출력 (=25)

		for (int i = 0; i < files.length; i++) {
			File tempFile = files[i];
			if (tempFile.isDirectory())
				continue; // 디렉토리를 만나면 건너뛰게
			long fileSize = tempFile.length();
			if (fileSize > bigSize) {
				bigSize = fileSize;
				bigFile = tempFile;
			}
		}
		System.out.println("가장 큰 파일은 " + bigFile.getPath() + "용량은 " + bigSize + "byte입니다.");
	}
}
