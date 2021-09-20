package bruteForce;

import java.util.Scanner;

public class GoodSeq {
    /**
     * Q:
     * 숫자 1, 2, 3으로만 이루어지는 수열이 있다. 임의의 길이의 인접한 두 개의 부분 수열이 동일한 것 이 있으면, 그 수열을 나쁜 수열이라고 부른다.
     * 그렇지 않은 수열은 좋은 수열이다.
     *
     * 다음은 나쁜 수열의 예이다.
     * 33
     * 32121323
     * 123123213
     *
     * 다음은 좋은 수열의 예이다.
     *
     * 2
     * 32
     * 32123
     * 1232123
     *
     * 길이가 N인 좋은 수열들을 N자리의 정수로 보아 그중 가장 작은 수를 나타내는 수열을 구하는 프로그램 을 작성하라. 예를 들면, 1213121과 2123212는 모두 좋은 수열이지만 그 중에서 작은 수를 나타내는 수 열 1213121이다.
     *
     * I:
     * 입력은 숫자 N하나로 이루어진다. N은 1 이상 80 이하이다.
     *
     * O:
     * 첫 번째 줄에 1, 2, 3으로만 이루어져 있는 길이가 N인 좋은 수열들 중에서 가장 작은 수를 나타내 는 수열만 출력한다.
     * 수열을 이루는 1, 2, 3들 사이에는 빈칸을 두지 않는다.
     */

    static int[] result;
    static int n;
    static boolean isFinished = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        result = new int[n + 10];

        getResult(0);
    }

    static void getResult(int x) {
        // result[x]를 결정 한 후, result[x+1]부터 쭉 결정해 나가는 함수.
        // result[x] ~ result[n-1]까지 결정하는 함수.

        // 1. x번째 숫자를 결정한다.
        // 2. x+1번째 숫자를 결정하러 간다.

        //0 1 2 3 4 5 6 7   8   getResult(8);
        //1 2 1 3 1 2 3 1   ?

        // 1을 넣어본다. 괜찮은지 확인한다. 괜찮다면 getResult(x+1);
        // 2를 넣어본다. 괜찮은지 확인한다. 괜찮다면 getResult(x+1);
        // 3을 넣어본다. 괜찮은지 확인한다. 괜찮다면 gerResult(x+1);


        //123 123
        if(x >= n) {
            if(isFinished) {
                return;
            }
            for(int i=0; i<n; i++) {
                System.out.print(result[i]);
            }
            System.out.println("");
            isFinished = true;
        } else {
            for(int i=1; i<=3; i++) {
                result[x] = i;
                boolean flag = false;

                // 나누기 2의 이유는 123 123 일경우 최대 절반까지 확인을해야하기 때문이다.
               for(int j=1; j<=(x+1)/2; j++) {
                    if(!isPossible(x, j)) {
                        flag = true;
                        break;
                    }
                }

                if(!flag) {
                    getResult(x + 1);
                }
            }
        }
    }

    static boolean isPossible(int x, int length) {
        // result[x]가 오른쪽 끝이고, 길이 length의 중복이 있는지판별
        // 중복이 없다면 true 아니면 false
        for(int i=0; i<length; i++) {
            if(result[x - i] != result[x - i - length]) {
                return true;
            }
        }
        return false;
    }
}
