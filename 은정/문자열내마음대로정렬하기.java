import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
		 	String[] answer = new String[strings.length];
		 	HashMap<String, Integer> map = new HashMap<>();
		 	String arr[] = new String[strings.length];
		 	
		 	for(int i=0; i<strings.length; i++) {
		 		String str = strings[i].charAt(n)+""+strings[i];
		 		arr[i]= str; 
		 		map.put(str, i);
		 	}
		 	Arrays.asList(arr).sort(null);
		 	
		 	for(int i=0; i<strings.length; i++) {
		 		answer[i] = strings[map.get(arr[i])];
		 	}
		 	 
	        return answer;
    }
}