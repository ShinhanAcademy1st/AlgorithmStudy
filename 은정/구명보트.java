import java.util.*;
class Solution { 
    public int solution(int[] people, int limit) {
        int answer = 0;
         Arrays.sort(people);
        int j= 0;
        for(int i=people.length-1; i>=j; i--){
             if(people[i] + people[j] <= limit)
                 j++;
             answer++;
        }


            
        return answer;
    }
}



//         for(int i=0; i<people.length; i++){
//             for(int j=people.length-1; j!=i; j--){
//                 if(cnt[i]!=1 && cnt[j]!=1 && people[i]+people[j] <= limit){
//                     cnt[i] = 1;
//                     cnt[j] = 1;
//                     answer++;
//                     break;
//                 }
//             } 
//             if(cnt[i]==0)
//                 answer++;
//         }