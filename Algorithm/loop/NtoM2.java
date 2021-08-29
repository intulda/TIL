package loop;

import java.util.Scanner;

public class NtoM2 {
    /**
     * Q: N부터 M까지 출력하는 프로그램을 작성해보자.
     * I: 첫째 줄에 자연수 N과 자연수 M이 공백을 가지고 주어진다. (N ≤ M ≤ 1,000)
     * O: 첫째 줄에 N부터 M까지의 자연수를 공백을 사이에 두고 차례대로 출력한다. (단, 한 줄에 최대 8개씩 출력해야 한다.)
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int cnt = 1;
        for(int i=n; i<=m; i++) {
            if(cnt == 8) {
                System.out.printf("%d\n", i);
                cnt = 0;
            } else {
                System.out.printf("%d ", i);
            }
            cnt++;
        }
    }
}
