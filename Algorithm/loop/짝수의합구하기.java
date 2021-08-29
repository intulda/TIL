package loop;

import java.util.Scanner;

public class 짝수의합구하기 {
    /**
     * Q: 1부터 N까지의 숫자 중 짝수의 합을 구하는 프로그램을 작성하여라.
     * I: 첫째 줄에 N이 주어진다. (1 <= N <= 2000)
     * O: 1부터 N까지의 숫자 중 짝수의 합을 출력한다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int sum = 0;
        for(int i=1; i<=number; i++) {
            if(i % 2 == 0) {
                sum += i;
            }
        }
        System.out.printf("%d", sum);
    }
}
