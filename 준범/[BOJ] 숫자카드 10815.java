package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

/**
 * 문제 : 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 
 * 상근이는 숫자 카드 N개를 가지고 있다. 
 * 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
 * 입력 : 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 
 * 		 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
 * 		 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
 * 		 두 숫자 카드에 같은 수가 적혀있는 경우는 없다.
 * 		 셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다.
 * 		 넷째 줄에는 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다.
 * 	 	 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다
 *		 
 * 출력 : 첫째 줄에 입력으로 주어진 M개의 수에 대해서, 
 * 		 각 수가 적힌 숫자 카드를 상근이가 가지고 있으면 1을, 아니면 0을 공백으로 구분해 출력한다.
 * 
 * -----사용 변수-----
 * int n : 상근이가 가지고 있는 카드의 개수
 * int m : 검색을 원하는 카드의 개수
 * int Sanggeun[] : 상근이가 가지고 있는 카드 배열
 * int cards[] : 검색을 원하는 카드 배열
 * 
 * ****검색시 사용변수****
 * int start : 시작 인덱스
 * int end : 끝 인덱스
 * int mid : 현재 범위 내 중간 인덱스 ((start + end) / 2)
 * int current : 중간 인덱스에 위치한 카드 번호
 * 
 * M개의 카드를 상근이가 가지고 있는지 없는지를 빠르게 체크하는 것이 관건이다.
 * 복잡도 : M * (카드를 가지고 있는지 확인하는데 걸리는 시간)
 * 빠른 탐색을 위해 binary search(이진 탐색) 사용
 * 
 * 1. 상근이가 가지고 있는 카드 N개를 오름차순으로 정렬한다.(정렬 알고리즘 사용)
 * 2. M개의 카드를 하나씩 검사하고 결과에 따라 가지고 있으면 1을, 없으면 0을 공백으로 구분해 출력한다.
 * 
 * ****카드 검색 방법****
 * 상근이의 카드는 오름차순으로 정렬이 되어 있기 때문에, 범위를 점점 좁혀 나가며 숫자를 탐색
 * 시작인덱스 : 0, 끝 인덱스 : n - 1(상근이가 가지고 있는 카드의 수)로 초기화
 * 탐색이 종료 될때까지 반복한다.
 * 1. 중간 인덱스 : (시작 인덱스 + 끝 인덱스) / 2 로 초기화 -> 범위 중간에 있는 값을 검색
 * 2. 시작 인덱스 > 끝 인덱스 -> 카드가 없다는 것을 의미, 탐색 종료
 * 3. 검색을 하는 카드와 범위 가운데 위치한 카드가 같다 -> 카드 발견, 탐색 종료
 * 4. 검색을 하는 카드가 범위 가운데 위치한 카드보다 크다 -> 끝 인덱스를 중간인덱스 - 1로 조정하여 범위 축소
 * 5. 검색을 하는 카드가 범위 가운데 위치한 카드보다 작다 -> 시작 인덱스를 중간인덱스 + 1로 조정하여 범위 축소
 * 
 * 계속해서 찾다보면 시작인덱스와 끝 인덱스가 같아짐
 * 그때에도 찾지 못한다면 시작인덱스가 끝 인덱스보다 커지며, 이는 카드가 없다는 것을 의미
 * 
 */
public class Main {
	
	static int n, m;
	static int [] Sanggeun;
	static int [] cards;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		Sanggeun = new int[n];
		String [] strNums = br.readLine().split(" ");
		for (int i = 0; i < n; ++i) {
			Sanggeun[i] = Integer.parseInt(strNums[i]);
		}
		m = Integer.parseInt(br.readLine());
		cards = new int[m];
		strNums = br.readLine().split(" ");
		br.close();
		for (int i = 0; i < m; ++i) {
			cards[i] = Integer.parseInt(strNums[i]);
		}
		Arrays.sort(Sanggeun);
		for (int i = 0; i < m; ++i) {
			System.out.print(hasCard(cards[i]) + " ");
		}
	}
	
	// num : 검색을 원하는 카드의 숫자
	static int hasCard(int num) {
		int start = 0; // 시작 인덱스
		int end = n - 1; // 끝 인덱스
		while (true) {
			int mid = (start + end) / 2; // 해당 범위 내의 가운데 인덱스
			if (start > end) { // 상근이가 가지고 있지 않다는 의미, 검색 종료
				break;
			}
			int current = Sanggeun[mid]; // 현재 범위내의 가운데 카드의 숫자
			if (current == num) { // 탐색 성공, 상근이가 가지고 있다는 의미
				return 1;
			} else if (current > num) { // 가운데 숫자가 검색을 원하는 숫자보다 큰 경우
				end = mid - 1; // 끝 인덱스를 가운데 인덱스 - 1로 조정하여 검색 범위 축소
				// mid 보다 더 작은 숫자들의 범위를 가지고 재탐색
			} else { // 가운데 숫자가 검색을 원하는 숫자보다 작은 경우
				start = mid + 1; // 시작 인덱스를 + 1 조정하여 검색 범위 축소
				// mid 보다 더 큰 숫자들의 범위를 가지고 재탐색
			}
		}
		return 0;
	}
}