import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 문제
 * N×N 게임판에 수가 적혀져 있다. 이 게임의 목표는 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 점프를 해서 가는 것이다.
 *
 * 각 칸에 적혀있는 수는 현재 칸에서 갈 수 있는 거리를 의미한다. 반드시 오른쪽이나 아래쪽으로만 이동해야 한다.
 * 0은 더 이상 진행을 막는 종착점이며, 항상 현재 칸에 적혀있는 수만큼 오른쪽이나 아래로 가야 한다. 한 번 점프를 할 때, 방향을 바꾸면 안 된다.
 * 즉, 한 칸에서 오른쪽으로 점프를 하거나, 아래로 점프를 하는 두 경우만 존재한다.
 *
 * 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 이동할 수 있는 경로의 개수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 게임 판의 크기 N (4 ≤ N ≤ 100)이 주어진다. 그 다음 N개 줄에는 각 칸에 적혀져 있는 수가 N개씩 주어진다.
 * 칸에 적혀있는 수는 0보다 크거나 같고, 9보다 작거나 같은 정수이며, 가장 오른쪽 아래 칸에는 항상 0이 주어진다.
 *
 * 출력
 * 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 문제의 규칙에 맞게 갈 수 있는 경로의 개수를 출력한다. 경로의 개수는 263-1보다 작거나 같다.
 *
 * 사용 변수
 * int n -> 보드판의 크기
 * int board[n][n] -> 현재 칸에서 갈 수 있는 거리를 저장한 게임판
 * long ways[n][n] -> 현재 칸까지 도달할 수 있는 경우의 수
 *
 * 풀이
 * 2차원 DP 문제
 * ways[0][0] = 1 -> 시작 위치에 경우의 수 1로 초기화
 * board[0][0]부터 모든칸을 배회하며 경우의 수 탐색
 * i -> 행을 의미
 * j -> 열을 의미
 * 현재칸에 도달할 수 있고(ways[i][j] > 0), 현재칸에서 점프하는 거리가 1 이상이면(board[i][j] >= 1)
 *   : 점프 시도
 *
 * int num -> 해당 칸(board[i][j])에서 점프하는 거리
 * 아래쪽과 오른쪽으로만 이동할 수 있기 때문에 두 방향으로만 이동 시도
 * 아래쪽으로 점프할 수 있으면 (i + num < n) 아래쪽으로 점프
 * 오른쪽으로 점프할 수 있으면 (j + num < n) 오른쪽으로 점프
 * 점프 -> 이동할 위치에 도달할 수 있는 경우에 수에 현재 위치에 도달할 수 있는 경우의 수를 더해준다.
 *   : ways[i + num][j] or ways[i][j + num] += ways[i][j]
 *
 *  계산 종료 후 ways[n - 1][n - 1] 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] board = new int[n][n]; // 각 칸에서 점프하는 거리의 수
        long [][] ways = new long[n][n]; // 현재 칸까지 도달할 수 있는 경우의 수
        for (int i = 0; i < n; ++i) {
            String[] inputStr = br.readLine().split(" ");
            for (int j = 0; j < n; ++j) {
                board[i][j] = Integer.parseInt(inputStr[j]);
            }
        }
        br.close();
        ways[0][0] = 1; // 출발지의 경우의 수를 1로 초기화
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (ways[i][j] > 0 && board[i][j] > 0) { // 현재 위치에 도달할 수 있고, 현재 위치로 부터 1 이상 점프를 한다면
                    int num = board[i][j]; // 현재칸에서 점프할 거리
                    if (i + num < n) { // 아래쪽으로 점프할 수 있다면
                        ways[i + num][j] += ways[i][j]; // 아래쪽으로 점프
                    }
                    if (j + num < n) { // 오른쪽으로 점프할 수 있다면
                        ways[i][j + num] += ways[i][j]; // 오른쪽으로 점프
                    }
                }
            }
        }
        System.out.println(ways[n - 1][n - 1]); // 목적지까지 도달할 수 있는 경우의 수 출력
    }
}