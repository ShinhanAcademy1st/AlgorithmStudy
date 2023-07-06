/**
 * 100 x 100 크기의 평면에 직사각형이 놓인 자리의 넓이를 구하는 문제
 * ***** 입력 *****
 * 4개의 직사각형 꼭짓점 정보(x1, y1, x2, y2)
 * 
 * ***** 출력 *****
 * 4개의 직사각형이 놓인 자리의 넓이
 * 
 * 1. 4개의 직사각형이 놓인 자리를 색칠한다.((x2 - x1) * (y2 - y1))넓이만큼 board를 true로 변경
 * 2. 색칠된 자리를 각 칸별로 카운트 한다.(true인 칸의 개수)
 * 3. 카운트된 결과 출력
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    
    static int [][] squares = new int[4][4];
    static boolean [][] board = new boolean[100][100];
    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < 4; ++i) {
            paint(i);
        }
        int result = 0;
        for (boolean [] row : board) {
            for (boolean col : row) {
                if (col) {
                    ++result;
                }
            }
        }
        System.out.println(result);
    }
    
    static void paint(int row) {
        int x1 = squares[row][0];
        int y1 = squares[row][1];
        int x2 = squares[row][2];
        int y2 = squares[row][3];
        for (int i = x1; i < x2; ++i) {
            for (int j = y1; j < y2; ++j) {
                board[i][j] = true;
            }
        }
    }
    
    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; ++i) {
            String [] input = br.readLine().split(" ");
            for (int j = 0; j < 4; ++j) {
                squares[i][j] = Integer.parseInt(input[j]);
            }
        }
        br.close();
    }
}