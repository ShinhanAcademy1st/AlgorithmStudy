import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		double N,M;
		double result;
		for (int i = 0; i < test; i++) {
			N = sc.nextDouble();
			M = sc.nextDouble();
			double a=1, b=1;
			for(double j=M;j>M-N;j--) {
				a*=j;
			}
			for(double j=N;j>0;j--) {
				b*=j;
			}
			result=a/b;
			System.out.printf("%.0f\n",result);
		}
	}
}