package depthFirstSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 인접리스트2 {

    //9 12
    //1 2
    //1 3
    //2 3
    //2 4
    //2 6
    //3 7
    //4 5
    //4 7
    //4 8
    //5 6
    //7 8
    //8 9

    static final int MAX = 100;
    static int n;
    static int m;
    static Graph graph;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        graph = new Graph(MAX);
        visited = new boolean[MAX];
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.put(a, b);
        }
        DFS(1);
    }

    static void DFS(int x) {
        //x 부터 시작해서 DFS하여 그 순서를 출력하는 함수.
        //단, visited에 방문 기록이 있음
        visited[x] = true;
        System.out.print(x + " ");
        for(int i=0; i<graph.getNode(x).size(); i++) {
            int y = graph.getNode(x).get(i);
            //x와 y가 연결되어있다.
            if(!visited[y]) {
                DFS(y);
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

    public void sortGraph(int n) {
        Collections.sort(graph.get(n));
    }

    public boolean isAdjacent(int n, int m) {
        for(int i=0; i<graph.get(n).size(); i++) {
            if(graph.get(n).get(i) == m) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> getNode(int n) {
        return graph.get(n);
    }
}
