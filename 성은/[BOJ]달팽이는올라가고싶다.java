import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();
        int day=0;
        int x=a-b;
        if((v-a)%(a-b)==0) {
        	day = (v-a)/(a-b)+1;
        }else {
        	day = ((v-a)/(a-b))+2;
        }
        System.out.println(day);
    }
}