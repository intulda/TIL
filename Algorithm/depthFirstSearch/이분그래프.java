package depthFirstSearch;

import java.util.Scanner;

/**
 * 이분 그래프
 * 백준 1707번 문제
 */
public class 이분그래프 {

    static int n;
    static Graph graph;
    static int[] group;
    static boolean[] visit;
    static final int MAX = 200_100;
    static boolean flag = true;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int nodeCnt = sc.nextInt();
            int trunk = sc.nextInt();

            flag = true;
            graph = new Graph(MAX);
            group = new int[MAX];
            visit = new boolean[MAX];

            for (int j = 0; j < trunk; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                graph.put(a, b);
            }

            for (int j = 1; j <= nodeCnt; j++) {
                if (!visit[j]) {
                    DFS(j, 1);
                }
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static void DFS(int node, int groupIndex) {
        group[node] = groupIndex;
        visit[node] = true;

        for (int i = 0 ; i < graph.getNode(node).size(); i++) {
            int nextNode = graph.getNode(node).get(i);

            if (group[nextNode] != 0 && group[nextNode] == groupIndex) {
                flag = false;
                return;
            }

            int _groupIndex = groupIndex == 1 ? 2 : 1;

            if (!visit[nextNode]) {
                DFS(nextNode, _groupIndex);
            }
        }
    }
}
