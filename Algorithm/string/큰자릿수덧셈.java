package string;

import java.util.Arrays;
import java.util.Scanner;

public class 큰자릿수덧셈 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String num1 = sc.next();
        String num2 = sc.next();

        int num1Size = num1.length();
        int num2Size = num2.length();

        if ("0".equals(num1)) {
            System.out.println(num2);
            return;
        }

        if ("0".equals(num2)) {
            System.out.println(num1);
            return;
        }

        int[] num1Arr = new int[num1Size + 10];
        int[] num2Arr = new int[num2Size + 10];

        int[] big;
        int[] small;

        int index = 0;
        for (int i = num1Size - 1; i >= 0; i--) {
            num1Arr[index++] = num1.charAt(i) - '0';
        }

        index = 0;
        for (int i = num2Size - 1; i >= 0; i--) {
            num2Arr[index++] = num2.charAt(i) - '0';
        }

        if (num1Size >= num2Size) {
            big = Arrays.copyOf(num1Arr, num1Size);
            small = Arrays.copyOf(num2Arr, num2Size);
        } else {
            big = Arrays.copyOf(num2Arr, num2Size);
            small = Arrays.copyOf(num1Arr, num1Size);
        }

        int temp = 0;
        for (int i = 0; i < big.length; i++) {
            int sum;
            if (i <= small.length - 1) {
                sum = big[i] + small[i] + temp;
                temp = 0;
                if (sum >= 10) {
                    sum -= 10;
                    temp++;
                }
            } else {
                sum = big[i] + temp;
                temp = 0;
                if (sum >= 10) {
                    sum -= 10;
                    temp++;
                }
            }

            sb.append(sum);

            if (i == big.length - 1 && temp != 0) {
                sb.append(temp);
            }
        }

        System.out.println(sb.reverse());
    }
}
