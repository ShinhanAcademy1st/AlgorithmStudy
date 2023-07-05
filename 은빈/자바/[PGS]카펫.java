class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int row = brown / 2; row > 0; row--) {
            for(int col = 1; col <= row; col++) {
                if((row - 2) * (col - 2) == yellow) {
                    if(row * 2 + (col * 2 - 4) == brown) {
                        answer[0] = row;
                        answer[1] = col;
                        break;
                    }
                }
            }
            if(answer[0] != 0) break;
        }
        return answer;
    }
}