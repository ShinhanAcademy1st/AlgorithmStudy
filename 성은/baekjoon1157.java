import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = str.toUpperCase();
		String result;
		int[][] arr = new int[str.length()][2];

		for (int i = 0; i < str.length(); i++) {
			int count=0;
			arr[i][0] = str.charAt(i);
			count=countChar(str,str.charAt(i));
			str=str.replace(String.valueOf(str.charAt(i)), "");
			arr[i][1]=count;
		}
		if (arr.length == 1)
			result = Character.toString(arr[0][0]);
		else {
			//개수 기준으로 내림차순
			Arrays.sort(arr, (o1, o2) -> {
				return o2[1] - o1[1];
			});
			if (arr[0][1] == arr[1][1]) {
				result = "?";
			} else {
				result = String.valueOf(arr[0][0]);
			}
		}
		System.out.println(result);
	}
	
	//문자열 대체 후 문자열 길이의 차이로 포함된 개수 구하기
	public static int countChar(String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }
}