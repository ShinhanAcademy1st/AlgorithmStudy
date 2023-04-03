package com.BackJoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1427 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 0;
		N = sc.nextInt();
		int i = 0;
		int counting[] = new int[10];
		while (N > 0) {
			counting[i] = N % 10;
			i++;
			N = N / 10;
			if (i == 10) {
				break;
			}
		}
		for (int k = 0; k < i; k++) {
			for (int j = k+1; j < i; j++) {
				if (counting[k] < counting[j]) {
					int temp = counting[k];
					counting[k] = counting[j];
					counting[j] = temp;
				}
			}
		}
		for (int k = 0; k < i; k++) {

			System.out.print(counting[k]);
		}

	}
}
