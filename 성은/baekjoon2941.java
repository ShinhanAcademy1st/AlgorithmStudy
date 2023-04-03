import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int count = 0;
		String[] arr = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		for (int i = 0; i < arr.length; i++) {
			if (str.indexOf(arr[i]) < 0)
				continue;
			else {
				while(str.indexOf(arr[i]) >= 0) {
					str=str.replaceFirst(arr[i], " ");
					count++;
				}
			}
		}
		str=str.replaceAll(" ", "");
		for(int i=0;i<str.length();i++) {
			String a =String.valueOf(str.charAt(i));
			str=str.replaceAll(a, " ");
			count++;
			}
		System.out.println(count);
	}
}