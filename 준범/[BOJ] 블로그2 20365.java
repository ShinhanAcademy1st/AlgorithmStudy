package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 문제 : neighbor 블로그를 운영하는 일우는 매일 아침 풀고 싶은 문제를 미리 정해놓고 글을 올린다. 그리고 매일 밤 각각의 문제에 대하여, 해결한 경우 파란색, 해결하지 못한 경우 빨간색으로 칠한다. 일우는 각 문제를 칠할 때 아래와 같은 과정을 한 번의 작업으로 수행한다.
 *		1. 연속된 임의의 문제들을 선택한다.
 *		2. 선택된 문제들을 전부 원하는 같은 색으로 칠한다.
 *		예를 들어, 각 문제를 위와 같은 색으로 칠하려고 할 때, 1~2번 문제를 파란색, 3번을 빨간색, 4번을 파란색, 5번을 빨간색, 6~7번을 파란색, 8번을 빨간색으로 칠하는 작업을 순서대로 수행하면 6번의 작업을 거쳐야 한다. 하지만, 1~7번 문제를 파란색, 3번을 빨간색, 5번을 빨간색, 8번을 빨간색으로 순서대로 칠한다면 작업 횟수는 4번으로 가장 적다.
 *		일우는 매일 500,000문제까지 시도하기 때문에, 이 작업이 꽤나 귀찮아지기 시작했다. 그래서 가장 효율적인 방법으로 위 작업을 수행하기를 원한다. 일우를 도와 각 문제를 주어진 색으로 칠할 때 필요한 최소한의 작업 횟수를 구하는 프로그램을 작성하라.
 * 입력 : 첫째 줄에 색을 칠해야 하는 문제의 수 N (1 ≤ N ≤ 500,000)이 주어진다.
 *		둘째 줄에 N개의 문자가 공백 없이 순서대로 주어진다.
 *		각 문자는 i번째 문제를 어떤 색으로 칠해야 하는지를 의미하며, R은 빨간색, B는 파란색을 나타낸다.
 *		그 외에 다른 문자는 주어지지 않는다.
 * 출력 : 첫째 줄에 일우가 주어진 모든 문제를 원하는 색으로 칠할 때까지 필요한 작업 횟수의 최솟값을 출력하라.
 * 
 * 총 3가지 방식 사용
 * 1 - 첫번째 문제부터, 문제에서 주어진 조건에 따라 하나씩 칠하기
 * 2 - 모든 문제를 파란색으로 칠한 뒤, 필요한 부분 빨간색으로 칠하기
 * 3 - 모든 문제를 빨간색으로 칠한 뒤, 필요한 부분 파란색으로 칠하기
 * 
 * 
 * -----사용 변수-----
 * int n : 문재의 개수
 * String problems : 칠해야되는 문제들의 색
 * int solved : 푼 문제 수('B')
 * int unsolved : 풀지 못한 문제 수('R')
 * char lastStatus : 이전문제에 칠했던 색
 * 
 * 3가지 방식을 한번에 풀기 위해 문제를 단 한번만 반복
 * 처음부터 끝까지 순회 하며, 색깔 별 몇 번씩 칠해야 되는지 카운트
 * 1번째 방식 : 푼 문제수 + 풀지 못한 문제수를 사용
 * 2번째 방식 : 풀지 못한 문제수 + 1
 * 3번째 방식 : 푼 문제수 + 1
 * 
 * 1. 0 ~ n - 1번째 인덱스까지 순회하며 연속된 문자를 건너 뛰며 각각 칠해야 하는 색 수 카운트
 * 2. 필요 횟수 = 푼 문제수 + 못 푼 문제수
 * 3. 필요 횟수 > 푼 문제수 + 1, 필요 횟수 = 푼 문제수 + 1
 * 4. 필요 횟수 > 못 푼 문제수 + 1, 필요 횟수 = 못 푼 문제수 + 1
 * 위의 3번의 연산을 통해 최소 횟수 도출
 * 5. 필요 횟수 출력
 * 
 */
public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String problems = br.readLine();
		int solved = 0, unsolved = 0;
		char lastStatus = 'X'; // 첫번째 인덱스를 위해 B나 R이 아닌 아무 문자 선택
		for (int i = 0; i < n; ++i) {
			char curStatus = problems.charAt(i);
			if (lastStatus != curStatus) {
				if (curStatus == 'B') {
					++solved;
				}
				else {
					++unsolved;
				}
				lastStatus = curStatus;
			}
		}
		int totalCount = solved + unsolved;
		if (totalCount > solved + 1) {
			totalCount = solved + 1;
		}
		if (totalCount > unsolved + 1) {
			totalCount = unsolved + 1;
		}
		System.out.println(totalCount);
	}
}