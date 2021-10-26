package recursion;

import java.util.Scanner;

public class Mountain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        getMountain(n);
    }

    static void getMountain(int num) {
        if (num == 1) {
            System.out.print("1");
        } else {
            getMountain(num - 1);
            System.out.print(num);
            getMountain(num - 1);
        }
    }

}
