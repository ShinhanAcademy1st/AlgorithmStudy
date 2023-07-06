/**
 * 멀리 뛰기
 * 효진이는 1칸 혹은 2칸 뛸 수 있다.
 * 전형적인 dp문제
 * n = 1 ~ 3 : n
 * n > 3 : dp[n - 1] + dp[n - 2]
 * 경우의 수에서 1234567로 나눈 나머지의 수를 리턴해야 되기 때문에
 * 점프 할 때마다 1234567로 나눈 나머지를 저장한다.
 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    public long solution(int n) {
        long answer = 0;
        long [] jumps = new long[n + 1];
        if (n <= 3) {
            return n;
        }
        jumps[1] = 1;
        jumps[2] = 2;
        for (int i = 3; i <= n; ++i) {
            jumps[i] = jumps[i - 1] + jumps[i - 2];
            jumps[i] %= 1234567;
        }
        answer = jumps[n];
        return answer;
    }
}