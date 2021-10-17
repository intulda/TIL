package bruteForce;

import java.util.Scanner;

public class 형렬뒤집기 {
    static final int SIZE = 10;
    static int[][] map;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new int[SIZE + 10][SIZE + 10];

        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < SIZE + 1; i++) {
            map[i][0] = -1;
            map[i][SIZE + 1] = -1;
            map[0][i] = -1;
            map[SIZE + 1][i] = -1;
        }

        getReuslt(1);

        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static void getReuslt(int x) {
        if (x > n) {
            return;
        } else {
            map[x][x] = getRevers(map[x][x]);

            for (int j = 1; j < SIZE; j++) {
                //상
                for (int i = x; i >= 1; i--) {
                    if (map[i][x] == -1) {
                        break;
                    } else {
                        map[i][x] = getRevers(map[i][x]);
                    }
                }
                //하
                for (int i = x; i <= SIZE; i++) {
                    if (map[i][x] == -1) {
                        break;
                    } else {
                        map[i][x] = getRevers(map[i][x]);
                    }
                }
                //좌
                for (int i = x; i >= 1; i--) {
                    if (map[x][i] == -1) {
                        break;
                    } else {
                        map[x][i] = getRevers(map[x][i]);
                    }
                }
                //우
                for (int i = x; i <= SIZE; i++) {
                    if (map[x][i] == -1) {
                        break;
                    } else {
                        map[x][i] = getRevers(map[x][i]);
                    }
                }
            }

            getReuslt(x + 1);
        }
    }

    static int getRevers(int x) {
        return x == 1 ? 0 : 1;
    }
}