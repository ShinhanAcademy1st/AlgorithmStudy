import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[] cnt = new int[3];
        int idx = 0;
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == student1[i % (student1.length)]) cnt[0]++;
            if(answers[i] == student2[i % (student2.length)]) cnt[1]++;
            if(answers[i] == student3[i % (student3.length)]) cnt[2]++;
        }
        
        int maxCnt = 0;
        for(int i = 0; i < 3; i++) {
            if(maxCnt < cnt[i]) {
                maxCnt = cnt[i];
                answer.clear();
                answer.add(i + 1);
            } else if(maxCnt == cnt[i]) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}