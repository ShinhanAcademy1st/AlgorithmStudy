package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 : 재원이는 한 도시의 시장이 되었다. 이 도시에는 도시를 동쪽과 서쪽으로 나누는 큰 일직선 모양의 강이 흐르고 있다.
 * 		하지만 재원이는 다리가 없어서 시민들이 강을 건너는데 큰 불편을 겪고 있음을 알고 다리를 짓기로 결심하였다.
 * 		강 주변에서 다리를 짓기에 적합한 곳을 사이트라고 한다. 
 * 		재원이는 강 주변을 면밀히 조사해 본 결과 강의 서쪽에는 N개의 사이트가 있고 동쪽에는 M개의 사이트가 있다는 것을 알았다. (N ≤ M)
 * 		재원이는 서쪽의 사이트와 동쪽의 사이트를 다리로 연결하려고 한다. (이때 한 사이트에는 최대 한 개의 다리만 연결될 수 있다.) 
 * 		재원이는 다리를 최대한 많이 지으려고 하기 때문에 서쪽의 사이트 개수만큼 (N개) 다리를 지으려고 한다.
 * 		다리끼리는 서로 겹쳐질 수 없다고 할 때 다리를 지을 수 있는 경우의 수를 구하는 프로그램을 작성하라.
		
 * 입력 : 입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 
 * 		그 다음 줄부터 각각의 테스트케이스에 대해 강의 서쪽과 동쪽에 있는 사이트의 개수 정수 N, M (0 < N ≤ M < 30)이 주어진다.
 *		 
 * 출력 : 각 테스트 케이스에 대해 주어진 조건하에 다리를 지을 수 있는 경우의 수를 출력한다.
 * 
 * -----사용 변수-----
 * int t : test하는 횟수
 * int n : 강 서쪽의 사이트 수 
 * int m : 강 동쪽의 사이트 수
 * long bridgeCounts[][] : [서쪽 사이트의 수][동쪽 사이트의 수]에 따라 만들 수 있는 다리의 개수를 저장하는 배열
 * 
 * 테스트가 몇번 진행할 지 모르고, n과 m의 범위가 작기 때문에 각 사이트의 최고 개수인 30개까지 모든 다리의 개수를 구하고
 * 테스트를 진행할 때마다 2차원 배열에 저장된 숫자를 가져오는 방식을 사용
 * 
 * 강 동쪽의 사이트가 1개라면, 다리를 만들 수 있는 경우의 수는 강 서쪽 사이트 개수와 동일하다.
 * 강 동쪽과 강 서쪽의 사이트 수가 동일하다면, 만들 수 있는 경우의 수는 1개밖에 없다.(다리가 겹치면 안되기 때문)
 * 
 * 말로는 설명하기 힘들어서 궁금하신 점이 있어 질문주시면, 그림을 그려서 설명해 드리도록 하겠습니다. ㅠㅠ
 * 
 * 1~30까지 [1][i] = i;
 * 1~30까지 [i][i] = 1;로 우선 초기화 한다.
 * 
 * 공식: bridgeCounts[i][j] = bridgeCounts[i][j - 1] + bridgeCounts[i - 1][j - 1]
 * 2부터 30까지 위의 공식을 사용하여 1개부터 30개까지 모든 경우의수를 구한다.
 * 이때 복잡도는 n^2이지만, 최대 범위가 30이기 때문에 900번의 연산으로 끝이 난다.
 * 
 * 1. 테스트 수인 t번만큼 반복한다.
 * 2. 매번 테스트 마다 n, m을 입력받는다.
 * 3. 입력을 받기 전 저장해놨던 배열(bridgeCounts)에서 (n, m)에 저장된 값을 출력한다.
 * 
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long [][] bridgeCounts = new long[31][31];
		for (int i = 1; i <= 30; ++i) {
			bridgeCounts[i][i] = 1;
			bridgeCounts[1][i] = i;
		}
		for (int i = 2; i < 30; ++i) {
			for (int j = i + 1; j <= 30; ++j) {
				bridgeCounts[i][j] = bridgeCounts[i][j - 1] + bridgeCounts[i - 1][j - 1];
			}
		}
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; ++i) {
			String [] nm = br.readLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			System.out.println(bridgeCounts[n][m]);
		}
		br.close();
	}
}