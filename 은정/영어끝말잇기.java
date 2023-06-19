import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
         Set<String> set = new HashSet<>();
        int cnt = 0;
        int index = 0;
        set.add(words[0]);
        
        for(int i=1; i<words.length; i++){
            if(set.contains(words[i]) ||
              words[i].charAt(0) != words[i-1].charAt(words[i-1].length() - 1)){
                cnt = i%n+1;
                index = i/n+1;
                break;
            } 
            set.add(words[i]); 

        } 
        return new int[] {cnt, index};
    }
}