package breadthFirstSearch;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색 {


    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(Arrays.deepToString(map));


    }

    static void BFS(int y, int x) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(y, x));

        while (!queue.isEmpty()) {
            Coordinate node = queue.poll();
            int currentY = node.getY();
            int currentX = node.getX();

            for (int i = 0; i < 4; i++) {
                int my = currentY + dy[i];
                int mx = currentX + dx[i];

            }
        }
    }
}
