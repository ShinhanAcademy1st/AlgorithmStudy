import java.util.*;

class Solution {
    public boolean solution(String s) {
        String pattern = "[0-9]{4,6}";
        boolean answer = false;
        
        if(s.length() == 4 || s.length() == 6) {
            answer = s.matches(pattern);
        }
        
        return answer;
    }
}