import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        while(q.size()>1){
            q.poll();
            if(q.size()==1) break;
            q.add(q.poll()); 
        }
        System.out.println(q.poll());
    }
}