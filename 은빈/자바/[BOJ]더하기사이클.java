import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int origin = n;
		int cnt = 0;

		while (true) {
			cnt++;
			int x = Math.floorDiv(n, 10);
			int y = Math.floorMod(n, 10);

			int num = x + y;
			n = (y * 10) + (num % 10);

			if (n == origin) {
				break;
			}
		}

		System.out.println(cnt);
    }
}