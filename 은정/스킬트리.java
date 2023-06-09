import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;         
        for(String s:skill_trees){            
            int n = 0;
            boolean result = true;
            
            for(int i=0; i<s.length(); i++){ 
                int idx = skill.indexOf(s.charAt(i)); 
                if(n == idx)
                    n++; 
                else if(idx != -1){
                     result = false;
                    break; 
                }
            }
            
            if(result)
                answer++;

        }
        
        return answer;
    }
}