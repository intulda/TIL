package search;

import java.util.Scanner;

public class NN단표 {
    /**
     *
       Q:알랩이는 구구단표처럼 NN단표를 만들었다고 한다.
         NN단표는 2차원 배열의 모양으로 곱셈 1단부터 N단까지의 값들을 적어놓은 형태이다.
         NN단표의 배열을 A라고 했을 때, 배열의 들어가는 수 A[i][j]=i*j이다.(즉, 4행 7열에는 28, 7행 5열에는 35가 들어가 있다.)
         알랩이는 N단까지 나온 숫자들 중에서 K번째로 작은 수를 찾고 싶어한다.
         이때, 중복되는 여러 수들을 고려한다. 즉 N*N개의 모든 수들 중에서 K번째 수를 구하는 것이다.

       I: 첫째 줄에 배열의 크기 N이 주어진다. N은 100,000보다 작거나 같은 자연수이다. 둘째 줄에 K가 주어진다. K는 N*N보다 작거나 같은 자연수이다.

       O:K번째 원소를 출력한다
     */
    static long n;
    static long k;
    public static void main(String[] args) {
        // k = 8;
        // 1 2 3 4 5 6
        // 2 4 6 8 10 12
        // 3 6 9 12 15 18


        // 4 8 12 16
        // 1 2 2 3 3 4 4 4 6 6 8 8 9 12 12 16
        // 1 2 3 4 5 6 7 8 9 10 11
        // 6보다 작은 숫자의 갯수를 센다
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        k = sc.nextLong();

        long start = 1;
        long end = n * n + 1;

        while(start + 1 < end) {
            long mid = (start + end) / 2;
            long midOrder = getOrder(mid);
            if(midOrder <= k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        System.out.println(start);
    }

    static long getOrder(long x) {
        long result = 0;
        for(int i=1; i<=n; i++) {
            if(i * n < x) {
                result += i;
            } else {
                if(x % i == 0) {
                    result += (x / i) - 1;
                } else {
                    result += x / i;
                }
            }
        }
        return result + 1;
    }
}
