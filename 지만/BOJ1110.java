import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = null;
		int B = 0;
		int N = 0;
		int cycle = 0;

		while (true) {
			N = sc.nextInt();
			if (N >= 0 && N <= 99) {
				break;
			}
		}

		A = Integer.toString(N);
		if (N < 10)
			A = "0" + A;

		while (true) {

			B = Integer.parseInt(A.substring(0, 1)) + Integer.parseInt(A.substring(1));
			A = A.substring(1) + (B % 10);
			cycle++;
			if (Integer.parseInt(A) == N)
				break;

		}
		System.out.println(cycle);
	}
}