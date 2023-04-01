class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int paint = 0;

        for(int num : section) {
        	if(paint < num) {
            	paint = num+m-1;
            	answer++;
        	}
        }
        
        return answer;
    }
}