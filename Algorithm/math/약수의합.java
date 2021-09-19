package math;

import java.util.Arrays;
import java.util.Scanner;

public class 약수의합 {

    static long[] arr;
    static long[] result;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        final int SIZE = 1_000_000;
        arr = new long[SIZE + 100];
        result = new long[SIZE + 100];

        Arrays.fill(arr, 1);
        for(int i=2; i<=SIZE; i++) {
            for(int j=1; i*j<=SIZE; j++) {
                arr[i * j] += i;
            }
        }

        for(int i=1; i<=SIZE; i++) {
            result[i] += result[i - 1] + arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            int num = sc.nextInt();
            sb.append(result[num]).append("\n");
        }
        System.out.println(sb);

    }
}
