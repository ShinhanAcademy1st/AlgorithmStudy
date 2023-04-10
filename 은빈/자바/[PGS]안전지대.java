import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int[][] safeArea = new int[n][n];
        int answer = 0;
        
        if (n == 1) {
            if (board[0][0] == 0) {
                answer = 1;
            }
            
            return answer;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) {
                    safeArea[i][j] = 1;
                    if(i == 0) {
                        if(j == 0 || j != (n-1)) {
                            safeArea[i][j+1] = 1;
                            safeArea[i+1][j] = 1;
                            safeArea[i+1][j+1] = 1;
                        }
                        if(j != 0 || j == (n-1)) {
                            safeArea[i][j-1] = 1;
                            safeArea[i+1][j] = 1;
                            safeArea[i+1][j-1] = 1;
                        }
                    }
                    else if(i == (n - 1)) {
                        if(j == 0 || j != (n-1)) {
                            safeArea[i][j+1] = 1;
                            safeArea[i-1][j] = 1;
                            safeArea[i-1][j+1] = 1;
                        }
                        if(j != 0 || j == (n-1)) {
                            safeArea[i][j-1] = 1;
                            safeArea[i-1][j] = 1;
                            safeArea[i-1][j-1] = 1;
                        }
                    }
                    else {
                        if(j == 0 || j != (n-1)) {
                            safeArea[i-1][j] = 1;
                            safeArea[i-1][j+1] = 1;
                            safeArea[i][j+1] = 1;
                            safeArea[i+1][j] = 1;
                            safeArea[i+1][j+1] = 1;
                        }
                        if(j != 0 || j == (n-1)) {
                            safeArea[i-1][j] = 1;
                            safeArea[i-1][j-1] = 1;
                            safeArea[i][j-1] = 1;
                            safeArea[i+1][j] = 1;
                            safeArea[i+1][j-1] = 1;
                        }
                    }
                }
            }
        }
        
        
        
        for(int[] arr : safeArea) {
            answer += (int) Arrays.stream(arr).filter(x -> x == 0).count();
        }
        
        return answer;
    }
}