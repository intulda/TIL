package breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 슬라임B {

    static int n;
    static int m;
    static int massX;
    static int massY;
    static int[][] map;
    static int count = 0;
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n + 10][m + 10];
        visit = new boolean[n + 10][m + 10];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        massX = sc.nextInt();
        massY = sc.nextInt();

        BFS(1, 1);
        System.out.println(count);
    }

    static void BFS(int y, int x) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(y, x));
        visit[y][x] = true;
        while (!queue.isEmpty()) {
            Coordinate currentNode = queue.poll();
            int currentY = currentNode.getY();
            int currentX = currentNode.getX();

            for (int i = 0; i < 4; i++) {
                int my = currentY + dy[i];
                int mx = currentX + dx[i];

                if(map[my][mx] <= 0) {
                    continue;
                }
                int node = map[currentY][currentX] - map[my][mx];

                if (node < 0) {
                    node *= -1;
                }

                if (!visit[my][mx] && node >= massX && node <= massY) {
                    queue.add(new Coordinate(my, mx));
                    visit[my][mx] = true;
                    count++;
                }
            }
        }
    }
}

class Coordinate {
    private int y;
    private int x;

    public Coordinate(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
