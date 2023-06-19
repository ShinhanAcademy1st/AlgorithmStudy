class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int x = (board[0] - 1) / 2;
        int y = (board[1] - 1) / 2;
        
        for(String d : keyinput)  {
            switch (d) {
                case "up":
                    if(answer[1] < y) {
                        answer[1]++;
                    }
                    break;
                case "down":
                    if(answer[1] > -y) {
                        answer[1]--;
                    }
                    break;
                case "left":
                    if(answer[0] > -x) {
                        answer[0]--;
                    }
                    break;
                case "right":
                    if(answer[0] < x)  {
                        answer[0]++;
                    }
                    break;
            }
        }
        
        return answer;
    }
}