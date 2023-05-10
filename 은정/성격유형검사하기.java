import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder("");
        int score[] = {3,2,1,0,1,2,3};  
        String kakao[][] = {{"R","T"}, {"C","F"}, {"J","M"}, {"A","N"}};
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0; i<survey.length; i++){
           String surArr[] = survey[i].split(""); 
            int n = 0;  
            int preValue = 0;
            if(choices[i] > 4)
                n = 1;
            if(map.containsKey(surArr[n]))
                preValue = map.get(surArr[n]);
            map.put(surArr[n],preValue+score[choices[i]-1]); 
        }
        
        int total1 = 0;
        for(int i=0; i<kakao.length; i++){
            for(int j=0; j<kakao[i].length; j++){
                int val = map.containsKey(kakao[i][j]) ? map.get(kakao[i][j]) : 0;
                if(j==0)
                    total1 = val;
                else{
                    if(val > total1)
                        answer.append(kakao[i][1]);
                    else
                        answer.append(kakao[i][0]);
                }
            }
        }
        
        return answer.toString();
    }
}