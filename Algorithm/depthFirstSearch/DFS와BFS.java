package depthFirstSearch;

import java.util.*;

public class DFS와BFS {

    static int n;//정점의 갯수
    static int m;//간선의 갯수
    static int k;//시작 지점
    static boolean[] visit;
    static final int MAX = 10_100;
    static Graph graph;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        graph = new Graph(MAX);
        visit = new boolean[MAX];

        for (int i = 0; i < m; i++) {
            int node = sc.nextInt();
            int vi = sc.nextInt();
            graph.put(node, vi);
        }

        for (int i = 0; i < m; i++) {
            Collections.sort(graph.getNode(i));
        }

        DFS(k);
        Arrays.fill(visit, false);
        System.out.println("");
        BFS(k);
    }

    static void DFS(int node) {
        visit[node] = true;
        System.out.print(node + " ");
        for (int i = 0; i < graph.getNode(node).size(); i++) {
            int nextNode = graph.getNode(node).get(i);

            if (!visit[nextNode]) {
                DFS(nextNode);
            }
        }
    }
    //오름차순 하세요

    static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        visit[node] = true;
        queue.add(node);
        System.out.print(node + " ");

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int i = 0; i < graph.getNode(currentNode).size(); i++) {
               int nextNode = graph.getNode(currentNode).get(i);

               if (!visit[nextNode]) {
                   visit[nextNode] = true;
                   System.out.print(nextNode + " ");
                   queue.add(nextNode);
               }
            }
        }
    }
}
