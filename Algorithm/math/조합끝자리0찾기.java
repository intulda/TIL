package math;

import java.util.Scanner;

public class 조합끝자리0찾기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();

        //소인수 분해의 성질을 이용한다
        long fiveMulti = getMultiplier(5, n) - getMultiplier(5, n - m) - getMultiplier(5, m);
        long twoMulti = getMultiplier(2, n) - getMultiplier(2, n - m) - getMultiplier(2, m);

        long multi = Math.min(fiveMulti, twoMulti);
        System.out.println(multi);
    }

    static long getMultiplier(int mul, long n) {
        long count = 0;

        while (n >= mul) {
            count += n/mul;
            n /= mul;
        }

        return count;
    }
}
