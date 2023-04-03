import java.io.*;
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
		int Num = N;
		int NewNum = 0;
		int count = 0;
		
		while(true) {
	    	int ten = Num/10;
		    int one = Num%10;
		    
		    NewNum = (one*10) + (ten+one)%10;
		    //System.out.println(NewNum);
		    
		    if(NewNum == N) {
		    	count ++;
		    	System.out.println(count);
		    	break;
		    }else {
		    	Num = NewNum;
		    	count ++;
		    }
		}
	}

}