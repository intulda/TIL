package recursion;

import java.util.Scanner;

public class Tobin {

    static int n;
    static int k;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];

        getResult(0, k);
    }

    static void getResult(int index, int k) {
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]);
            }
            System.out.println("");
            return;
        }

        if (index == n) {
            return;
        }

        arr[index] = 1;
        getResult(index + 1, k - 1);

        arr[index] = 0;
        getResult(index + 1, k);
    }
}
