import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int length = priorities.length;
        for (int i = 0; i < length; ++i) {
            queue.add(i);
            map.put(priorities[i], map.getOrDefault(priorities[i], 0) + 1);
        }
        int order = 1;
        while (true) {
            int head = queue.poll();
            int priority = priorities[head];
            boolean highest = true;
            for (int i = priority + 1; i < 10; ++i) {
                if (map.getOrDefault(i, 0) > 0) {
                    highest = false;
                    break;
                }
            }
            if (highest) {
                if (head == location) {
                    answer = order;
                    break;
                }
                map.put(priority, map.get(priority) - 1);
                ++order;
            }
            else {
                queue.offer(head);
            }
        }
        return answer;
    }
}