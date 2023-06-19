class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int x = 0;
        int n = 0;
        String xNum = "";
        String nNum = "";
        
        for(int i = 0; i < polynomial.length(); i++) {
            if (polynomial.charAt(i) == 'x') {
                if (xNum.equals("")){
                    x++;
                }else {
                    x += Integer.parseInt(xNum);
                    xNum = "";
                    nNum = "";
                }
            }
            else if (polynomial.charAt(i) == '+') {
                if(!nNum.equals("")) {
                    n += Integer.parseInt(nNum);
                    nNum = "";
                    xNum = "";
                }
            }
            else if (polynomial.charAt(i) != ' ') {
                nNum += polynomial.charAt(i);
                xNum += polynomial.charAt(i);
            }
        }
        
        if(!nNum.equals("")) {
            n += Integer.parseInt(nNum);
        }
        
        if(x != 0) {
            if (x == 1) {
                answer += 'x';
            }else {
                answer += (x + "x");
            }
        }
        if(n != 0) {
            if(!answer.equals("")) {
                answer += " + ";
            }
            answer += n;
        }
        
        return answer;
    }
}