package tree;

import java.util.ArrayList;
import java.util.Scanner;

public class 최단거리 {

    //T(i) : 정점 i에 도달하는데 걸리는 최단거리

    //(1) T[i] 중 최솟값을 정한다. 단, 지금까지 최솟값으로 봅히지 않았던 값들 중
    //(2) index로부터 뻗어나간다. T[index] + cost
    static int n;
    static int m;
    static int start;
    static int end;
    static Graph graph;
    static Graph cost;
    static int[] table;
    static boolean[] check;
    static final int SIZE = 1_000_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new Graph(SIZE);
        cost = new Graph(SIZE);
        table = new int[SIZE];
        check = new boolean[SIZE];
        start = sc.nextInt();
        end = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.put(a, b);
            cost.costPut(a, b, c);
        }

        for (int i = 0; i < n; i++) {
            table[i] = Integer.MAX_VALUE;
        }
        table[start] = 0;
        for (int i = 0; i < n; i++) {
            //최솟값을 구한다. 최단거리로 확정되지 않았던 정점에 대해서
            //그 최솟값을 갖는 노드로부터 뻗어나간다.
            int minValue = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < n; j++) {
                if (!check[j] && minValue > table[j]) {
                    minValue = table[j];
                    minIndex = j;
                }
            }

            check[minIndex] = true;

            for (int j = 0; j < graph.getNode(minIndex).size(); j++) {
                int nextNode = graph.getNode(minIndex).get(j);
                int nextCost = cost.getNode(minIndex).get(j);

                if (table[nextNode] > table[minIndex] + nextCost) {
                    table[nextNode] = table[minIndex] + nextCost;
                }
            }
        }

        System.out.println(table[end]);
    }
}

class Graph {
    private ArrayList<ArrayList<Integer>> graph;

    public Graph(int size) {
        graph = new ArrayList<>();

        for (int i = 0; i < size + 1; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void put(int a, int b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    public void costPut(int a, int b, int cost) {
        graph.get(a).add(cost);
        graph.get(b).add(cost);
    }

    public ArrayList<Integer> getNode(int x) {
        return graph.get(x);
    }
}