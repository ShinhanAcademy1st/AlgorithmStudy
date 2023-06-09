import java.util.*;
class Solution {
    public int[] solution(String s) {
        int len = s.length();
        int zero = 0; 
        int cnt = 0; 
        
        while(s.length() > 1){
            cnt++;
            s = s.replaceAll("0", "");  //0 제거 후  
            zero += len - s.length(); //제거할 0의 개수    
            len = s.length();
            s = Integer.toBinaryString(len);   //0 제거후 길이 이진 변환
            len = s.length();             
         } 
        return new int[]{cnt, zero};
    }
}