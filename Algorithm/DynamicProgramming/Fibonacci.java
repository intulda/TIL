import java.util.Scanner;
public class Fibonacci {
    static int n;
    static int[] data;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        data = new int[n + 10];
        data[0] = 1;
        data[1] = 1;
        System.out.println(getFibonacci(2));
    }

    static int getFibonacci(int x) {
        if(x >= n) {
            return data[x - 1];
        } else {
            data[x] = data[x - 1] + data[x - 2];
            return getFibonacci(x + 1);
        }
    }
}