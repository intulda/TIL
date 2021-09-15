import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //60 //100 -> 시간복잡도는 같아 -> O(n)

        int[] arr = new int[n + 10];
        long count = 0;
        for(int i=0; i<n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }
        // 1 0 1 1 1
        // 1 x 1 1 1 -> 1
        // 1 x 1 x 1 -> 2
        //     1  1  -> 2;

        // 1 1 0 1 1
        //   c   c c
        // 1 1 x 1 1 -> 1

        // 1 1 1 1 1
        // 1 1 1 1 1 -> 1
        // 1 x 1 1 1 -> 2
        // 1 1 x 1 1 -> 3
        // 1 x 1 x 1 -> 4

        //     C
        // 2 3 4

        //1 0 1 1 1 1 1
        //1 x 1 1 1 1 1 -> 1
        //1 x 1 x 1 x 1 -> 2
        //1 x 1 1 x 1 1 -> 3

        //1 1 1 1 1 1 1
        //1 1 1 1 1 1 1 -> 1
        //2 + 2 + 2 + 2 + 2 -> 10?

        //1 1 1 1
        //1 1 1 1 -> 1
        //1 x 1 1 -> 2
        //1 1 x 1 -> 3






        //1 x 1 1 1 1 1 -> 2
        //1 1 x 1 1 1 1 -> 3
        //1 1 1 x 1 1 1 -> 4
        //1 1 1 1 x 1 1 -> 5
        //1 1 1 1 1 x 1 -> 6
        //1 x 1 x 1 1 1 -> 7
        //1 x 1 x 1 x 1 -> 8

        for(int i=0; i<n; i++) {
            if(arr[i + 1] == 1 && arr[i + 2] == 1) {
                count += 2;
            } else if(arr[i + 1] == 0 || arr[i + 2] == 0) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
