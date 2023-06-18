class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];
        int answer = 0;
        
        for(int idx: lost) {
            student[idx - 1]--;
        }
        for(int idx : reserve) {
            student[idx - 1]++;
        }
        
        for(int i = 0; i < n; i++) {
            if(student[i] == -1) {
                if(i != 0) {
                    if(student[i - 1] == 1) {
                        student[i - 1]--;
                        student[i]++;
                        answer++;
                        continue;
                    }
                }
                if(i != n - 1) {
                    if(student[i + 1] == 1) {
                        student[i + 1]--;
                        student[i]++;
                        answer++;
                    }
                }
            } else {
                answer++;
            }
        }
        
        return answer;
    }
}