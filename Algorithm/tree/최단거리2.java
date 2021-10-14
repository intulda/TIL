package tree;

import java.util.Scanner;

public class 최단거리2 {

    static int n;
    static int m;
    static boolean[] check;
    static int[] table;
    static Graph graph;
    static Graph cost;
    static final int SIZE = 1_000_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new Graph(SIZE);
        cost = new Graph(SIZE);
        check = new boolean[SIZE];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = 1;

            graph.put(a, b);
            cost.costPut(a, b, c);
        }

        for (int i = 0; i < n; i++) {
            table[i] = Integer.MAX_VALUE;
        }

        int start = sc.nextInt();
        int end = sc.nextInt();
        table[start] = 0;

        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < n; i++) {

        }


    }
}
