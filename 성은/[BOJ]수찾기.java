import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        Set<Integer> set = new HashSet();
        for(int i=0;i<a;i++){
            set.add(sc.nextInt());
        }
        int m = sc.nextInt();
        for(int i=0;i<m;i++){
            int size=set.size();
            set.add(sc.nextInt());
            if(size==set.size()){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}