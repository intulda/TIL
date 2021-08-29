package bruteForce;

import java.util.Scanner;

public class Maxofarr {
    /**
     * Q: 9×9 격자판에 쓰여진 81개의 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 행 몇 열에 위치한 수인지 구하는 프로그램을 작성하시오.
     * 예를 들어, 다음과 같이 81개의 수가 주어지면 이들 중 최댓값은 90이고, 이 값은 5행 7열에 위치한다.
     *
     * I: 첫째 줄부터 아홉 번째 줄까지 한 줄에 아홉 개씩 자연수가 주어진다. 주어지는 자연수는 100보다 작다.
     * O: 첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 위치한 행 번호와 열 번호를 빈칸을 사이에 두고 차례로 출력한다. 최댓값이 두 개 이상인 경우 그 중 행의 번호가 가장 작은 곳의 위치를 출력한다. 행 번호도 같은 곳이 여러개일 경우에는 열 번호가 가장 작은 곳의 위치를 출력한다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = 9;
        int[][] arr = new int[size + 10][size + 10];
        int max = 0;
        int x = 0;
        int y = 0;

        for(int i=1; i<=size; i++) {
            for(int j=1; j<=size; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i=1; i<=size; i++) {
            for (int j=1; j<=size; j++) {
                if(arr[i][j] > max) {
                    max = arr[i][j];
                    x = j;
                    y = i;
                }
            }
        }

        System.out.println(max);
        System.out.println(y + " " + x);
    }
}
