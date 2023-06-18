/**
* 다익스트라 알고리즘 사용
* 1. 1번부터 N번 도시까지 도착해야되는 거리 배열 초기화(Integer.MAX_VALUE)
*   -> 현재 갈 수있는 거리 무한대로 초기화
* 2. 각 도시로 부터 직접 도달할 수 있는 인접 리스트 작성
*   -> road[][] 배열에서 제공되는 데이터로부터 2차원 리스트로 가공
*   -> Distance 클래스 사용(거리, 목적지)
* 3. 다익스트라 알고리즘 이용해서 1번부터 시작
* 
*
* Dijkstra(다익스트라) 알고리즘 사용(+ 우선순위 큐 사용)
* 우선 순위 큐 : 1번 도시에서 도달 할 수 있는 거리 기준으로 가까운 순으로 정렬 됨
* ==> 큐의 가장 앞에 있는 도시 : 다음에 방문할 도시(1번 도시에서 갈 수 있는 가장 가까운 거리)
* 큐가 빌 때까지 반복
* 1. 다음 목적지를 큐에서 추출 -> queue.poll() or queue.pop()
* 2. 다음 목적지까지 큐에서 뽑아낸 거리보다 이미 구한 거리가 더 가까우면 패스(다시 1번으로)
*   -> 패스해도 되는 이유 : 더 가까운 거리 정보가 구해져 있고, 
*   -> 해당 목적지로부터 갈 수 있는 목적지들 또한 더 가까운 거리가 구해져 있기 때문
* 3. 다음 목적지로부터 갈 수 있는 목적지들(다다음 목적지)을 우선순위 큐에 삽입
*   -> 초기화 했던 인접리스트로 부터 값을 가져오는데, 이때 주의할 점은 1번부터
*   -> 다음 목적지까지 갈 수 있는 거리 + 다음 목적지에서 다다음 목적지로 가는 거리를 더해야됨
*   -> 현재 구한 다다음 목적지 까지 갈 수 있는 거리가, 이미 구해진 거리보다 길지 않다면 큐에 삽입
* 1, 2, 3을 큐가 빌때까지 반복
*
* 마지막으로 distance 배열에서 K이하의 거리로 갈 수 있는 도시들의 개수 return
*/
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    
    int [] distances;
    List<List<Distance>> adjacent;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        init(N, road);
        dijkstra();
        answer = (int)Arrays.stream(distances).filter(distance -> distance <= K).count();
        return answer;
    }
    
    private void dijkstra() {
        int city = 1;
        PriorityQueue<Distance> queue = new PriorityQueue<>();
        distances[1] = 0;
        for (Distance nextCity : adjacent.get(city)) {
            queue.offer(nextCity);
        }
        while (!queue.isEmpty()) {
            Distance head = queue.poll();
            int next = head.to;
            
            // 이미 도달할 수 있는 더 짧은 거리가 있다면 패스
            if (distances[next] <= head.value) {
                continue;
            }
            
            distances[next] = head.value;
            
            // 다음 도시에서 갈 수 있는 도시들 큐에 삽입
            for (Distance nextNext : adjacent.get(next)) {
                nextNext.value += distances[next];
                if (distances[nextNext.to] > nextNext.value) {
                    queue.offer(nextNext);
                }
            }
        }
    }
    
    private void init(int N, int [][] road) {
        distances = new int[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        adjacent = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; ++i) {
            adjacent.add(new ArrayList<>());
        }
        // 인접 리스트 초기화
        for (int [] info : road) {
            adjacent.get(info[0]).add(new Distance(info[2], info[1]));
            adjacent.get(info[1]).add(new Distance(info[2], info[0]));
        }
    }
}

class Distance implements Comparable<Distance> {
    int value;
    int to;
    Distance(int value, int to) {
        this.value = value;
        this.to = to;
    }
    
    public int compareTo(Distance d) {
        if (this.value == d.value) {
            return this.to - d.to;
        }
        return this.value - d.value;
    }
}