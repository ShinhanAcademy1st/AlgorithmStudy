import java.util.Scanner;
public class Main {
	public static void main(String[] args) { 
        int arr[][] = new int[30][30];
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<30; i++) {
			arr[i][0] = 1;
			arr[i][i] = 1;
		}
		for(int i=1; i<30; i++) {
			for(int j=1; j<i+1; j++ ) {
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
 			}
		} 		
		
        while(num != 0 ){
        	String nm[] = sc.nextLine().split(" ");
        	int n = Integer.parseInt(nm[0]);
        	int m = Integer.parseInt(nm[1]);
        	System.out.println(arr[m][n]);
            num--;
        }
        
        sc.close();
    }
}