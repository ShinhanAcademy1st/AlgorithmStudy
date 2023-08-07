class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        long[] arr1 = new long[10];
        long[] arr2 = new long[10];
        
        for(int i = 0; i < Math.max(X.length(), Y.length()); i++) {
            if(i < X.length()) {
                arr1[(int) (X.charAt(i) - '0')]++;
            }
            if(i < Y.length()) {
                arr2[(int) (Y.charAt(i) - '0')]++;
            }
        }
        
        for(char i = '9'; i >= '0'; i--) {
            int idx = (int) (i - '0');
            long cnt = Math.min(arr1[idx], arr2[idx]);
            for(long j = 0; j < cnt; j++) {
                answer.append(i);
            }
        }
        
        if(answer.length() == 0) answer.append("-1");
        if(answer.substring(0, 1).equals("0")) answer = new StringBuilder("0");
        
        return answer.toString();
    }
}