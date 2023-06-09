import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0; 
        Set<List<Integer>> set = new HashSet<>(); 
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        
        for(int i=0; i<dirs.length(); i++){
            int len = set.size();

            switch(dirs.charAt(i)){
                case 'U':
                    if(y2<5)
                        y2++;
                    break;
                 case 'D':
                    if(y2 >-5)
                        y2--;
                    break;  
                 case 'R':
                    if(x2<5)
                        x2++;
                    break;
                 case 'L':
                    if(x2>-5)
                        x2--;
                    break;
                default:
                    break;
            }
            Integer arr[] = {x1,y1,x2,y2};
            Integer arr2[] = {x2,y2,x1,y1};
            set.add(Arrays.asList(arr));
            set.add(Arrays.asList(arr2));
            if((x1 != x2 || y1 != y2) && (len != set.size()))
                  answer++;
            x1 = x2;
            y1 = y2;
         }
       
        
        return answer;
    }
}