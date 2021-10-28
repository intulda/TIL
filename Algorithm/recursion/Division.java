package recursion;

import java.util.Scanner;

public class Division {
    static int[] result;
    static int n;
    static int cnt;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        result = new int[30];
        getResult(0, 0);
        System.out.printf("%d", cnt);
    }

    static void getResult(int mySum, int index) {
        //현재까지 구한 합이 mySum이다.
        // 그리고 지금, index번째 숫자를 결정할 차례
        if (mySum == n) {
            System.out.printf("%d", result[0]);
            for (int i = 1; i < index; i++) {
                System.out.printf("+%d", result[i]);
            }
            System.out.println("");
            cnt++;
        } else {
            int myNumber;
            if (index == 0) {
                myNumber = n - 1;
            } else {
                myNumber = n - mySum;
            }
            for (int i = myNumber; i >= 1; i--) {
                result[index] = i;
                if (index > 0 && result[index - 1] < result[index]) {
                    continue;
                }
                getResult(mySum + i, index + 1);
            }
        }
    }
}
