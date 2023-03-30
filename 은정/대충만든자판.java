import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];
		Map<String, Integer> map = new HashMap<>();

		Arrays.stream(keymap).forEach(key -> {
			String[] keys = key.split("");
			Arrays.stream(keys).forEach(k -> {
				int n = key.indexOf(k) + 1;
				if (map.get(k) == null || map.get(k) > n) {
					map.put(k, n);
				}
			});
		});
        for (int i = 0; i < targets.length; i++) {
			String[] tg = targets[i].split("");
			for(String k : tg) {
				if(!map.containsKey(k)) {
					answer[i] = -1;
					break;
				}
				answer[i] += map.get(k);
			}
		}

	        return answer;
    }
}