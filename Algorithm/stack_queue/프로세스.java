package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class 프로세스 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 1, 9, 1, 1, 1}, 0));
    }

    static class Doc {
        int index;
        int pr;
        public Doc(int index, int pr) {
            this.index = index;
            this.pr = pr;
        }
    }

    static int solution(int[] priorities, int location) {
        Queue<Doc> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Doc(i, priorities[i]));
        }

        int executeCount = 0;

        while (!queue.isEmpty()) {
            Doc current = queue.poll();

            boolean hasHigher = false;
            for (Doc d : queue) {
                if (d.pr > current.pr) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.offer(current);
            } else {
                executeCount++;
                if (current.index == location) {
                    return executeCount;
                }
            }
        }

        return executeCount;
    }
}
