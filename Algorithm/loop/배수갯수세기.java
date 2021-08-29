package loop;

import java.util.Scanner;

public class 배수갯수세기 {
    /**
     * Q: 세 개의 자연수 A, B, C가 주어진다. 이 때, A부터 B까지 숫자 중에서 C의 배수의 개수를 출력하는 프로그램을 작성하시오.
     *    예를 들어, A = 3, B = 9, C = 2 라고 하자. 그러면 3부터 9까지 숫자 중 2의 배수의 개수이므로 4, 6, 8 총 3개가 존재한다. 따라서 3을 출력한다.
     *    또한, A = 10, B = 3, C = 4라고 하자. 그러면 10에서 3까지 숫자 중 4의 배수의 개수이므로 4, 8 총 2개가 존재한다. 따라서 2를 출력한다.
     * I: 첫 번째 줄에 A, B, C가 주어진다. (1 <= A, B, C <= 1000)
     * O: A부터 B까지 숫자 중에서 C의 배수의 개수를 출력한다.
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int cnt = 0;
        int temp;

        if(a >= b) {
            temp = a;
            a = b;
            b = temp;
        }

        for(int i=a; i<=b; i++) {
            if(i % c == 0) {
                cnt++;
            }
        }
        System.out.printf("%d", cnt);
    }
}
