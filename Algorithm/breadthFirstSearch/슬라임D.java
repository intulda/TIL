package breadthFirstSearch;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class 슬라임D {

    static int n;
    static int m;
    static int massX;
    static int massY;
    static boolean[][] visit;
    static ArrayList<Integer> result;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int sum = 0;
    static int count = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n + 10][m + 10];
        visit = new boolean[n + 10][m + 10];
        result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        massX = sc.nextInt();
        massY = sc.nextInt();

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                cnt = count;
                sum = 0;
                BFS(i, j);

                if(cnt != count) {
                    count++;
                    sum += map[i][j];
                }

                if(sum > 0) {
                    result.add(sum/count);
                    count = 0;
                }
            }
        }

        if(result.size() > 0) {
            Collections.sort(result, Collections.reverseOrder());
            for(int i=0; i<result.size(); i++) {
                System.out.println(result.get(i));
            }
        } else {

            System.out.println(-1);
        }


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

                int nextValue = map[currentY][currentX] - map[my][mx];
                if(nextValue < 0) {
                    nextValue *= -1;
                }

                if(!visit[my][mx] && nextValue >= massX && nextValue <= massY) {
                    queue.add(new Coordinate(my, mx));
                    visit[my][mx] = true;
                    sum += map[my][mx];
                    count++;
                }
            }
        }
    }
}