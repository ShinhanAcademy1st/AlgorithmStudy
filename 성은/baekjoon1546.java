import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		double sum = 0, avg=0;
		double[] arr=new double[a];
		for(int i=0;i<a;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0;i<a;i++) {
			sum += arr[i]/arr[a-1]*100.0;
		}
		avg=sum/a;
		System.out.println(avg);
	}
}