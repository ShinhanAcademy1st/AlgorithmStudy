class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count=0;
        int zero=0;
        while(s.length()!=1){
            count++;
            String newS=s.replace("0","");
            zero+=s.length()-newS.length();
            Integer num = newS.length();
            s="";
            while(num!=1){
                s+=(num%2);
                num = num/2;
            }
            s+="1";
        }
        answer[0]=count;
        answer[1]=zero;
        
        return answer;
    }
}