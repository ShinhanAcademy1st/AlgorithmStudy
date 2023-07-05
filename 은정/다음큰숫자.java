class Solution {
    public int solution(int n) {
        int answer = 0;
          int cnt = Integer.bitCount(n);
          
        for(int i=n+1; i<1000000; i++){
            if(Integer.bitCount(i) == cnt){
                answer = i;
                break;
            }
        }
        
         return answer;
    }
}