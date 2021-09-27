package depthFirstSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 이분그래프판별 {

    static int n;
    static int m;
    static ListGraph graph;
    static boolean[] check;
    static boolean flag = true;
    static int[] groupCheck;
    static final int MAX = 100_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ListGraph(MAX);
        check = new boolean[MAX];
        groupCheck = new int[MAX];

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.put(a, b);
        }
        DFS(1, 1);

        if(flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    //1 -> 2 -> 4 -> 3 -> 5 -> 6
    //1    2    1    2    1    2

    //1 - 2
    //| \ |
    //3 - 4

    // 1  ->  2   ->  4  ->  3
    // 1      2       1      2
    //true   false   true   false

    static void DFS(int x, int groupIndex) {
        groupCheck[x] = groupIndex;
        check[x] = true;
        for(int i=0; i<graph.getNode(x).size(); i++) {
            int nextNode = graph.getNode(x).get(i);

            if(groupCheck[nextNode] != 0 && groupCheck[nextNode] == groupIndex) {
                flag = false;
                return;
            }
            int group = groupIndex == 1 ? 2 : 1;
            if(!check[nextNode]) {
                DFS(nextNode, group);
            }
        }
    }
}

class ListGraph {
    private ArrayList<ArrayList<Integer>> graph;

    public ListGraph(int size) {
        graph = new ArrayList<>();
        for(int i=0; i<size+1; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void sortGraph(int n) {
        Collections.sort(graph.get(n));
    }

    public ArrayList<Integer> getNode(int n) {
        return graph.get(n);
    }

    public void put(int n, int m) {
        graph.get(n).add(m);
        graph.get(m).add(n);
    }

    public boolean isAdjacent(int x) {
        for(int i=0; i<graph.get(x).size(); i++) {
            if(graph.get(x).get(i) == x) {
                return true;
            }
        }
        return false;
    }
}


