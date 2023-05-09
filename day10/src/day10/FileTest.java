package day10;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		File file01 = new File("C:\\windows\\system.ini");
		System.out.println(file01.getPath()); // 전체 경로 알아보기
		System.out.println(file01.getName()); // 파일명 알아보기
		System.out.println(file01.getParent()); // 부모 경로 알아보기
		System.out.println(file01.isFile()); // 파일인지 디렉토리인지 알아보기
		System.out.println(file01.isDirectory()); // 파일인지 디렉토리인지 알아보기

		File file02 = new File("C:\\Temp\\sample"); // 확장자가 없으면 폴더 생성
		if (!file02.exists()) { // 폴더가 존재하지 않으면(!부정)
			file02.mkdir(); // makeDirectory의 줄임말, 폴더 생성
		}
		file02.renameTo(new File("C:\\Temp\\java_sample")); // 생성한 폴더의 이름을 바꾸기

		File file03 = new File("C:\\Temp");
		File[] subFiles = file03.listFiles(); // 폴더를 배열로 만들기
		for (int i = 0; i < subFiles.length; i++) { // 폴더 안에 생성된 것들 알아보기(리턴)
			File file = subFiles[i];
			System.out.println(file.getName());
		}
	}
}
