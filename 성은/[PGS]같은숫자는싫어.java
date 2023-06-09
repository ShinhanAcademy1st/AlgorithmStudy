import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
       int index=1;
       for(int i=0;i<arr.length-1;i++){
           if(arr[i]!=arr[i+1]) index++;
       }
      int[] answer = new int[index];
      answer[0]=arr[0];
      index=1;
      for(int i=1;i<arr.length;i++){
         if(arr[i]!=arr[i-1]){
             answer[index]=arr[i];
             index++;
         }
      }
      return answer;
    }
}