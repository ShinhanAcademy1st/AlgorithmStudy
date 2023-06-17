import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		String n = sc.next();
		for (int i = 0; i < n.length(); i++) {
			int num = n.charAt(i)-'0';
			num=(num==6?9:num);
			arr[num]++;
		}
		arr[9]=(arr[9]/2)+(arr[9]%2);
		Arrays.sort(arr);
		System.out.println(arr[9]);
    }
}