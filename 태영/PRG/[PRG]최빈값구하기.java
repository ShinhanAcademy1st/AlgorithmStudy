import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
int result = 0;
		int length = 1001;
		
		int[] new_array = new int[length];
		for(int a:array) {
			new_array[a] += 1;
		}
		
		//깊은 복사
		int[] old_array = new int[length];
		for(int i=0; i<new_array.length; i++) {
			old_array[i] = new_array[i];
		}
		
		Arrays.sort(new_array);
		
		//가장 큰 값
		int max_num = new_array[new_array.length-1];
		
		int count = 0;
		for(int i=0; i<new_array.length; i++) {
			if(old_array[i] == max_num) {
				result = i;
				count += 1;
			}
		}
		
		return count > 1 ? -1 : result;
    }
}