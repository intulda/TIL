package dynamicProgramming;

import java.util.Scanner;

public class 연속부분최대합3 {

    static int n;
    static int[] data;
    static int[] result;
    public static void main(String[] args) {
        //1 2 -4 5 3 -2 9 10
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        data = new int[n + 10];
        result = new int[n + 10];
        for(int i=0; i<n; i++) {
            data[i] = sc.nextInt();
        }
        //T(5) = 6
        //T(i) = max(T(i-1) + data[i], data[i]);
        result[0] = data[0];
        for(int i=1; i<n; i++) {
            result[i] = Math.max(result[i - 1] + data[i], data[i]);
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if(max < result[i]) {
                max = result[i];
            }
        }
        System.out.println(max);
    }
}

//O(n^2): 완전 탐색법
//O(n log n): 분할 정복법
//O(n): 동적 계획법
