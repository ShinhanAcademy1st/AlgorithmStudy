//런타임 에러 (ArrayIndexOutOfBounds)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int c = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int info[][] = new int[n][2];
        int people[] = new int[c+1];
        
        for(int i=0; i<n; i++){
            input =  br.readLine().split(" ");
            info[i][0] = Integer.parseInt(input[0]);
            info[i][1] = Integer.parseInt(input[1]);
        }
//        br.close();
        
        for(int i=0; i<n; i++){
            int price = info[i][0];
            int p = info[i][1];
            if(price % p == 0){
                price /= p;
                p = 1; 
            }
  
            for(int j=1; j<= Math.min(people.length/p, people.length-1) ; j++) {
            	if(people[p*j] != 0) {
            		people[p*j] = Math.min(people[p*j], price*j); 
            	}else
            		people[p*j] = price*j;
            } 
        }
        int answer =  Integer.MAX_VALUE;
        for(int i=c; i>0; i--) {
         	if( people[i] != 0 && people[c-i]!= 0)
        		answer = Math.min(answer, people[i]+people[c-i]);
        } 
        System.out.println(answer);
    }
}