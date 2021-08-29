package bruteForce;

import java.util.Scanner;

public class Offset {
    /**
     * Q: 5x5 2차원 배열이 주어질 때 어떤 원소가 상하좌우에 있는 원소보다 작을 때 해당 위치에 * 을 표시하는 프로그램을 작성하시오. 경계선에 있는 수는 상하좌우 중 존재하는 원소만을 비교한다.
     * I: 5x5 행렬의 정보가 25 개의 수로 주어진다. 각 수는 0 에서 9 사이 수이다.
     * O: *를 포함한 행렬을 출력예의 형식으로 출력한다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[15][15];

        for(int i=1; i<=5; i++) {
            for(int j=1; j<=5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<=5+1; i++) {
            arr[i][5 + 1] = 10;
            arr[i][0] = 10;
            arr[5 + 1][i] = 10;
            arr[0][i] = 10;
        }

        for(int i=1; i<=5; i++) {
            for(int j=1; j<=5; j++) {
                if(arr[i][j] < arr[i - 1][j] &&
                   arr[i][j] < arr[i + 1][j] &&
                   arr[i][j] < arr[i][j - 1] &&
                   arr[i][j] < arr[i][j + 1]
                ) {
                    System.out.print("*");
                } else {
                    System.out.print(arr[i][j]);
                }
            }
            System.out.println("");
        }
    }
}
