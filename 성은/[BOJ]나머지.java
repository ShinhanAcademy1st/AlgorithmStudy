import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<10;i++){
            int num=sc.nextInt();
            num%=42;
            set.add(num);
        }
        System.out.println(set.size());
    }
}