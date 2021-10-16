package breadthFirstSearch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기 {

    static int n;
    static int m;
    static int[][] map;
    static int[][] start;
    static int[][] end;
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n + 10][m + 10];
        start = new int[n + 10][m + 10];
        end = new int[n + 10][m + 10];
        visit = new boolean[n + 10][m + 10];

        for (int i = 1; i <= n; i++) {
            String numbers = sc.next();
            for (int j = 0; j < numbers.length(); j++) {
                int number = numbers.charAt(j) - '0';
                map[i][j + 1] = number;
            }
        }

        if (n == 1 && m == 1 && map[1][1] == 0) {
            System.out.println(1);
            return;
        }

        BFS(1,1, start);
        for (int i = 1; i <= n; i++) {
            Arrays.fill(visit[i], false);
        }
        BFS(n, m, end);

        int result = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(map[i][j] == 1 && start[i][j] > 0 && end[i][j] > 0) {
                    result = Math.min(result, start[i][j] + end[i][j]);
                }
            }
        }

        if (result == Integer.MAX_VALUE) {
            result = -1;
        } else {
            result += 1;
        }

        System.out.println(result);
    }

    static void BFS(int y, int x, int[][] cost) {
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

                if (my <= 0 || mx <= 0) {
                    continue;
                }

                if (!visit[my][mx] && my >= 1 && my <= n && mx >= 1 && mx <= m) {
                    visit[my][mx] = true;
                    cost[my][mx] = cost[currentY][currentX] + 1;
                    if (map[my][mx] == 0) {
                        queue.add(new Coordinate(my, mx));
                    }
                }
            }
        }
    }
}
