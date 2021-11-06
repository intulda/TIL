package breadthFirstSearch;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 미로탐색 {

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

    static void BFS() {

    }
}
