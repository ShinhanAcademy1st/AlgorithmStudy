import java.util.Scanner;


public class BOJ1546 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 0;
		int max = 0;
		float avg=0;
		float sum =0;
		while (true) {
			N = sc.nextInt();
			if (N > 0 && N <= 1000) {
				break;
			}
		}
		
		int score[] = new int[N];
		float scorebabo[] = new float[N];
		
		for (int i = 0; i < N; i++) {
			while (sc.hasNextInt()) {
				score[i] = sc.nextInt();
				if (score[i] > 0 && score[i] <= 100) {
					break;
				}
			}
			if (max < score[i]) {
				max = score[i];
			}
		}
		for (int i = 0; i < N; i++) {
		scorebabo[i] = (float)score[i]/max*100;
		sum+=scorebabo[i];
		}
		avg = sum/N;
		System.out.println(avg);
	}

}
//과목 개수 N
//N 만큼 점수 받고 그 중 최대값을 골라 최대값*100 이란 값을 만든다
//받은 점수들에 최대값*100 을 나눠준다
//이 점수들의 평균을 구한다
//세준이는 양아치