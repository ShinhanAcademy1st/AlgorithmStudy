package com.BackJoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2217_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 0;

		N = sc.nextInt();

		int K[] = new int[N];
		int count = N;
		for (int i = 0; i < N; i++) {

			K[i] = sc.nextInt();

		}
		Arrays.sort(K);

		int max = Integer.MIN_VALUE;

		// 특정 로프를 사용할 경우,
		// 그 로프보다 무게가 큰 로프를 모두 사용하는 것이 이득이다.
		// 따라서, 최대 무게 w는 rope[i] * (N - i)와 같다.
		for (int i = 0; i < N; i++) {
			max = Math.max(max, K[i] * (N - i));
		}
		System.out.println(max);

	}
}
//N개의 로프가 있다. 로프들은 서로 들 수 있는 중량이 다르다
// 병령로 열결하면 중량을 w/k로 고르게 나뉘어진다. w=중량 k=로프의 개수
//최대 중량을 구해내는 프로그램을 작성
//첫째 줄에는 정수 N 다음 N개의 줄에는 로프가 버틸 수 있는 최대 중량.
//=가장 작은 힘을 가질 수 있는 로프 x 로프 개수
