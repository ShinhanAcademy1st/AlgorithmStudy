package backjoon;

import java.util.Scanner;

public class BOJ1676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int count = 0;

		while (num >= 5) {
			count += num / 5;
			num /= 5;
		}
		System.out.println(count);
	}
}
//n!에서 처음 0이 아닌 숫자가 나올때 까지의 0의 갯수
//