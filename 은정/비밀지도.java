import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++){
            StringBuilder sp = new StringBuilder("");
            String s = Integer.toBinaryString(arr1[i]);
            String s2 = Integer.toBinaryString(arr2[i]);
            
            while(s.length() < n){
                s = "0"+s;
            }
            while(s2.length() < n){
                s2 = "0"+s2;
            }
                        
            for(int j=0; j<n; j++){
                if(s.charAt(j) == '1' || s2.charAt(j) == '1')
                    sp.append("#");
                 else
                    sp.append(" ");
            }
            answer[i] = sp.toString();
        }        
        return answer;
    }
}