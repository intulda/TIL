package depthFirstSearch;

import java.util.Scanner;
import java.util.Queue;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Arrays;

public class DFS와BFS {
    static int n;
    static int m;
    static int k;
    static boolean[] visit;
    static Graph graph;
    static final int SIZE = 10_100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        graph = new Graph(SIZE);
        visit = new boolean[SIZE];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.put(a, b);
        }

        for (int i = 0; i < m; i++) {
            Collections.sort(graph.getNode(i));
        }

        DFS(k);
        Arrays.fill(visit, false);
        System.out.println("");
        BFS(k);

    }

    static void DFS(int x) {
        visit[x] = true;
        System.out.print(x + " ");
        for (int i = 0; i < graph.getNode(x).size(); i++) {
            int nextNode = graph.getNode(x).get(i);

            if (!visit[nextNode]) {
                visit[nextNode] = true;
                DFS(nextNode);
            }
        }
    }

    static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        visit[x] = true;
        queue.add(x);
        System.out.print(x + " ");
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < graph.getNode(node).size(); i++) {
                int nextNode = graph.getNode(node).get(i);
                if(!visit[nextNode]) {
                    System.out.print(nextNode + " ");
                    visit[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }

    }
}
