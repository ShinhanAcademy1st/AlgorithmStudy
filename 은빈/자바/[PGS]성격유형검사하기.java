import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<String, Integer> score = new HashMap<>();
        String[][] types = {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};
        int[] num = {0, 3, 2, 1, 0, 1, 2, 3};
        
        for(int i = 0; i < survey.length; i++) {
            String no = survey[i].substring(0, 1);
            String yes = survey[i].substring(1, 2);
            int s;
            switch (choices[i]) {
                case 1, 2, 3:
                    s = score.getOrDefault(no, 0) + num[choices[i]];
                    score.put(no, s);
                    break;
                case 5, 6, 7:
                    s = score.getOrDefault(yes, 0) + num[choices[i]];
                    score.put(yes, s);
                    break;
                default:
                    break;
            }
        }
        
        String answer = "";
        for(int i = 0; i < types.length; i++) {
            int type1 = score.getOrDefault(types[i][0], 0);
            int type2 = score.getOrDefault(types[i][1], 0);
            
            if(type1 > type2) answer += types[i][0];
            else if(type1 < type2) answer += types[i][1];
            else {
                if(types[i][0].compareTo(types[i][1]) < 0) answer += types[i][0];
                else answer += types[i][1];
            }
        }
        
        return answer;
    }
}