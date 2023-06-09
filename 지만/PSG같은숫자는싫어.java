package com.BackJoon;

import java.util.ArrayList;

public class PSG같은숫자는싫어 {
	public static void main(String[] args) {
		int arr1[] = {1, 1, 3, 3, 0, 1, 1};
		
	
		int num=-1;
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i=0;i<arr1.length;i++) {
		
				if(arr1[i]!=num) {	
					num=arr1[i];
					result.add(num);
				}
		}

		 int[] answer = new int[result.size()];
		for(int i =0;i<result.size();i++) {
			answer[i] = result.get(i);
			System.out.println(answer[i]);
		}
	
	}
}
