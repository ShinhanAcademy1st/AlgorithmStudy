class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int idx = 0;
        
        int mid = total / num;
        int n = num / 2;
        int cond = num % 2 == 0 ? 1 : 0;
        
        for(int i = mid - n + cond ; i <= mid + n; i++) {            
            answer[idx++] = i;
        }
        
        return answer;
    }
}