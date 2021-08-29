package bruteForce;

import java.util.Scanner;

public class 상자꾸미기 {
    /**
     * Q: 면이 6개인 상자가 있다. 이를 여러 가지 색종이를 붙여 꾸밀려고 하는데, 단 조건이 있다. 인접한 면에 같은 색의 색종이를 붙이면 안 된다는 것이다. 또한, 한 면에는 한 장의 색종이만 붙일 수 있다. 여러 가지 색의 색종이들이 주어졌을 때, 조건을 만족하여 상자의 모든 면에 붙일 수 있는지 판별하는 프로그램을 작성하시오
     * I: 첫째 줄에 색종이의 장수 N ( 1 <= N <= 1,000 ) 이 주어진다. 둘째 줄에 각각의 색종이의 색깔을 나타내는 N개의 숫자가 주어진다. 색깔은 양의 정수로 이루어져 있고, 1부터 N까지의 범위의 수이다.
     * O: 조건을 만족하면서 상자를 꾸밀 수 있으면 “YES”, 아니면 “NO”를 출력한다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[1010];
        int check = 0;
        for(int i=1; i<=n; i++) {
            arr[sc.nextInt()]++;
        }

        for(int i=1; i<=n; i++) {
            if(arr[i] < 2) {
                check += arr[i];
            } else {
                check += 2;
            }
        }
        if(check >= 6) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
