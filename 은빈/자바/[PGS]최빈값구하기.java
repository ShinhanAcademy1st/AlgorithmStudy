import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int maxCnt = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : array) {
            int cnt = map.getOrDefault(num, 0) + 1;
            
            if(cnt > maxCnt) {
                maxCnt = cnt;
                answer = num;
            }
            else if(cnt == maxCnt) {
                answer = -1;
            }
            
            map.put(num, cnt);
        }
        
        return answer;
    }
}