package com.BackJoon;

import java.util.Scanner;

public class BOJ2217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 0;
		int min = 10000;
		int max = 0;
		int MAX = 0;

		while (true) {
			N = sc.nextInt();
			if (N >= 1 && N <= 100000)
				break;
		}

		int K[] = new int[N];
		int count = N;
		for (int i = 0; i < N; i++) {
			while (sc.hasNextInt()) {
				K[i] = sc.nextInt();
				if (K[i] > 0 && K[i] < 10000)
					break;
			}
		}
		for (int j = 0; j < N; j++) {
			for (int i = j; i < N; i++) {
				if (min > K[i]) {
					min = K[i];
				}
			}
			max = min * count;
			min = 10000;
			count--;
			if (MAX < max) {
				MAX = max;
			}
		}
		System.out.println(MAX);

	}
}
//N개의 로프가 있다. 로프들은 서로 들 수 있는 중량이 다르다
// 병령로 열결하면 중량을 w/k로 고르게 나뉘어진다. w=중량 k=로프의 개수
//최대 중량을 구해내는 프로그램을 작성
//첫째 줄에는 정수 N 다음 N개의 줄에는 로프가 버틸 수 있는 최대 중량.
//=가장 작은 힘을 가질 수 있는 로프 x 로프 개수
