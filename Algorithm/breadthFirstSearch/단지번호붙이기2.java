package breadthFirstSearch;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class 단지번호붙이기2 {

    static int n;
    static int[][] map;
    static boolean[][] visit;
    static int allCount = 0;
    static int count = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static ArrayList<Integer> result;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        map = new int[n + 10][n + 10];
        visit = new boolean[n + 10][n + 10];
        result = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            String number = sc.nextLine();
            for(int j=0; j<number.length(); j++) {
                char num = number.charAt(j);
                int value = 0;
                if(num == '0') {
                    value = 0;
                } else {
                    value = 1;
                }
                map[i][j + 1] = value;
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(map[i][j] == 1 && !visit[i][j]) {
                    BFS(i, j);
                    allCount++;
                    result.add(count);
                }
                count = 0;
            }
        }

        Collections.sort(result);
        System.out.println(allCount);
        for(int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    static void BFS(int y, int x) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(y, x));
        visit[y][x] = true;
        count++;

        while (!queue.isEmpty()) {
            Coordinate node = queue.poll();
            int currentY = node.getY();
            int currentX = node.getX();

            for(int i=0; i<4; i++) {
                int my = currentY + dy[i];
                int mx = currentX + dx[i];

                if(map[my][mx] <= 0) {
                    continue;
                }

                if(!visit[my][mx] && map[my][mx] == 1) {
                    queue.add(new Coordinate(my, mx));
                    visit[my][mx] = true;
                    count++;
                }
            }
        }
    }
}
