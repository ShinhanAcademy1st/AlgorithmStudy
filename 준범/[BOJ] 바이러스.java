import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int [][] pairs;
    static int [] parents;

    static int findParent(int num) {
        if (num == parents[num]) {
            return num;
        }
        return findParent(parents[num]);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        pairs = new int[p][2];
        parents = new int[n + 1];
        String[] input;
        for (int i = 1; i <= n; ++i) {
            parents[i] = i;
        }
        for (int i = 0; i < p; ++i) {
            input = br.readLine().split(" ");
            pairs[i][0] = Integer.parseInt(input[0]);
            pairs[i][1] = Integer.parseInt(input[1]);
        }
        for (int i = 0; i < p; ++i) {
            int parent1 = findParent(pairs[i][0]);
            int parent2 = findParent(pairs[i][1]);
            if (parent1 < parent2) {
                parents[parent2] = parents[parent1];
            }
            else if (parent2 < parent1) {
                parents[parent1] = parents[parent2];
            }
        }
        int answer = 0;
        for (int i = 2; i <= n; ++i) {
            if (findParent(i) == 1) {
                ++answer;
            }
        }
        System.out.println(answer);
        br.close();
    }
}