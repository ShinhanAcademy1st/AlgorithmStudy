import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    Integer[] ropes = new Integer[N];
	    for(int i=0; i<ropes.length; i++) {
	    	ropes[i] = Integer.parseInt(br.readLine());
	    }
	    
	    Arrays.sort(ropes, Collections.reverseOrder());
	    
	    Integer[] weights = new Integer[N];
	    for(int i=0; i<N; i++) {
	    	weights[i] = ropes[i]*(i+1);
	    }
	    
	    Arrays.sort(weights, Collections.reverseOrder());
	    
	    System.out.println(weights[0]);
	}

}