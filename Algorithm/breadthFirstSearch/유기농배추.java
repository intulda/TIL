package breadthFirstSearch;

import java.util.*;

public class 유기농배추 {

    static int testCase;
    static int n;
    static int m;
    static int k;
    static int[][] map;
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] result;
    static final int MAX = 2_510;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        testCase = sc.nextInt();
        result = new int[testCase + 10];
        for (int i = 0; i < testCase; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            k = sc.nextInt();

            map = new int[MAX][MAX];
            visit = new boolean[MAX][MAX];

            for (int j = 0; j < k; j++) {
                Arrays.fill(visit[j], false);
            }

            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                map[x][y] = 1;
            }

            count = 0;
            for (int j = 0; j < n; j++) {
                for (int p = 0; p < m; p++) {
                    if (!visit[j][p] && map[j][p] == 1) {
                        BFS(j, p);
                        count++;
                    }
                }
            }
            result[i] = count;
        }

        for (int i = 0; i < testCase; i++) {
            System.out.println(result[i]);
        }
    }

    static void BFS(int y, int x) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(y, x));
        visit[y][x] = true;

        while (!queue.isEmpty()) {
            Coordinate node = queue.poll();
            int currentY = node.getY();
            int currentX = node.getX();

            for (int i = 0; i < 4; i++) {
                int my = currentY + dy[i];
                int mx = currentX + dx[i];

                if (my < 0 || mx < 0 || my > n || mx > m) {
                    continue;
                }

                if(!visit[my][mx] && map[my][mx] == 1) {
                    visit[my][mx] = true;
                    queue.add(new Coordinate(my, mx));
                }

            }
        }

    }
}

