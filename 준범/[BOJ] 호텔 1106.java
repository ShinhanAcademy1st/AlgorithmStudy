import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int c, n;
    static int minPrice = 200000000;
    static int [][] people;
    static int [][] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        c = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        people = new int[n][100002];
        info = new int[n][2];
        for (int i = 0; i < n; ++i) {
            input = br.readLine().split(" ");
            info[i][0] = Integer.parseInt(input[0]);
            info[i][1] = Integer.parseInt(input[1]);
        }
        br.close();

        int price = info[0][0];
        int client = info[0][1];
        for (int j = price; j < minPrice; ++j) {
            people[0][j] = people[0][j - price] + client;
            if (people[0][j] >= c) {
                minPrice = j;
                break;
            }
        }

        for (int i = 1; i < n; ++i) {
            price = info[i][0];
            client = info[i][1];
            for (int j = 0; j < price; ++j) {
                people[i][j] = people[i - 1][j];
            }
            for (int j = price; j < minPrice; ++j) {
                people[i][j] = Math.max(people[i][j - price] + client, people[i - 1][j]);
                if (people[i][j] >= c) {
                    minPrice = j;
                    break;
                }
            }
        }

        System.out.println(minPrice);
    }
}