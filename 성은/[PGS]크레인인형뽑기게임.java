import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st= new Stack();
        for(int i=0;i<moves.length;i++){
            int j=0;
            while(j<board.length){
                if(board[j][moves[i]-1]!=0){
                    if(st.size()==0){
                        st.push(board[j][moves[i]-1]);
                    }else if(st.peek()!=board[j][moves[i]-1]){
                        st.push(board[j][moves[i]-1]);
                    }else{
                        st.pop();
                        answer+=2;
                    }
                    board[j][moves[i]-1]=0;
                    break;
                }
                j++;
            }
        }
        return answer;
    }
}