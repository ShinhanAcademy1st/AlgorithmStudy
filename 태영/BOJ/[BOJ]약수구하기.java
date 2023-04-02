import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> temp = new ArrayList();
        for(int i=1; i<=N; i++){
            if(N%i == 0){
                temp.add(i);
            }
        }

        if(temp.size()<K){
            System.out.println(0);
        }else{
            System.out.println(temp.get(K-1));
        }
	}
}