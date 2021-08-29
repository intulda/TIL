package loop;

import java.util.Scanner;

public class 소수판별 {
    /**
     * Q: 자연수n이 주어질 때, n 이 소수인지 판별하는 프로그램을 작성하여라. 여기서 소수란, 약수가 1과 자기자신밖에 존재하지 않는 수를 말한다.
     * I: 첫째 줄에 자연수 n이 주어진다. (1≤n≤20,000)
     * O: 첫째 줄에 n이 소수이면 YES, 소수가 아니면 NO를 출력한다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        boolean flag = true;
        for(int i=1; i<=n; i++) {
            if(n % i == 0) {
                if(count > 2) {
                    flag = false;
                    break;
                }
                count++;
            }
        }

        if(flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
