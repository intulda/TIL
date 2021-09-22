package recursion;

import java.util.Scanner;

public class 연속부분최대합2 {

    //분할정복으로 푸는 연속부분 최대합
    static int[] data;
    static int n;
    public static void main(String[] args) {
        //2 1 -1 5 -10 3 2 5 -3 7 9 -10
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        data = new int[n + 10];

        for(int i=0; i<n; i++) {
            data[i] = sc.nextInt();
        }

        System.out.println(getSubMax(0, n - 1));


        //전체 경우 = ( 왼쪽만 고려 ) + ( 오른쪽만 고려 ) + ( 자른 지점을 포함 )
    }

    static int getSubMax(int start, int end) {
        // data의 start부터 end까지 구간 중 연속 부분 최대합을 구해주는 함수.
        if(start >= end) {
            return data[start];
        } else {
            int mid = (start + end) / 2;
            //구간을 정해줘야함
            int left = getSubMax(start, mid);
            int right = getSubMax(mid+1, end);

            //중간부분을 포함하는 연속부분 중 최대합을 구하자.

            //1 8 -5 3 | 2 5 -10 2
            int leftSum = 0;
            int leftMax = Integer.MIN_VALUE;
            for(int i=mid; i>=start; i--) {
                leftSum = leftSum + data[i];

                if(leftMax < leftSum) {
                    leftMax = leftSum;
                }
            }

            int rightSum = 0;
            int rightMax = Integer.MIN_VALUE;
            for(int i=mid+1; i<=end; i++) {
                rightSum = rightSum + data[i];
                if(rightMax < rightSum) {
                    rightMax = rightSum;
                }
            }

            int midMax = leftMax + rightMax;

            if(left >= right && left >= midMax) {
                return left;
            } else if(right >= left && right >= midMax) {
                return right;
            } else {
                return midMax;
            }
        }
    }
}
