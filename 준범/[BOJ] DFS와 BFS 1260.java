/**
 * 1. 각 정점별 방문 리스트 저장
 * 2. 각 리스트 오름차순 정렬
 * 3. 저장된 정보를 기반으로 dfs 수행, bfs 수행
 * 각 정점에서 방문할 수 있는 정점이 여러 개 일 수 있고, 여러 개 인 경우 정점 번호가 더 작은 것을 먼저 방문하기 때문에, 
 * 각 정점이 방문할 수 있는 정점들을 먼저 정렬해 놓은뒤 사용하면 편하다.
 * 이 방문 정점 리스트는 각 dfs, bfs에서 두번 사용 되기 때문에 처음에 초기화를 한번 잘 해놓으면 편하다.
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

    static List<List<Integer>> nextNodes;
    static int n, m, v;
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        getInput();
        dfs(v);
        System.out.println(sb.toString());
        bfs();
    }

    public static void dfs(int node) {
        sb.append(node + " ");
        visited[node] = true;
        for (int nextNode : nextNodes.get(node)) {
            if (!visited[nextNode]) {
                dfs(nextNode);
            }
        }
    }

    public static void bfs() {
        visited = new boolean[n + 1];
        sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int head = queue.poll();
            sb.append(head + " ");
            for (int nextNode : nextNodes.get(head)) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        v = Integer.parseInt(input[2]);
        visited = new boolean[n + 1];
        nextNodes = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; ++i) {
            nextNodes.add(new ArrayList<>());
        }
        for (int i = 0; i < m; ++i) {
            input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);
            nextNodes.get(n1).add(n2);
            nextNodes.get(n2).add(n1);
        }
        for (int i = 1; i <= n; ++i) {
            Collections.sort(nextNodes.get(i));
        }
        br.close();
    }
}