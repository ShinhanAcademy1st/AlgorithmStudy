class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int lastPainted = -1;
        for (int index : section) {
            if (index > lastPainted) {
                lastPainted = index + m - 1;
                ++answer;
            }
        }
        return answer;
    }
}