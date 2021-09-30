package breadthFirstSearch;

import java.util.*;

public class 이분그래프탐색2 {

    static int n;
    static int m;
    static boolean[] check;
    static int[] visit;
    static Graph graph;
    static boolean flag = true;
    static int groupIndex = 1;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new Graph(m + 10);
        check = new boolean[m + 10];
        visit = new int[m + 10];

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.put(a, b);
        }

        BFS(1);
        if(flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
    static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        while(!queue.isEmpty()) {
            int current = queue.poll();//4

            visit[current] = groupIndex; //2
            for(int i=0; i<graph.getNode(current).size(); i++) {
                int nextNode = graph.getNode(current).get(i); //3

                if(visit[nextNode] != 0 && visit[nextNode] == groupIndex) {
                    flag = false;
                    return;
                }

                if(!check[nextNode]) {
                    groupIndex = visit[current] == 1 ? 2 : 1;
                    visit[nextNode] = groupIndex;
                    check[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
    }
}

class Graph {
    private ArrayList<ArrayList<Integer>> graph;

    public Graph(int nodeSize) {
        graph = new ArrayList<>();
        for(int i=0; i<nodeSize+1; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void put(int n, int m) {
        graph.get(n).add(m);
        graph.get(m).add(n);
    }

    public ArrayList<Integer> getNode(int n) {
        return graph.get(n);
    }
}