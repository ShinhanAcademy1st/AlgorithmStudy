import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		int result=cycle(num);
		int count=1;
		while(result!=num) {
			result=cycle(result);
			count++;
		}
		System.out.println(count);
	}
	
	public static int cycle(int a) {
		int[] arr=new int[2];
		arr[0]=a/10;
		arr[1]=a%10;
		int sum=arr[0]+arr[1];
		int result=(sum%10)+(arr[1]*10);
		return result;
	}
}