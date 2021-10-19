package dynamicProgramming;

import java.util.Scanner;

public class 숫자만들기 {
    static int MAX = 100;
    static int[] table;
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        table = new int[MAX];
        //M = 4;

        //table[1] = 1
        //table[2] = table[1] + 1
        //table[3] = table[2] + table[1] + 1;
        //table[4] = table[3] + table[2] + table[1] + 1
        //1 ~ M 까지

        //table[5] = table[1] + table[2] + table[3] + table[4]
        //T(i) = 1 ~ M의 수를 이용하여 i를 만드는 경우의 수
        //M = 3
        //T(4) = 7
        //T(i) = i - 1;
        //T(i) = i - 2;
        //T(i) = i - 3;
        //T(i) = i - M;
        //T(7) = T - 6 + T - 5 + T - 4

        //1. Table을 어떻게 정의했는지
        //2. 점화식을 어떻게 세웠는지


        //1 ~ M 기조조건
        table[1] = 1;
        int sum = 0;
        for(int i=2; i<=m; i++) {
            sum += table[i - 1];
            table[i] = sum + 1;
        }

        //그 이후값
        for(int i=m+1; i<=n; i++) {
            for(int j=i-m; j<=i-1; j++) {
                table[i] += table[j];
            }
        }

        System.out.println(table[n]);
    }
}
