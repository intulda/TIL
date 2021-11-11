package recursion;

import java.util.Scanner;

public class
코치배정A {

    static int[] result;
    static int[] arr;
    static int s;
    static int m;
    static int t;
    static int count = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();

        arr = new int[s + 10];
        result = new int[s + 10];

        for (int i = 0; i < s; i++) {
            arr[i] = sc.nextInt();
        }

        getResult(0);
    }

    static void getResult(int index) {
        if (index >= m) {
            count++;
            if (count == t) {
                int max = 0;
                for (int i = 0; i < m; i++) {
                    max += arr[result[i]];
                }
                System.out.println(max);
            }
        } else {
            for (int i = 0; i < s; i++) {
                if (index == 0 || result[index - 1] < i) {
                    result[index] = i;
                    getResult(index + 1);
                    result[index] = 0;
                }
            }
        }
    }
}
