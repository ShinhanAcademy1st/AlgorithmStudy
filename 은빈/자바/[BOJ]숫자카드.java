import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Set<Integer> cards = new HashSet<>();
        for (int i = 0; i < n; i++) {
            cards.add(sc.nextInt());
        }
        
        int m = sc.nextInt();
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            int tmp = sc.nextInt();
            if(cards.contains(tmp)) {
                answer.add(1);
            }
            else {
                answer.add(0);
            }
        }
        
        for(int a: answer) {
            System.out.print(a + " ");
        }
    }
}