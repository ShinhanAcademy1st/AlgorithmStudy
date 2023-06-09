import java.lang.*;
class Solution {
    public String solution(int[] numbers, String hand) {
         StringBuilder answer = new StringBuilder("");
        int left[] = {0,3};
        int right[] = {2,3};
        
        for(int num:numbers){
            if(num==0)
                num=11;
            int x = num % 3;
            int y = num / 3;
            
            if(x==0){
                right[0] = 2;
                right[1] = y-1;
                answer.append("R");
             }else if(x==1){
                left[0] = 0;
                left[1] = y;
                answer.append("L");
             }else{
                int r = right[0]-1 + Math.abs(right[1]-y);
                int l = 1-left[0] + Math.abs(left[1]-y);
                if(r>l){
                    left[0] = 1;
                    left[1] = y;
                    answer.append("L");
                 }else if(r<l){
                    right[0] = 1;
                    right[1] = y;
                    answer.append("R");
                 }else{
                    if(hand.equals("left")){
                        left[0] = 1;
                        left[1] = y;  
                       answer.append("L");
                     }else{
                        right[0] = 1;
                        right[1] = y;
                        answer.append("R");
                     }
                }
                
            }
        }
        
        return answer.toString();
    }
}