/**
 * N명의 학생중, 1~5년까지의 학교생활에서 가장 다양한 학생과 같은 반을 했던
 * 학생의 번호를 구하는 문제
 * 
 * ***** 입력 *****
 * N : 학생의 수
 * students[N][5] : 각 학생의 학년별 반의 정보
 * 
 * ***** 출력 *****
 * 가장 많은 학생과 같은 반을 했던 학생의 번호
 * 
 * 
 * 1. 3중 for문을 돌며 같은 반을 했던 학생 파악
 * 2. 2차원 boolean 배열을 사용하여 같은 반을 했던 학생 표시
 * 3. 가장 많은 학생과 겹쳤던 학생의 번호 출력
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {
    
    static int N;
    static int [][] students;
    static boolean [][] commons;
    
    public static void main(String[] args) throws IOException {
        init();
        int maxStudent = 1;
        int maxNum = 0;
        for (int i = 0; i < N - 1; ++i) {
            for (int j = 0; j < 5; ++j) {
                findClassMates(i, j);
            }
        }
        for (int i = 0; i < N; ++i) {
            int common = 0;
            for (boolean col : commons[i]) {
                if (col) {
                    ++common;
                }
            }
            if (common > maxNum) {
                maxNum = common;
                maxStudent = i + 1;
            }
        }
        System.out.println(maxStudent);
    }
    
    static void findClassMates(int i, int j) {
        for (int k = i + 1; k < N; ++k) {
            if (students[i][j] == students[k][j]) {
                commons[i][k] = true;
                commons[k][i] = true;
            }
        }
    }
    
    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        students = new int[N][5];
        commons = new boolean[N][N];
        for (int i = 0; i < N; ++i) {
            String [] input = br.readLine().split(" ");
            for (int j = 0; j < 5; ++j) {
                students[i][j] = Integer.parseInt(input[j]);
            }
        }
        br.close();
    }
}