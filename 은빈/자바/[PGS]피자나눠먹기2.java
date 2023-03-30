class Solution {
    public int solution(int n) {
        int gcd = getGcd(Math.max(n, 6), Math.min(n, 6));
        int answer = n * 6 / gcd;

        answer /= 6;

        return answer;
    }

    private int getGcd(int num1, int num2) {
        int r = num1 % num2;

        if(r == 0) {
            return num2;
        }
        return getGcd(num2, r);
    }
}