package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 : n개의 정수로 이루어진 임의의 수열이 주어진다.
 * 		우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
 * 		단, 수는 한 개 이상 선택해야 한다.
 * 		예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자.
 * 		여기서 정답은 12+21인 33이 정답이 된다.
		
 * 입력 : 첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다.
 * 		수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
 *		 
 * 출력 : 첫째 줄에 답을 출력한다.
 * 
 * -----사용 변수-----
 * int n : nums 배열에 저장될 n개의 숫자
 * int nums[n][2]
 * -- nums[n][0] : 입력되는 n개의 숫자
 * -- nums[n][1] : 누적되는 합 저장
 * 
 * 연속되는 숫자의 합 중 최대 수를 찾는 문제이다.
 * i번째 숫자까지 연속되는 숫자의 최대 합은 두가지로 나뉜다.
 * 1) i - 1번째 숫자까지의 누적합 + i번째 숫자 < i번째 숫자인 경우
 *   : i번째 숫자까지의 누적합은 i번째 숫자를 사용한다.
 *   (nums[i][1] = nums[i][0])
 * 2) i - 1번째 숫자까지의 누적합 + i번째 숫자 > i번째 숫자인 경우
 *   : i번째 숫자까지의 누적합은 i - 1번째 숫자까지의 누적합 + i번째 숫자
 *   (nums[i][1] = nums[i - 1][1] + nums[i][0]
 *   
 * 1. nums[0][1] = nums[0][0]으로 설정한다. -> 0번째 숫자는 젤 앞의 숫자이기 때문에 더 이전의 숫자는 존재하지 않기 때문
 * 2. 1 ~ n - 1까지 순회하며 위의 2) 공식에 따라 nums[i][1] 계산
 * 3. nums[i][1]에 저장된 숫자 중 가장 큰 숫자 출력
 * 
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] nums = new int[n][2];
		String[] numsStr = br.readLine().split(" ");
		br.close();
		for (int i = 0; i < n; ++i) {
			nums[i][0] = Integer.parseInt(numsStr[i]);
		}
		nums[0][1] = nums[0][0];
		for (int i = 1; i < n; ++i) {
			if (nums[i - 1][1] <= 0) {
				nums[i][1] = nums[i][0];
			}
			else {
				nums[i][1] = nums[i - 1][1] + nums[i][0];
			}
		}
		int max = nums[0][1];
		for (int i = 1; i < n; ++i) {
			if (nums[i][1] > max) {
				max = nums[i][1];
			}
		}
		System.out.println(max);
	}
}