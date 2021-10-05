package breadthFirstSearch;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class 전염병 {
    static int n;
    static int k;
    static boolean[] visit;
    static int[] town;
    static int count = 0;
    static final int MAX = 100_100;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        town = new int[MAX];
        visit = new boolean[MAX];

        for (int i = 1; i <= n; i++) {
            town[i] = i;
        }

        BFS(k);
        System.out.println(n - count);

    }

    static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visit[x] = true;
        count++;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            int nextNode = currentNode * 2;
            int backNode = currentNode / 3;

            if (nextNode <= n && !visit[nextNode]) {
                visit[nextNode] = true;
                queue.add(nextNode);
                count++;
            }

            if (backNode > 0 && !visit[backNode]) {
                visit[backNode] = true;
                queue.add(backNode);
                count++;
            }
        }
    }
}
