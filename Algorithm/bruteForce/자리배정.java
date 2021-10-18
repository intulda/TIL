package bruteForce;

import java.util.Scanner;

/**
 * 자리배정
 * 백준 10157 실버4문제
 */
public class 자리배정 {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int n;
    static int m;
    static int index = 0;
    static int maxValidation;
    static int[][] map;
    static int value = 1;
    static int number = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        number = sc.nextInt();
        maxValidation = n * m;
        map = new int[n + 10][m + 10];

        for (int i = 0; i <= n + 1; i++) {
            map[i][0] = -1;
            map[i][m + 1] = -1;
        }

        for (int i = 0; i <= m + 1; i++) {
            map[0][i] = -1;
            map[n + 1][i] = -1;
        }

        int y = 1;
        int x = 1;

        map[1][1] = value;
        while (maxValidation > value) {
            int my = y + dy[index];
            int mx = x + dx[index];

            if (map[my][mx] == 0) {
                value++;
                map[my][mx] = value;
                y = my;
                x = mx;
            } else {
                index++;
                if (index >= 4) {
                    index = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == number) {
                    System.out.print(i + " " + j);
                    return;
                }
            }
        }

        System.out.println(0);
    }
}
