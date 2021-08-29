package bruteForce;

import java.util.Scanner;

public class GCDLCM {
    /**
     * Q: 두 개의 자연수를 입력받아 최대공약수(GCD)와 최소공배수(LCM)를 출력하는 프로그램을 작성하시오.
     * I: 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000 이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
     * O: 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소공배수를 출력한다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int first = n;
        int second = m;
        int temp = -1;
        while(true) {
            temp = first % second;
            if(temp == 0) {
                break;
            }
            first = second;
            second = temp;
        }

        System.out.println(second);
        System.out.println(n * m / second);
    }
}
