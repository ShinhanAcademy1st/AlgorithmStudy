import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        char c = s.charAt(0);
        int ne=0, eq=0, i=0;
        while(s.length()>0){
            if(c==s.charAt(i)){
                eq++;
            }else{
                ne++;
            }
            if(eq==ne){
                answer++;
                s=s.substring(i+1);
                if(s.length()>1) {
                    eq=0;
                    ne=0;
                    i=0;
                    c=s.charAt(0);
                }else if(s.length()==1) {
                    answer++;
                    break;
                }
            }else{
                if(s.length()==++i) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}