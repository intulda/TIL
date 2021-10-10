package breadthFirstSearch;

import java.util.Scanner;

public class 바이러스 {

    static int n;
    static int m;
    static boolean[] visit;
    static Graph graph;
    static int count = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new Graph(m + 10);
        visit = new boolean[m + 10];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.put(a, b);
        }

        DFS(1);
        System.out.println(count);
    }

    static void DFS(int node) {
        visit[node] = true;
        count++;
        for (int i = 0; i < graph.getNode(node).size(); i++) {
            int nextNode = graph.getNode(node).get(i);

            if (!visit[nextNode]) {
                DFS(nextNode);
            }
        }
    }
}

