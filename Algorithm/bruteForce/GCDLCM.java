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

        int temp;
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

    /**
     *
     * A    B => G   (A > B)
     * 18  12
     *
     * A / B = q ... r
     * 18  12  1     6
     *
     * A = aG
     * B = bG
     *
     * (a = b)서로소 : 두 자연수의 공약수가 1밖에 없는 숫자
     *  2   3
     *
     * [ A = Bq + r ]
     * aG = bGq + r
     *
     * r = (a - bq)G;
     *
     * B = bG;
     *
     * 서로소 임을 증명해야함
     *
     * ----서로소가 아니다----
     *
     * (P = 1!=다른 공약수)
     * a - bq = mP
     * b = nP
     *
     * a - nPq = mP == 1
     * a = (nq + m)P == 1
     * b = nP
     *
     * 서로수가 아닌게 맞음
     * 서로수가 아닌게 아니라서 a, b서로소 임이 증명된다.
     *
     */
}
