/**
 * 1. k개의 직사각형의 범위를 이용해서 색칠
 * 2. bfs or dfs 사용해서 색칠되지 않은(분리된 공간)의 범위 확인
 * 
 * 복잡도
 * n, m, k => 100이하
 * 1. k개의 직사각형 색칠 => 1개의 직사각형 최대범위 100 x 100 => 10,000
 * => k개 의 직사각형 => 100 x 10,000 => 1,000,000
 * 2. bfs of dfs => 모눈종이의 범위 100 x 100 => 10,000(실제 복잡도는 탐색하며 조금 더 증가할 수 있음)
 * 
 * ===> 1 + 2 => 1,000,000 + 10,000 => 1,010,000 => 1초 내 계산 가능
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n, m, k;
    static boolean [][] colored;
    static int [][] infos;
    static List<Integer> answers = new ArrayList<>();
    static int [] dx = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
    static int [] dy = { 0, 0, -1, 1 }; // 상, 하, 좌, 우
    
    public static void main(String[] args) throws IOException {
        getInput();
        color();
        getAnswer();
        StringBuilder sb = new StringBuilder();
        sb.append(answers.size() + "\n");
        for (int answer : answers) {
            sb.append(answer + " ");
        }
        System.out.println(sb.toString());
    }

    static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        colored = new boolean[m][n];
        infos = new int[k][4];
        for (int i = 0; i < k; ++i) {
            input = br.readLine().split(" ");
            for (int j = 0; j < 4; ++j) {
                infos[i][j] = Integer.parseInt(input[j]);
            }
        }
        br.close();
    }

    static void color() {
        for (int[] info : infos) {
            int x1 = info[1];
            int y1 = info[0];
            int x2 = info[3];
            int y2 = info[2];
            for (int i = x1; i < x2; ++i) {
                for (int j = y1; j < y2; ++j) {
                    colored[i][j] = true;
                }
            }
        }
    }

    static void getAnswer() {
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!colored[i][j]) {
                    findArea(i, j);
                }
            }
        }
        Collections.sort(answers);
    }

    static void findArea(int x, int y) {
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();
        xQueue.offer(x);
        yQueue.offer(y);
        colored[x][y] = true;
        int area = 0;
        while (!xQueue.isEmpty()) {
            int curX = xQueue.poll();
            int curY = yQueue.poll();
            ++area;
            for (int i = 0; i < 4; ++i) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (inRange(nextX, nextY) && !colored[nextX][nextY]) {
                    xQueue.offer(nextX);
                    yQueue.offer(nextY);
                    colored[nextX][nextY] = true;
                }
            }
        }
        answers.add(area);
    }

    static boolean inRange(int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n) {
            return true;
        }
        return false;
    }
}