package recursion;

import java.util.Scanner;

public class 거듭제곱구하기 {

    /**
     * 1. 함수의 정의: 함수의 의미를 "말로" 정의한다.
     * 2. 점화식: 나보다 작은 함수는 값을 잘 구한다고 가정하고, 이들을 이용해서 나를 구하기 위한 식을 적는다.
     * 3. 기저조건
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(getResult(n, m));
    }

    static int getResult(int n, int m) {
        //n^m을 10_007로 ㄴ ㅏ눈 나머지를 반환하는 함수
        if(m == 0) {
            return 1;
        } else {
            if(m % 2 == 0) {
                //거듭제곱이 짝수일 때  n^m = (n^(m/2))^2
                int temp = getResult(n, m/2);
                return (temp * temp) % 10_007;
            } else {
                //거듭제곱이 홀수 일 때 n^m = (n^(m-1)) * n;
                int temp = getResult(n, m-1);
                return (temp * n) % 10_007;
            }
        }
    }
}


//x^0 = 1 정의되어있음;