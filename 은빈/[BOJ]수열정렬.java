// 백준 1015
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] tmp = new int[n];
		List<Integer> a = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			tmp[i] = num;
			a.add(num);
		}

		Arrays.sort(tmp);
		int[] p = new int[n];
		
		
		for (int i = 0; i < n; i++) {
			int idx = a.indexOf(tmp[i]);
			p[idx] = i;
			a.set(idx, 0);
		}

		for (int num : p) {
			System.out.print(num + " ");
		}
		
	}
}