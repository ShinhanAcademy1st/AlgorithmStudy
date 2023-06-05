class Solution {
    public int solution(String dartResult) {
        int[] firstIdx = {dartResult.indexOf("S"), dartResult.indexOf("D"), dartResult.indexOf("T")};
        int idx = 12;
        for(int i = 0; i < 3; i++) {
            int tmp = firstIdx[i];
            if(tmp > 0) {
                if(tmp < idx) {
                    idx = tmp;
                }
            }
        }
        int pre = 0;
        int tmp = getScore(Integer.parseInt(dartResult.substring(0, idx)), dartResult.substring(idx, idx+1));
        int answer = 0;
        
        
        for(int i = idx + 1; i < dartResult.length(); i++) {
            if(dartResult.substring(i, i+1).equals("*")) {
                pre *= 2;
                tmp *= 2;
            } else if(dartResult.substring(i, i+1).equals("#")) {
                tmp *= -1;
            } else {
                answer += pre;
                pre = tmp;
                int tmpIdx;
                
                if(Character.isDigit(dartResult.charAt(i+1))) {
                    tmpIdx = i + 2;
                } else {
                    tmpIdx = i + 1;
                }
                
                tmp = getScore(Integer.parseInt(dartResult.substring(i, tmpIdx)), dartResult.substring(tmpIdx, tmpIdx+1));
                i = tmpIdx;
            }
        }
        answer += pre + tmp;
        
        return answer;
    }
    
    private int getScore(int num, String bonus) {
        int score = 0;
        switch(bonus) {
            case "S":
                score = (int)Math.pow(num, 1);
                break;
            case "D":
                score = (int)Math.pow(num, 2);
                break;
            case "T":
                score = (int)Math.pow(num, 3);
                break;
        }
        
        return score;
    }
}