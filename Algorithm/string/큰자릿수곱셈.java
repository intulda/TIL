package string;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class 큰자릿수곱셈 {
    static StringBuilder sb;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        String num1 = sc.next();
        String num2 = sc.next();

        if ("0".equals(num1) || "0".equals(num2)) {
            System.out.println(0);
            return;
        }

        int num1Size = num1.length();
        int num2Size = num2.length();

        int[] num1Arr = getReverseNumber(num1, num1Size);
        int[] num2Arr = getReverseNumber(num2, num2Size);

        ArrayList<String> temps = new ArrayList<>();

        int[] big;
        int[] small;

        if (num1Size >= num2Size) {
            big = Arrays.copyOf(num1Arr, num1Size);
            small = Arrays.copyOf(num2Arr, num2Size);
        } else {
            big = Arrays.copyOf(num2Arr, num2Size);
            small = Arrays.copyOf(num1Arr, num1Size);
        }

        int temp = 0;
        for (int i = 0; i < small.length; i++) {

            for (int j = 0; j < i; j++) {
                sb.append("0");
            }

            for (int j = 0; j < big.length; j++) {
                int sum = (small[i] * big[j]) + temp;
                temp = 0;
                if (sum >= 10) {
                    temp = sum / 10;
                    sum %= 10;
                }

                sb.append(sum);

                if (j == big.length - 1 && temp != 0) {
                    sb.append(temp);
                    temp = 0;
                }
            }

            temps.add(sb.toString());
            sb.setLength(0);
        }

        String result = temps.get(0);

        if (temps.size() > 1) {
            for (int i = 1; i < temps.size(); i++) {
                result = getSumNumber(result, temps.get(i));
            }
        } else {
            sb.append(result);
        }

        System.out.println(sb.reverse());
    }

    static String getSumNumber(String num, String num2) {
        sb.setLength(0);
        int numSize = num.length();
        int num2Size = num2.length();

        int[] _big;
        int[] _small;

        if (numSize < num2Size) {
            _big = getStringToNumberArray(num2);
            _small = getStringToNumberArray(num);
        } else {
            _big = getStringToNumberArray(num);
            _small = getStringToNumberArray(num2);
        }

        int temp = 0;
        for (int i = 0; i < _big.length; i++) {
            int sum = 0;
            if (i <= _small.length - 1) {
                sum = _big[i] + _small[i] + temp;
                temp = 0;
                if (sum >= 10) {
                    sum -= 10;
                    temp++;
                }
            } else {
                sum = _big[i] + temp;
                temp = 0;
                if (sum >= 10) {
                    sum -= 10;
                    temp++;
                }
            }

            sb.append(sum);

            if (i == _big.length - 1 && temp != 0) {
                sb.append(temp);
            }
        }

        return sb.toString();
    }

    static int[] getReverseNumber(String str, int size) {
        int index = 0;
        int[] temp = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            temp[index++] = str.charAt(i) - '0';
        }
        return temp;
    }

    static int[] getStringToNumberArray(String str) {
        int index = 0;
        int size = str.length();
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[index++] = str.charAt(i) - '0';
        }
        return temp;
    }
}
