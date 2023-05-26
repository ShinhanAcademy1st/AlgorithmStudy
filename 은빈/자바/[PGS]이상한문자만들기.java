class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ' ') {
                idx = 0;
                answer += ch;
            } else if(idx % 2 == 0) {
                idx++;
                answer += Character.toUpperCase(ch);
            } else {
                idx++;
                answer += Character.toLowerCase(ch);
            }
        }
        
        return answer;
    }
}