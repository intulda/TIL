package sort;

import java.util.Scanner;
/**
 * 백준 2750번 문제
 */
public class 수정렬하기 {
    static int n;
    static int[] numbers;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        numbers = new int[n + 10];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        int temp;
        for (int i = 1; i < n; i++) {
            if (numbers[i - 1] > numbers[i]) {
                temp = numbers[i - 1];
                numbers[i - 1] = numbers[i];
                numbers[i] = temp;
                i = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(numbers[i]);
        }
    }

}
