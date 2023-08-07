import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 각 사람을 신고한 사람
        HashMap<String, HashSet<String>> rep = new HashMap<>();
        
        for(String input : report) {
            // 0: 신고한 사람, 1: 신고당한 사람
            String[] member = input.split(" ");
            HashSet<String> tmp = rep.getOrDefault(member[1], new HashSet<String>());
            tmp.add(member[0]);
            rep.put(member[1], tmp);
        }
        
        // 각 사람이 신고당한 수
        for(String key : rep.keySet()) {
            HashSet<String> tmp = rep.get(key);
            
            if(tmp.size() >= k) {
                Iterator it = tmp.iterator();
                while(it.hasNext()) {
                    String name = (String) it.next();
                    int idx = 0;
                    for(int i = 0; i < id_list.length; i++) {
                        if(id_list[i].equals(name)) {
                            idx = i;
                            break;
                        }
                    }
                    answer[idx]++;
                }
            }
        }
        
        
        
        return answer;
    }
}