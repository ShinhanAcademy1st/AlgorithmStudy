package com.shinhan.education;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		br.close();
		char result = '0';
		Queue<String> q = new LinkedList<>();
		q.offer(t);
		while (!q.isEmpty()) {
			String front = q.poll();
			int length = front.length();
			if (s.length() == length) {
				if (front.equals(s)) {
					result = '1';
					break;
				}
				continue;
			}
			if (front.charAt(0) == 'B') {
				StringBuffer sb = new StringBuffer(front.substring(1));
				q.offer(sb.reverse().toString());
			}
			if (front.charAt(length - 1) == 'A') {
				q.offer(front.substring(0, length - 1));
			}
		}
		System.out.println(result);
	}
}
