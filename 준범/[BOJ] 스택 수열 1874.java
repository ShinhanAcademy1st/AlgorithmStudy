import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] nums = new int[n];
        char [] operations = new char[n * 2];
        int opIndex = 0;
        int curNum = 1;
        boolean succeeded = true;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        for (int num : nums) {
            while (curNum <= num) {
                stack.push(curNum++);
                operations[opIndex++] = '+';
            }

            if (num != stack.peek()) {
                succeeded = false;
                break;
            }

            stack.pop();
            operations[opIndex++] = '-';
        }

        if (!succeeded) {
            System.out.println("NO");
        }
        else {
            for (char operation : operations) {
                System.out.println(operation);
            }
        }
    }
}
