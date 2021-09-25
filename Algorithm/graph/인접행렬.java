package graph;

import java.util.Scanner;

public class 인접행렬 {

    static final int MAX = 10;
    public static void main(String[] args) {
        //5 6 (정점의 갯수, 간선의 갯수)
        //1 2
        //1 3
        //1 4
        //2 4
        //4 5
        //3 5
        //a와 b와 연결되있냐
        //a와 연결되있는 놈들을 뱉어라
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[MAX][MAX];

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }

        //O(1)
        System.out.println(isConnected(arr, 1, 2)); //1
        System.out.println(isConnected(arr, 1, 5)); //0
        System.out.println(isConnected(arr, 3, 5)); //1

        //O(n)
        getAdjacentNode(arr, n, 2); //1 4
        getAdjacentNode(arr, n, 4); //1 2 5
    }

    //Q1. 정점 X와 Y가 연결이 되어 있는가? YES/NO
    //Q2. 정점 X와 연결이 되어 있는 모든 정점을 출력하라.


    static boolean isConnected(int[][] graph, int x, int y) {
        //graph 에서 x와 y가 연결이 되어 있으면 true 아니면 false
        return graph[x][y] == 1;
    }

    static void getAdjacentNode(int[][] graph, int n, int x) {
        //adjacent(인접한) node
        for(int i=1; i<=n; i++) {
            if(graph[x][i] == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println("");
    }

}
