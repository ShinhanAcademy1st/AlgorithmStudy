import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int len = board[0].length;
         Stack<Integer> st = new Stack<>();
         
        for(int mv:moves){
            mv -=1;
            for(int i=0; i<len; i++){  
                if(board[i][mv] != 0){
                    if(st.size() > 0  && st.peek() == board[i][mv] ){
                        st.pop();
                        answer += 2;
                    }else{
                         st.push(board[i][mv]);
                    }
                    board[i][mv] = 0;
                    break; 
                }
            }  
        } 
        return answer;
    }
}