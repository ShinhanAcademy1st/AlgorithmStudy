import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        Map<Integer, Integer> line = new HashMap<>();

        for(int i = 0; i < 2; i++) {
            for(int j = i + 1; j < 3; j++) {
                int s = Math.max(lines[i][0], lines[j][0]);
                int e = Math.min(lines[i][1], lines[j][1]);
                
                for(int dot = s; dot < e; dot++) {
                    line.put(dot, dot + 1);
                }
            }
        }
        
        int answer = line.size();
        return answer;
    }
}