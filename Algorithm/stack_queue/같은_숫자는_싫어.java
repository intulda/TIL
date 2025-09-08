package stack_queue;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        int[] ex = new int[]{1, 1, 3, 3, 0, 1, 1};
        System.out.println(Arrays.toString(Solution.solution(ex)));
    }

    public class Solution {
        public static int[] solution(int[] arr) {
            int[] answer = null;

            Stack<Integer> stack = new Stack<>();

            for (int j : arr) {
                if (stack.empty()) {
                    stack.add(j);
                    continue;
                }

                if (stack.peek() == j) {
                    continue;
                }
                stack.add(j);
            }

            answer = stack.stream()
                    .mapToInt(x -> x)
                    .toArray();

            return answer;
        }
    }
}
