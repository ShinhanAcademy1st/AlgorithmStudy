package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;

/**
 * 문제 : N개의 운동기구를 하루 최대 2개를 사용했을 때 만들 수 있는 가장 적은 근손실을 구한다.
 * 입력 : 운동 기구의 개수 N, 운동 기구 별 근손실 정도를 나타내는 N개의 정수
 * 1 ≤ N ≤ 10000, N개의 근손실 정도 t 0 ≤ t ≤ 10^18
 * 출력 : 가장 적은 근손실 정도의 합
 * 
 * N개의 운동기구를 한 번씩 사용해 보고 싶은 향빈이는 PT를 받을 때마다 이전에 사용하지 않았던 운동기구를 선택
 * 비용을 절약하기 위해 PT를 한 번 받을 때 운동기구를 되도록 2개씩 사용
 * ex) 운동기구 10개 : PT 5번, 9개 : 5번 받지만 마지막 PT에는 운동기구 하나만 사용
 * 
 * 
 * -----사용 변수-----
 * int n : 정수의 개수
 * long [] loses : 크기 10000개의 배열
 * long minLose : 최소 근손실
 * 
 * 최소의 근손실 합을 구하기 위해서는 가장 많은 근손실이 일어나는 수치와, 가장 적게 근손실이 일어나는 수치를 합해야 최소 근손실을 구할 수 있다.
 * 예를 들어, 4개의 운동기구가 있다고 가정 했을 때, 낮은 수치대로 1번째와 2번째 기구를 사용하고 3번째와 4번째 기구를 사용한다면
 * 3번째와 4번째 기구의 근손실 합이 너무 크다. 다시 말해, 가장 높은 수치를 가장 적은 수치와 합하여 적게 만든다.
 * 운동 기구가 홀수라면, 한 번의 PT는 2개가 아닌 하나의 운동기구를 사용한다.
 * 이 경우, 가장 높은 근손실을 내는 운동기구 하나만 선택하고 나머지 운동기구들을 위에 설명한 대로 사용한다.
 * 이 중에서 가장 많은 근손실을 내는 합이 이 문제에서의 정답이 된다.
 * 
 * 1. n개의 수치를 오름차순으로 정렬
 * 2. n이 홀 수라면, minLose = 제일 무거운 무게
 * 3. 0부터 n / 2 - 1번째 까지 순회하며, 앞에서 i번째와 뒤에서 i번째의 합을 구한다.
 * 3-1. 해당 합이 현재까지의 minLose보다 크다면 minLose = 앞에서 i번째의 근손실 + 뒤에서 i번째의 근손실
 * 4. minLose 출력
 * 
 * 
 */
public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long [] loses = new long[n];
		String [] tmp = br.readLine().split(" ");
		br.close();
		for (int i = 0; i < n; ++i) {
			loses[i] = Long.parseLong(tmp[i]);
		}
		Arrays.sort(loses);
		long minLose = 0;
		if (n % 2 == 1) {
			--n;
			minLose = loses[n];
		}
		for (int i = 0; i < n; ++i) {
			long lose = loses[i] + loses[n - 1 - i];
			if (minLose < lose) {
				minLose = lose;
			}
		}
		System.out.println(minLose);
	}
}