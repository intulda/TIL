package breadthFirstSearch;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class 단지번호붙이기2_1 {

    static char[][] map;
    static int n;
    static boolean[][] visit;
    static int count = 0;
    static int allCount = 0;
    static ArrayList<Integer> result;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();//enter

        map = new char[n + 10][n + 10];
        visit = new boolean[n + 10][n + 10];
        result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < line.length(); j++) {
                char number = line.charAt(j);
                map[i][j + 1] = number;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                count = 0;
                if(!visit[i][j] && map[i][j] == '1') {
                    BFS(i, j);
                    allCount++;
                    result.add(count);
                }
            }
        }

        System.out.println(allCount);
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    static void BFS(int y, int x) {
        Queue<Coordinate> queue = new LinkedList<>();
        visit[y][x] = true;
        queue.add(new Coordinate(y, x));
        count++;
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

                if (!visit[my][mx] && map[my][mx] == '1') {
                    visit[my][mx] = true;
                    queue.add(new Coordinate(my, mx));
                    count++;
                }
            }
        }
    }
}

