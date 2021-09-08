package search;

import java.util.Scanner;

public class ParametricSearch {
    //구간의 합
    //n = 7 s = 14
    //s만큼의 숫자와 같거나 큰 구간의 합을 구하여라.
    //2 1 8 1 3 7 2 6 3
    //투 포인트 기



    /**
     * interval = 3;
     * n = 7;
     *
     * n - interval = 4;
     *
     * for(int i=0; i<n-interval; i++) {
     *  sum = sum - data[i] + data[i + interval];
     *  sum = 0 - data[0] + data[0 + 3];
     *               2          1
     *  sum = -1
     *  sum = -1 - data[1] + data[1 + 3];
     *               1          3
     * }
     *
     */



    static int n;
    static int s;
    static int MAX = 100_005;
    static int[] data;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        data = new int[MAX];

        for(int i=0; i<n; i++) {
            data[i] = sc.nextInt();
        }

        int start = 1; //start는 X를 가르키고
        int end = n;//end는 무조건 O를 가르킨다.

        if(check(1)) {
            System.out.println(1);
            return;
        }

        if(!check(n)) {
            System.out.println(-1);
            return;
        }


        //123456...101112
        //XXXXXX... X O O
        //          s e
        //s와 e가 붙기전까지
        while(start+1 < end) {
            int mid = (start + end) / 2;
            if(check(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        System.out.println(end);
    }

    static boolean check(int interval) {
        //구간의 길이 interval만큼 정했을 때, 그합이 S이상인 경우가 있는가?
        //있으면 true 없으면 false;
        int sum = 0;
        for(int i=0; i<interval; i++) {
            sum += data[i];
        }

        if(sum >= s) {
            return true;
        }

        for(int i=0; i<n-interval; i++) {
            sum = sum - data[i] + data[i + interval];
            if(sum >= s) {
                return true;
            }
        }
        return false;
    }
}
