import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            if(i!=0)
                s = s.substring(1, s.length())+s.charAt(0);
 
            Stack<Character> st = new Stack<>();
            
            for(int j=0; j < s.length(); j++){
                char c = s.charAt(j); 
                
                if(st.size()==0)
                    st.push(c);
                else{
                    switch(c){
                        case ')':
                            if(st.peek() == '('){
                                st.pop();
                             }
                            break;
                        case '}':
                            if(st.peek() == '{'){
                                st.pop();
                             }
                            break;
                        case ']':
                            if(st.peek() == '['){
                                st.pop();
                             }
                            break;
                        default:
                            st.push(c);
                            break; 
                    } 
                } 
            }
            if(st.size() == 0)
                answer++;
        }
        
        return answer;
    }
}