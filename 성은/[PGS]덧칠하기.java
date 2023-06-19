class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        for(int i=0;i<section.length;i++){
            answer++;
            int a=0; //뛰어넘을 값 체크
            for(int j=i+1;j<section.length;j++){
                if(section[j]<=section[i]+m-1) a++;
            }
            i+=a;
        }
        return answer;
    }
}