/**
 * 촌수계산
 * 주어진 두 번호의 촌수 계산
 * 부모는 한명이고, 자식은 없거나 여러명이 될 수 있음
 * 부모는 배열로, 자식은 2차원 리스트로 저장
 * 두명의 사람(p1, p2) 둘 중 아무나 자식, 부모가 되어도 상관이 없지만
 * p1을 자식으로, p2를 부모로 생각하고 프로그램 수행
 * 1. 자신의 부모를 포함해 조상중에 p2가 있는지 검색
 *   1-1. 있으면 그까지의 거리 return
 * 2. 자신의 자식들을 포함해 자손들 중 p2가 있는지 검색
 *   2-1. 자신의 자손들을 순회하며 발견하면 해당 번호를 return하고 탐색 종료
 * 3. 부모를 포함한 조상, 자식들을 포함한 자손들에 p2가 존재하지 않으면 -1을 return
 * 
 * 재귀를 사용하고 호출 할 때마다 거리 1씩 증가(부모든, 자식이든 상관x)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<List<Integer>> children;
    static int [] parents;
    static boolean [] visited;

    static int findRelation(int child, int parent, int distance) {
        visited[child] = true;
        int result = -1;
        if (child == 0) {
            return -1;
        }
        if (child == parent) {
            return distance;
        }
        if (!visited[parents[child]]) {
            result = findRelation(parents[child], parent, distance + 1);
            if (result != -1) {
                return result;
            }
        }

        for (int i = 0; i < children.get(child).size(); ++i) {
            int grandChild = children.get(child).get(i);
            if (!visited[grandChild]) {
                result = findRelation(grandChild, parent, distance + 1);
                if (result != -1) {
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        children = new ArrayList<>(n + 1);
        visited = new boolean[n + 1];
        parents = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            children.add(new ArrayList<>());
        }
        String[] input = br.readLine().split(" ");
        int p1 = Integer.parseInt(input[0]);
        int p2 = Integer.parseInt(input[1]);
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; ++i) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            parents[y] = x;
            children.get(x).add(y);
        }

        System.out.println(findRelation(p1, p2, 0));
        br.close();
    }
}