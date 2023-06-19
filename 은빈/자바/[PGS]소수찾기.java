import java.util.Arrays;

class Solution {
    public int solution(int n) {
        int[] arr = new int[n + 1];
        int answer = -2;
        
        for(int num = 2; num < Math.sqrt(n); num++) {
            if(arr[num] == 0) {
                int idx = num;
                while(idx < n) {
                    idx += num;
                    if(idx <= n) arr[idx] = 1;
                }
            }
        }
        
        answer += (int) Arrays.stream(arr).filter(e -> e == 0).count();
        
        return answer;
    }
}