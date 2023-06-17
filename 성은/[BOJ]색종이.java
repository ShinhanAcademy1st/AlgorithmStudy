import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean[][] arr = new boolean[100][100]; 
        int result=0;
        for(int i=0;i<num;i++){
            int posx=sc.nextInt();
            int posy=sc.nextInt();
            for(int x=posx;x<posx+10;x++){
                for(int y=posy;y<posy+10;y++){
                    if(!arr[x][y]){
                        arr[x][y]=true;
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}