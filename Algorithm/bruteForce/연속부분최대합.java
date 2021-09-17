package bruteForce;

import java.util.Scanner;

public class 연속부분최대합 {

    static int n;
    static int[] data;
    static final int MAX = 110;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        data = new int[MAX];
        for(int i=0; i<n; i++) {
            data[i] = sc.nextInt();
        }

        int myMax = Integer.MIN_VALUE;
        for(int start=0; start<n; start++) {
            for(int end=start; end<n; end++) {
                int mySum = 0;

                for(int k=start; k<=end; k++) {
                    mySum += data[k];
                }

                if(mySum > myMax) {
                    myMax = mySum;
                }
            }
        }

        System.out.println(myMax);

    }
}
