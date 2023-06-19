import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int w = park[0].length();
        int h = park.length;
        
        for(int i=0; i<park.length; i++){
            int n = park[i].indexOf('S');
             if(n != -1){
                answer[0] = i;
                answer[1] = n;
                break;
            }
        } 
        
        for(int i=0; i<routes.length; i++){
            String route[] = routes[i].split(" ");
            int r = Integer.parseInt(route[1]);
            boolean rst = true;
             switch(route[0]){
                case "E": 
                    if(answer[1] + r < w){
                        for(int j=1; j<=r; j++){
                            if(park[answer[0]].charAt(answer[1]+j) == 'X'){
                                rst = false;
                                break;                                
                            }
                        }
                        if(rst)
                            answer[1] += r;                         
                     }
                    break;
                case "W": 
                     if(answer[1] - r >= 0){
                        for(int j=r; j>=1; j--){
                            if(park[answer[0]].charAt(answer[1]-j) == 'X'){
                                rst = false;
                                break;                                
                            }
                        }
                        if(rst)
                            answer[1] -= r;                         
                     }
                    break;
                case "S": 
                     if(answer[0] + r < h){
                        for(int j=1; j<=r; j++){
                            if(park[answer[0]+j].charAt(answer[1]) == 'X'){
                                rst = false;
                                break;
                            }
                        }
                        if(rst)
                            answer[0] += r;                         
                     }
                    break;
                case "N": 
                      if(answer[0] - r >= 0){
                        for(int j=r; j>=1; j--){
                            if(park[answer[0]-j].charAt(answer[1]) == 'X'){
                                rst = false;
                                break;
                            }
                        }
                        if(rst)
                            answer[0] -= r;                         
                     }
                    break;
                 default:
                     break;
            }
        }        
        return answer;
    }
}