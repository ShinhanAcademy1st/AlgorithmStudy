package backjoon;

import java.util.Scanner;

public class BOJ2605 {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        long num1 = sc.nextLong();
	        long num2 = sc.nextLong();
	        
	        long gcd = GCD(Math.max(num1, num2), Math.min(num1, num2));//큰 수가 앞으로 오게 해준다
	        long lcm = LCM(num1, num2, gcd);
	        
	        System.out.println(gcd);
	        System.out.println(lcm);
	    }
	 
	    public static long GCD(long a, long b) {
	        while(b > 0) {
	            long tmp = a;
	            a = b;
	            b = tmp%b;
	        }
	        return a;
	    }
	    
	    public static long LCM(long a, long b, long gcd) {
	        return (a*b)/gcd;
	    }
}
//최대공약수 최소공배수 구하기