package loop;

import java.util.Scanner;

public class NtoM {
    public static void main(String[] args) {
        /**
         * Q : N부터 M까지 출력하는 프로그램을 작성해보자.
         * I : 첫째 줄에 자연수 N과 자연수 M이 공백을 가지고 주어진다. (N ≤ M ≤ 1000);
         * O : 첫째 줄에 N부터 M까지의 자연수를 공백을 사이에 두고 차례대로 출력한다.
         */

        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();

        for(int i=first; i<=second; i++) {
            System.out.printf("%d ", i);
        }
    }
}
