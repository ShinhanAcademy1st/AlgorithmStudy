class Solution {
    public int solution(int n) {
        int answer = 1; 
        int s = n%2 == 0 ? n/2-1 : n/2+1;
        
        for(int i=s; i>0; i--){
            int j = i-1;
            int k = i;
            
            while(j>0){
                k+=j;
                if(k == n){
                    answer++;
                    break;
                }
                if(k > n)
                    break;
                j--;
            }
        }
        
        return answer;
    }
}