package level0;

public class 팩토리얼 {
	
	class Solution {
	    public int solution(int n) {
	        int answer = 0;
	        int num = 1;
	        
	        // 뭔가 loop을 돌리면서 조건을 비교하면 될거 같은데..
	        for(int i = 1; i <= 11; i++) { // n 최대값이 3,628,800이라 10까지 제한했음 
	        	num *= i;                  // (정정) 그러니까 최대값에서 코드가 안 먹혀서 11까지 늘렸음
	        	if(num > n) {
	        		answer = i - 1;
	        		break;
	        	}
	        }
	        
	        return answer;
	    }
	}

}
