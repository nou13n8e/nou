package quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

public class WordsSearch {
	public static void main(String[] args) {
		File file = new File("C:\\Temp\\words.txt");
		Vector<String> wordList = new Vector<>();
		Scanner scanner = new Scanner(System.in);

		try { // surround with try/catch
			FileReader fileReader = new FileReader(file);
			BufferedReader wordReader = new BufferedReader(fileReader);
			while (true) {
				String line = wordReader.readLine(); 		// 버퍼에서 한 줄씩 읽어오는 중
				if (line == null) break; 					// null이면 break;
				wordList.add(line); 						// 벡터에 값 추가하는 중
			}
			wordReader.close();
			System.out.println(wordList.size());			// 벡터에 입력된 값의 갯수를 출력

			while (true) {
				System.out.println("단어를 입력하세요.");
				String searchWord = scanner.nextLine(); 	// 스캐너에 입력된 값을 searchWord에 대입
				if (searchWord.equals("끝")) break; 			// 스캐너에 "끝"이 입력되면 break;
				for (int i = 0; i < wordList.size(); i++) { // wordList의 값만큼 반복
					String word = wordList.get(i); 			// word에 i의 값을 대입
					if (word.length() < searchWord.length())
						continue; 							// 찾는 단어가 찾은 단어보다 짧으면 continue;
					String frontWord = word.substring(0, searchWord.length());
															// substring : 문자열을 자르는 함수
															// 0부터 searchWord의 길이만큼 자른 뒤
															// frontWord에 대입
					if (searchWord.equals(frontWord)) {
						System.out.println(word);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
