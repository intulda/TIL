package bruteForce;

import java.util.Scanner;

public class 연속부분최대합 {

    static int n;
    static int[] data;
    static int[] sum;
    static final int MAX = 110;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        data = new int[MAX];
        sum = new int[MAX];
        for(int i=0; i<n; i++) {
            data[i] = sc.nextInt();
        }

        //시간복잡도가 n이 100일때는 가능하지만 1000일때는 안된다.
        int myMax = Integer.MIN_VALUE;
//        for(int start=0; start<n; start++) {
//            for(int end=start; end<n; end++) {
//                int mySum = 0;
//
//                for(int k=start; k<=end; k++) {
//                    mySum += data[k];
//                }
//
//                if(mySum > myMax) {
//                    myMax = mySum;
//                }
//            }
//        }
//
//        System.out.println("O(n3) : " + myMax);

        //합산
        sum[0] = data[0];
        for(int i=1; i<=n; i++) {
            sum[i] = sum[i - 1] + data[i];
        }

        for(int start=0; start<n; start++) {
            for(int end=start; end<n; end++) {
                int mySum;

                //start ~ end 까지의 합
                //(1 ~ end 까지의 합) - (1 ~ (start-1) 까지의 합)
                // sum[end] - sum[start - 1];

                // 1 4 8 2 -3 -4 -6 2 1 10
                // s           e

                if(start == 0) {
                    mySum = sum[end];
                } else {
                    mySum = sum[end] - sum[start - 1];
                }

                if(mySum > myMax) {
                    myMax = mySum;
                }
            }
        }

        System.out.println("O(n2) : " + myMax);

    }
}
