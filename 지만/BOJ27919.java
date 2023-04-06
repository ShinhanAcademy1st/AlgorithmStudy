package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;


public class BOJ27919 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String V = br.readLine();
		int UC = 0, DP = 0;
		
		for (int i = 0; i < V.length(); i++) {
			String s = V.substring(i, i + 1);
			if(s.equals("U")||s.equals("C")) {
				UC++;
			}else if(s.equals("D")||s.equals("P")) {
				DP++;
			}
		}
		
		String result = "";
		if(UC>((DP+1)/2)) {
			result+="U";
		}
		if(DP>0) {
			result+="DP";
		}
	System.out.println(result);
	 
	}
}
