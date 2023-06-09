import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int cnt = 0;
		for(int i = 5; i <= n; i += 5) {
			int num = i;
			while(true) {
				cnt++;
				num /= 5;
				
				if(num % 5 != 0) {
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}