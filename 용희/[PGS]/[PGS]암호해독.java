package level0;

public class 암호해독 {
	
	class Solution {
	    public String solution(String cipher, int code) {
	        String answer = "";
	        char ch;
	        
	        // code-1 번째, (code*2)-1 번째 ...
	        // code가 4라면 3, 7, 11, 15..
	        for(int i = code-1; i < cipher.length(); i += code) {
	        	ch = cipher.charAt(i);
	        	answer += ch;
	        }
	        
	        return answer;
	    }
	}

}
