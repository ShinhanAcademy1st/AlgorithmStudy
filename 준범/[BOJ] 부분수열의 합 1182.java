package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 문제 : N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
 * 입력 : 정수의 개수 N, 목표 합의 값, 중복되지 않는 N개의 정수 
 * 1 ≤ N ≤ 20, |S| ≤ 1,000,000, 주어지는 정수의 절댓값은 100,000을 넘지 않는다.
 * 출력 : 첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
 * 
 * 부분 수열은 원래의 수열의 일부를 원래 순서대로 나열하여 얻을 수 있는 수열
 * 순서를 변경할 필요가 없기 때문에 정렬 사용 불필요
 * 맨앞의 숫자부터 맨뒤의 숫자까지 하나씩 접근
 * 각 숫자는 그 숫자 이전의 숫자들로 구성된 부분수열에 포함 할 수도 있고, 포함하지 않을 수도 있다.
 * 
 * -----사용 변수-----
 * int n : 정수의 개수
 * int s : 목표 합의 값
 * int totalCount : 합이 S가 되는 부분 수열의 수
 * int[] arr : 크기 20의 변수
 * 
 * 수열의 맨 앞 번호를 의미하는 index는 0으로 시작한다.
 * 1. 현재 index가 N인지 확인한다.
 * 1-1. index < N인 경우, 아직 맨뒤의 숫자까지 접근하지 않았음을 의미한다.
 * 1-2. 해당 index에 위치하는 숫자를 포함하고, 다음 index에 접근한다.(1.로 이동)
 * 1-3. 해당 index에 위치하는 숫자를 포함하지 않고, 다음 index에 접근한다.(1.로 이동) 
 * 2. 현재 index == N(모든 숫자를 다 확인한 이후)
 * 2-1. 포함된 부분수열의 총 합이 S와 같은지 비교한다. 같지 않다면, 아무것도 수행하지 않고 돌아간다.
 * 2-2. 포함된 부분수열의 총 합이 S와 같다면, 숫자를 하나라도 포함했는지 확인한다. 숫자를 하나도 포함하지 않았다면, 아무것도 수행하지 않고 돌아간다.
 * 2-3. 총 합이 S와 같고, 숫자를 하나 이상 포함 했다면, totalCount를 하나 증가시킨다.
 * 3. 재귀 함수 종료 후 totalCount를 출력한다.
 */
public class Main {
	
	static int[] arr = new int[20]; // N개의 정수를 담을 배열 max 20개
	static int n, s; // 정수의 개수 N, 목표 합의 값 S
	static int totalCount = 0; // 합이 S가 되는 부분 수열의 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		s = Integer.parseInt(tmp[1]);
		tmp = br.readLine().split(" ");
		br.close();
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		// 0번째 index, 부분수열 총 합 0, 포함된 숫자의 개수 0개로 함수 시작
		getResult(0, 0, 0);
		System.out.println(totalCount);
	}

	/**
	 * @param index : 현재 접근한 숫자가 몇번째 숫자인지
	 * @param prefixSum : 현재 index 이전 숫자들로 구성된 부분 수열의 합
	 * @param includedCount : 부분 수열에 포함된 숫자의 개수
	 * includedCount를 사용하는 이유
	 * 목표 합 S가 0일때 아무 숫자가 포함되지 않은 부분수열의 합이 S와 같기 때문에 이를 배제하기 위해 사용 
	 */
	static void getResult(int index, int prefixSum, int includedCount) {
		if (index == n) { // 모든 숫자를 거쳐서 맨뒤로 왔다면
			if (prefixSum == s && includedCount > 0) {
				// 부분 수열의 총합이 목표 값인 S와 같고, 숫자를 하나 이상 포함했다면 카운트 증가
				++totalCount;
			}
			return; // 목표 값인 S와 같은지와는 상관없이 모든 숫자를 다 확인했다면 더이상 진행 하지 않는다.
		}
		// 1-2. 현재 index에 해당하는 숫자를 포함
		// 부분수열의 총합에 현재 숫자를 더하고, 포함된 숫자의 개수를 1증가 후 다음 숫자로 이동
		getResult(index + 1, prefixSum + arr[index], includedCount + 1);
		
		// 1-3. 현재 index에 해당하는 숫자를 미포함
		// 부분수열의 총합과, 포함된 숫자 개수에 변화없이 그대로 다음 숫자로 이동
		getResult(index + 1, prefixSum, includedCount);
	}
}
