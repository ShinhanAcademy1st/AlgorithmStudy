import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n>1){
            n-=cal(n);
            ans++;
        }
        return n==1?ans+1:ans;
    }
    public int cal(int n){
        int num=2;
        while(n>=num){
            num*=2;
        }
        return num/2;
    }
}