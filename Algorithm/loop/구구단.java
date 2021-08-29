package loop;

import java.util.Scanner;

public class 구구단 {
    public static void main(String[] args) {
        /**
         * Q : 1 - 9 사이의 자연수를 입력받고, 그에 맞는 구구단을 출력하는 프로그램을 작성해보자.
         * I : 첫째 줄에 자연수N이 입력된다. ( 1 <= N <= 9 );
         * O : N에 해당하는 구구단을 출력한다. (단, 숫자와 문자 사이에 공백은 없다.)
         */

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for(int i=1; i<=9; i++) {
            System.out.printf("%d*%d=%d\n", num, i, num*i);
        }
    }
}
