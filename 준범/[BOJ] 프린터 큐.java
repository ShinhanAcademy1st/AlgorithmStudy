/**
 * 1. 각 중요도의 개수 파악 -> O(N)
 *  2. 각 문서의 인덱스를 큐에 삽입
 * 3. 타겟 문서를 삭제할때까지 반복
 *   3-1. 큐의 맨앞에 있는 문서 큐에서 삭제 -> 해당 문서의 중요도보다 높은 중요도의 개수만 체크
 *     -> O(8) -> 젤 낮은 중요도가 1이고, 1보다 높은 중요도는 8개밖에 없기때문에 항상 O(8)
 *     3-1-1. 중요도가 더 높은 문서가 큐에 남아있다. -> 큐의 맨뒤에 다시 삽입
 *     3-1-2. 중요도가 더 높은 문서가 큐에 없다. -> 삭제
 *       3-1-2-1. 목표 문서이다(삭제할 문서가 m번째에 위치한다) -> 출력 값에 삽입 후 해당 테스트케이스 종료
 *       3-1-2-2. 목표 문서가 아니다 -> 순서 1 증가, 삭제한 문서의 중요도 카운트 1 감소, 3-1의 과정 다시 진행
 *
 * 모든 테스트 케이스가 종료되면 답을 출력한다.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n, m;
        String [] input;

        while (t > 0) {
            input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            input = br.readLine().split(" ");
            int [] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = Integer.parseInt(input[i]);
            }
            answer.append(getAnswer(n, m, nums) + "\n");
            --t;
        }
        System.out.println(answer.toString());
        br.close();
    }

    static int getAnswer(int n, int m, int [] nums) {
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;
        int [] count = new int[10];
        for (int i = 0; i < n; ++i) {
            queue.offer(i);
            ++count[nums[i]];
        }
        int order = 1;
        while (true) {
            int head = queue.poll();
            int weight = nums[head];

            boolean heaviest = true;
            for (int i = weight + 1; i < 10; ++i) {
                if (count[i] > 0) {
                    heaviest = false;
                    break;
                }
            }

            if (heaviest) {
                if (head == m) {
                    answer = order;
                    break;
                }
                count[weight] -= 1;
                order += 1;
            }
            else {
                queue.offer(head);
            }
        }
        return answer;
    }
}