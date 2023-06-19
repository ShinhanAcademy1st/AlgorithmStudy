import java.util.*;
class Solution
{ 
    public int solution(String s)
    {
        Stack<Character> st = new Stack<>();
        int answer = -1;
 
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
             if(st.size()>0 && c==st.peek()){
                st.pop(); 
            }else{
                st.push(c);
            }
            
        }
        if(st.size() > 0)
            answer = 0;
        else
            answer = 1; 
        
        return answer;
    }
}