class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            String str = "";
            int[] bin1 = getBinary(arr1[i], n);
            int[] bin2 = getBinary(arr2[i], n);
            
            for(int j = 0; j < n; j++) {
                if(bin1[j] == 1 || bin2[j] == 1) str += "#";
                else str += " ";
            }
            answer[i] = str;
        }
        
        return answer;
    }
    
    private int[] getBinary(int num, int size) {
        int[] arr = new int[size];
        String str = "";
        
        while(num != 0) {
            str += num % 2;
            num /= 2;
        }
        
        for(int i = 0; i < str.length(); i++) {
            arr[size - 1 - i] = str.charAt(i) - '0';
        }
        return arr;
    }
}