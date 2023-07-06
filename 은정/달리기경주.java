import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        List<String> list = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        
        list = Arrays.asList(players);
        for(int i=0; i<players.length; i++){
            map.put(players[i],i);            
        } 
        for(String player:callings){
             int n = map.get(player);
            list.set(n, list.get(n-1));
            list.set(n-1, player);
            map.put(player,n-1);
            map.put(list.get(n),n);
            
        }
        
        for(int i=0; i<players.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}