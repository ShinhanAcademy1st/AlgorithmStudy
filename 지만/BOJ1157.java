package backjoon;

import java.util.Scanner;

public class BOJ1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[26]; // 26개의 영문자를 받겟다
		String str = sc.next();

		for (int i = 0; i < str.length(); i++) {
			if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') { // 대문자 범위
				arr[str.charAt(i) - 'A']++; // 해당 인덱스의 값 1 증가
			}else { // 소문자 범위
				arr[str.charAt(i) - 'a']++;
			}
		}

		int max = -1;
		char ch = '?';

		for (int i = 0; i < 26; i++) {
			if (arr[i] > max) {
				max = arr[i];
				ch = (char) (i + 65); //대문자여서 65 증가
			} else if (arr[i] == max) {
				ch = '?';
			}
		}

		System.out.print(ch);
	}
}
//대소문자 구분없는 문자열을 입력받아 가장 많이 사용된 알파펫 출력