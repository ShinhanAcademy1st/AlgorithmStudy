package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 문제 : 홍대병에 걸린 도현이는 겹치는 것을 매우 싫어한다. 특히 수열에서 같은 원소가 여러 개 들어 있는 수열을 싫어한다.
 * 도현이를 위해 같은 원소가 K개 이하로 들어 있는 최장 연속 부분 수열의 길이를 구하려고 한다.
 * 100,000 이하의 양의 정수로 이루어진 길이가 N인 수열이 주어진다. 
 * 이 수열에서 같은 정수를 K개 이하로 포함한 최장 연속 부분 수열의 길이를 구하는 프로그램을 작성해보자.
 * 입력 : 첫째 줄에 정수 N (1 <= N <= 200,000)과 K (1 <= K <= 100)가 주어진다.
 *		 둘째 줄에는 둘째 줄에는 a_1, a_2, ... a_n이 주어진다 (1 <= a_i <= 100,000)
 * 출력 : 조건을 만족하는 최장 연속 부분 수열의 길이를 출력한다.
 * 
 * two pointer 사용
 * 
 * -----사용 변수-----
 * int n : 숫자의 개수
 * int k : 부분 수열 내 허용하는 같은 숫자의 최대 개수
 * int nums[] = n개의 수열을 저장하는 배열
 * int counts[] = 숫자의 개수를 저장할 배열
 * int startIndex = 시작 인덱스
 * int longestLength = 최장 길이
 * int length = 현재 구한 길이
 * 
 * 
 * 숫자의 범위는 1 ~ 100,000로 적기 때문에 배열[100,001]을 사용한다.
 * ex) 5개의 숫자(3, 3, 3, 0, 1)이 있다면,
 * 배열을 끝까지 순회 했을 떄 counts[] = {1, 1, 0, 3}로 나타낼 수 있다.
 * 
 * 1. 0 ~ n-1 번째 인덱스까지 순회하며 각 숫자의 개수를 샌다.
 * 2. 만약 i 번째 숫자의 개수가 k개를 초과 한다면(k개를 초과하지 않을 때는 아무 일도 하지 않는다.)
 * 2-1. i 번째 숫자가 등장하기 전까지의 길이를 센다.
 * 		길이 = i - 시작 인덱스 (시작인덱스 ~ i - 1, i에서 시작인덱스를 빼는 이유는 배열의 첫 인덱스가 0이기 때문)
 * 2-2. (길이 > 이전의 최장길이) -> 최장길이 = 길이
 * 2-3. 시작 인덱스 조정(따로 설명)
 * 
 * 3. 반복문 종료 후, 시작 인덱스 ~ 마지막 숫자까지의 길이를 잰다.(길이 = n - 시작인덱스)
 * 4. (길이 > 이전의 최장길이) -> 최장길이 = 길이
 * 5. 최장 길이 출력
 * 
 * ****시작 인덱스 조정*****
 * k개를 초과하지 않는 수열 중 가장 긴 수열을 구하는 것이기 때문에
 * k개를 초과한 숫자 중 제일 앞에 있는 숫자 이후 부터 수열을 진행해야 모든 수열을 구할 수 있다.
 * 공식
 * 시작인덱스 ~ k개를 초과한 숫자가 존재하는 인덱스(index)까지 순회(변수 i 사용)
 *     1. i번째 숫자의 개수를 하나 줄인다.(부분 수열에서 제거하는 의미)
 *     2. 만약 i번째 위치한 숫자가 k개를 초과한 숫자와 동일하다면
 *        시작 인덱스 = i + 1 (k개를 초과한 숫자 다음의 숫자를 의미)
 * 
 * 
 */
public class Main {
	
	static int n, k;
	static int [] nums;
	static int [] counts = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		String [] numsStr = br.readLine().split(" ");
		br.close();
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		nums = new int[n];
		for (int i = 0; i < n; ++i) {
			nums[i] = Integer.parseInt(numsStr[i]);
		}
		int longestLength = 0;
		int startIndex = 0;
		for (int i = 0; i < n; ++i) {
			int num = nums[i]; // i번째 숫자
			++counts[num]; // i번째 숫자의 개수를 하나 센다.
			
			if (counts[num] > k) { // i번째 숫자가 k개를 초과하면 
				int length = i - startIndex; // 길이는 현재 index - 시작인덱스
				if (length > longestLength) { // 현재 길이가 이전 최장 길이보다 길다면
					longestLength = length; // 최장 길이 갱신
				}
				startIndex = findNextStartIndex(startIndex, i); // 시작 인덱스 갱신
			}
		}
		
		int length = n - startIndex; // 반복 종료 후, 미처 길이를 세지 못한 뒷부분 처리
		if (length > longestLength) {
			longestLength = length;
		}
		System.out.println(longestLength);
	}
	
	// index : 최초로 k개를 초과하는 숫자의 index
	static int findNextStartIndex(int startIndex, int index) {
		int num = nums[index]; // 최초로 k개를 초과하는 숫자
		// k개를 초과하였기 때문에, index까지 순회한다면
		// 반드시 같은 수를 만날 수 있다.
		for (int i = startIndex; i <= index; ++i) {
			int curNum = nums[i]; // i번째 숫자
			--counts[curNum]; // i번째 숫자를 부분 수열에서 제거
			if (curNum == num) {
				startIndex = i;
				break;
			}
		}
		return startIndex + 1;
	}
}