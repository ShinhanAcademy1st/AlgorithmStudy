import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = num;
		int cnt = 0;
		
		while(true) {
			cnt++;
			int share = sum/10;	//몫
			int remain = sum%10; //나머지 : 우측 숫자
			//sum=share+remain;
			sum = remain*10+(share+remain)%10;
			if(sum==num)
				break;
		}
		System.out.println(cnt);
	}
}