import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 문제
 * 효주는 포도주 시식회에 갔다. 그 곳에 갔더니, 테이블 위에 다양한 포도주가 들어있는 포도주 잔이 일렬로 놓여 있었다.
 * 효주는 포도주 시식을 하려고 하는데, 여기에는 다음과 같은 두 가지 규칙이 있다.
 * 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
 * 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
 * 효주는 될 수 있는 대로 많은 양의 포도주를 맛보기 위해서 어떤 포도주 잔을 선택해야 할지 고민하고 있다.
 *
 * 1부터 n까지의 번호가 붙어 있는 n개의 포도주 잔이 순서대로 테이블 위에 놓여 있고,
 * 각 포도주 잔에 들어있는 포도주의 양이 주어졌을 때, 효주를 도와 가장 많은 양의 포도주를 마실 수 있도록 하는 프로그램을 작성하시오.
 *
 * 예를 들어 6개의 포도주 잔이 있고, 각각의 잔에 순서대로 6, 10, 13, 9, 8, 1 만큼의 포도주가 들어 있을 때,
 * 첫 번째, 두 번째, 네 번째, 다섯 번째 포도주 잔을 선택하면 총 포도주 양이 33으로 최대로 마실 수 있다.
 *
 * 입력
 * 첫째 줄에 포도주 잔의 개수 n이 주어진다.
 * (1 ≤ n ≤ 10,000) 둘째 줄부터 n+1번째 줄까지 포도주 잔에 들어있는 포도주의 양이 순서대로 주어진다.
 * 포도주의 양은 1,000 이하의 음이 아닌 정수이다.
 *
 * 출력
 * 첫째 줄에 최대로 마실 수 있는 포도주의 양을 출력한다.
 *
 * 사용 변수
 * int n -> 놓여져 있는 포도주 잔의 수
 * int wines[n + 1] -> 놓여져 있는 n개의 포도주 잔에 채워져 있는 양
 * int dp[n + 1] -> 1번째 와인부터, 특정 번째 와인잔까지 마실 수 있는 최대 와인 양 저장
 * n은 최대 10,000(1만) 이고, 각 와인잔에 들어있는 와인의 양은 1000 이하의 음수 이므로
 * 최대 수는 10,000,000 (10,000 * 1,000) -> dp[] : int 사용
 * 
 * 풀이
 * 대표적인 DP문제
 * dp[1](첫번째 와인 까지 최대 섭취 가능양) -> wines[1]
 * dp[2](두번째 와인 까지 최대 섭취 가능양) -> wines[1] + wines[2]
 * 최대 2개의 와인을 연속으로 섭취할 수 있기 때문에
 * 3번째 와인부터는 3가지 경우의 수 중 최대를 선택
 * 1) i번쪠 와인을 선택하지 않고 i - 1번째 와인까지만 선택하는경우
 *  -> dp[i - 1]
 * 2) i - 1번째 와인을 선택하지 않고 i - 2번째 와인까지의 최대양 + i번째 와인양
 *  -> dp[i - 2] + wines[i]
 * 3) i - 2번째 와인을 선택하지 않고 i - 3번째 와인까지의 최대양 + i - 1번째 와인양 + i 번째 와인양
 *  -> dp[i - 3] + wines[i - 1] + wines[i]
 *  
 *  계산 종료 후 dp[n] 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] wines = new int[n + 1];
        int [] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            wines[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        dp[1] = wines[1];
        if (n >= 2) {
            dp[2] = wines[1] + wines[2];
        }
        for (int i = 3; i <= n; ++i) {
            dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 3] + wines[i - 1] + wines[i]), dp[i - 2] + wines[i]);
        }
        System.out.println(dp[n]);
    }
}
