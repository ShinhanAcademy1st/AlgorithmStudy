import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int val : arr) {
            if(!stack.contains(val)) {
                if(stack.size() != 0) {
                    answer.add(stack.pop());
                    stack.clear();
                }
                stack.push(val);
            }
        }
        
        if(stack.size() != 0) {
            answer.add(stack.pop());
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}