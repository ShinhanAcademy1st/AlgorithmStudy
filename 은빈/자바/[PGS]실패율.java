import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] people = new int[N];
        int[] tmpFail = new int[N];
        ArrayList<Double> fail = new ArrayList<>();
        
        for(int i = 0; i < stages.length; i++) {
            int stage = stages[i];
            if(stage != N + 1)
                tmpFail[stage - 1]++;
            
            if(stage == N + 1) stage--;
            
            for(int j = 0; j < stage; j++) {
                people[j]++;
            }
        }
        
        for(int i = 0; i < N; i++) {
            if(people[i] != 0 && tmpFail[i] != 0) {
                fail.add(tmpFail[i] * 1.0 / people[i]);
            } else {
                fail.add(0.0);
            }
        }
        
        for(int i = 0; i < N; i++) {
            double maxVal = Collections.max(fail);
            int idx = fail.indexOf(maxVal);
            
            answer[i] = idx + 1;
            fail.set(idx, -1.0);
        }
        
        return answer;
    }
}