import java.util.Scanner;

public class Main {
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int cnt = 0;
		
		while(num >= 5) {
			num /= 5;
			cnt+=num;
		}
		
		System.out.println(cnt);

	}
}